/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package slot4.long21;


/**
 *
 * @author ADMIN
 */
import slot4.Validator;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class StudentManager extends Menu<String> {
    private final ArrayList<Student> studentList = new ArrayList<>();

    public StudentManager(String title, String[] choices) {
        super(title, choices);
    }
    
    // Phương thức kiểm tra ID tồn tại
    private boolean isIdExist(int id) {
        return studentList.stream().anyMatch(s -> s.getId() == id);
    }

    @Override
    public void execute(int ch) {
        switch (ch) {
            case 1: // 1. Create
                createStudent();
                break;
            case 2: // 2. Find and Sort
                findAndSortStudents();
                break;
            case 3: // 3. Update/Delete
                updateAndDeleteStudent();
                break;
            case 4: // 4. Report
                generateReport();
                break;
            case 5: // 5. Exit (Được xử lý trong Menu.run())
                System.out.println("THANK YOU FOR USING STUDENT MANAGEMENT SYSTEM!");
                System.exit(0);
        }
    }
    
    // --- CHỨC NĂNG 1: CREATE ---
    private void createStudent() {
        System.out.println("\n--- CREATE STUDENT ---");
        int count = 0;
        boolean continueCreation = true;
        
        do {
            int id;
            while (true) {
                id = Validator.checkNumInt("Enter Student ID: ", true);
                if (isIdExist(id)) {
                    System.out.println("ID already exists. Please enter a unique ID.");
                } else {
                    break;
                }
            }
            
            String name = Validator.checkString("Enter Student Name: ");
            String semester = Validator.checkString("Enter Semester: ");
            String course = Validator.checkCourseName("Enter Course Name (Java, .Net, C/C++): ");
            
            studentList.add(new Student(id, name, semester, course));
            System.out.println("Student created successfully!");
            count++;
            
            // Yêu cầu: tạo ít nhất 3 sinh viên, sau đó hỏi tiếp tục
            if (count >= 3) {
                continueCreation = Validator.checkYesNo("Do you want to continue (Y/N)? ");
            }
            
        } while (continueCreation);
    }

    // --- CHỨC NĂNG 2: FIND AND SORT ---
    private void findAndSortStudents() {
        if (studentList.isEmpty()) {
            System.out.println("No students available to search.");
            return;
        }
        
        String searchName = Validator.checkString("Enter student name or a part of student name: ");
        
        // 1. Tìm kiếm theo tên (chứa) [cite: 251]
        List<Student> foundStudents = studentList.stream()
                .filter(s -> s.getStudentName().toLowerCase().contains(searchName.toLowerCase()))
                .collect(Collectors.toList());
        
        if (foundStudents.isEmpty()) {
            System.out.println("No student found with name containing: " + searchName);
            return;
        }
        
        // 2. Sắp xếp kết quả theo tên (alphabetical order) [cite: 250]
        foundStudents.sort(Comparator.comparing(Student::getStudentName));
        
        System.out.println("\n--- SEARCH RESULTS (Sorted by Name) ---");
        System.out.printf("%-25s %-15s %-10s\n", "Student Name", "Semester", "Course Name"); 
        System.out.println("--------------------------------------------------");
        
        // 3. Hiển thị kết quả
        for (Student s : foundStudents) {
            System.out.printf("%-25s %-15s %-10s\n", 
                    s.getStudentName(), s.getSemester(), s.getCourseName());
        }
    }

    // --- CHỨC NĂNG 3: UPDATE/DELETE ---
    private void updateAndDeleteStudent() {
        if (studentList.isEmpty()) {
            System.out.println("No students available for Update/Delete.");
            return;
        }
        
        int searchId = Validator.checkNumInt("Enter student ID to find: ", true);
        
        Optional<Student> studentOpt = studentList.stream()
                .filter(s -> s.getId() == searchId)
                .findFirst();

        if (studentOpt.isEmpty()) {
            System.out.println("Student with ID " + searchId + " not found.");
            return;
        }
        
        Student studentToModify = studentOpt.get();
        System.out.println("\n--- Student Found ---");
        System.out.printf("%-5s %-25s %-15s %-10s\n", "ID", "Name", "Semester", "Course");
        System.out.println("-----------------------------------------------------");
        System.out.println(studentToModify);
        
        String choice = Validator.checkUpdateDelete("Do you want to update (U) or delete (D) student? (U/D): "); 
        
        if (choice.equals("D")) {
            studentList.remove(studentToModify);
            System.out.println("Student with ID " + searchId + " has been DELETED.");
        } else if (choice.equals("U")) {
            // Cho phép người dùng cập nhật từng trường (hoặc giữ nguyên nếu để trống)
            System.out.println("\n--- UPDATING STUDENT (Press Enter to keep current value) ---");
            
            String newName = Validator.checkString("Enter new Student Name (" + studentToModify.getStudentName() + "): ");
            if (!newName.isEmpty()) {
                studentToModify.setStudentName(newName);
            }
            
            String newSemester = Validator.checkString("Enter new Semester (" + studentToModify.getSemester() + "): ");
            if (!newSemester.isEmpty()) {
                studentToModify.setSemester(newSemester);
            }
            
            String newCourse = Validator.checkString("Enter new Course Name (Java, .Net, C/C++) (" + studentToModify.getCourseName() + "): ");
            if (!newCourse.isEmpty()) {
                // Chỉ set nếu là một Course hợp lệ
                if (newCourse.equalsIgnoreCase("Java") || 
                    newCourse.equalsIgnoreCase(".Net") || 
                    newCourse.equalsIgnoreCase("C/C++")) {
                    studentToModify.setCourseName(newCourse);
                } else {
                    System.out.println("Invalid Course Name entered. Keeping old Course Name.");
                }
            }
            
            System.out.println("Student with ID " + searchId + " has been UPDATED.");
        }
    }

    // --- CHỨC NĂNG 4: REPORT ---
    private void generateReport() {
        if (studentList.isEmpty()) {
            System.out.println("No students available to generate report.");
            return;
        }
        
        System.out.println("\n--- STUDENT COURSE REPORT ---");
        
        // 1. Nhóm sinh viên theo Tên và Course Name
        // Map: Key = Tên sinh viên, Value = Map<CourseName, List<Student>>
        Map<String, Map<String, Long>> reportData = studentList.stream()
            .collect(Collectors.groupingBy(
                Student::getStudentName,
                Collectors.groupingBy(
                    Student::getCourseName,
                    Collectors.counting() // Đếm số lượng sinh viên trong mỗi nhóm (tên + khóa học)
                )
            ));

        // 2. Hiển thị báo cáo (Name | Course | Total of Course) [cite: 257]
        System.out.printf("%-25s | %-10s | %s\n", "Student Name", "Course", "Total of Course");
        System.out.println("----------------------------------------------------------------");
        
        reportData.forEach((studentName, courseCounts) -> {
            courseCounts.forEach((courseName, count) -> {
                System.out.printf("%-25s | %-10s | %d\n", studentName, courseName, count);
            });
        });
    }
}