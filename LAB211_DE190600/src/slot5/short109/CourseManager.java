package slot5.short109;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ADMIN
 */
import slot5.Validator;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CourseManager extends Menu<String> {
    private final ArrayList<Course> courseList = new ArrayList<>();

    public CourseManager() {
        super("Course Management", new String[] {
            "Add online course/ offline course", 
            "Update course", 
            "Delete course", 
            "Print all / online course / offline course",
            "Search information base on course name", 
            "Exit"
        });
    }

    

    // Tìm kiếm Course theo ID
    private Course findCourseByID(String id) {
        return courseList.stream()
                .filter(c -> c.getCourseID().equalsIgnoreCase(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public void execute(int ch) {
        switch (ch) {
            case 1: 
                addCourse();
                break;
            case 2: 
                updateCourse();
                break;
            case 3: 
                deleteCourse();
                break;
            case 4: 
                printCourse();
                break;
            case 5: 
                searchCourse();
                break;
            case 6: 
                System.out.println("BYE AND SEE YOU NEXT TIME"); 
                break;
        }
    }

    // --- CHỨC NĂNG 1: ADD COURSE ---
    private void addCourse() {
        System.out.println("\n*** Add new course ***"); 
        String type = Validator.checkCourseType("Online (O) or Offline (F): "); 

        Course newCourse;
        if (type.equals("O")) {
            newCourse = new OnlineCourse();
        } else { 
            newCourse = new OfflineCourse();
        }

        newCourse.InputAll(courseList);
        courseList.add(newCourse);
        System.out.println("Course added successfully.");
    }
    
    // --- CHỨC NĂNG 2 & 3: UPDATE & DELETE ---
    private void updateCourse() {
        System.out.println("\n*** Update course ***"); 
        Course courseToModify = null;
        String searchId = "";
        
        while (courseToModify == null) {
            searchId = Validator.checkOptionalID("Course ID: ");
            if (searchId.isEmpty()) return; 
            
            courseToModify = findCourseByID(searchId);
            
            if (courseToModify == null) {
                System.out.println("*** No data found ***"); 
                boolean findAgain = Validator.checkYesNo("Do you want to find again? (Y/N): "); 
                if (!findAgain) return;
            }
        }
        
        System.out.println("\n*** Search results ***"); 
        // In ra thông tin chi tiết
        if (courseToModify instanceof OnlineCourse) {
            System.out.println(((OnlineCourse) courseToModify).toString());
        } else if (courseToModify instanceof OfflineCourse) {
             System.out.println(((OfflineCourse) courseToModify).toString());
        }
        
        String choice = Validator.checkCourseType("Do you want to update (O) or delete (F) this course? (O/F): ");
        if (choice.equals("F")) {
            deleteCourseLogic(courseToModify); 
        } else {
            updateCourseLogic(courseToModify); 
        }
    }
    
    // --- CHỨC NĂNG 3: DELETE COURSE ---
    private void deleteCourse() {
        System.out.println("\n*** Delete course ***"); 
        Course courseToDelete = null;
        String searchId = "";
        
        while (courseToDelete == null) {
            searchId = Validator.checkOptionalID("Course ID: "); 
            if (searchId.isEmpty()) return;
            
            courseToDelete = findCourseByID(searchId);
            
            if (courseToDelete == null) {
                System.out.println("*** No data found ***"); 
                boolean findAgain = Validator.checkYesNo("You want to find again? (Y/N): ");
                if (!findAgain) return;
            }
        }
        
        System.out.println("\n*** Search results ***");
        // In ra thông tin chi tiết
        if (courseToDelete instanceof OnlineCourse) {
            System.out.println(((OnlineCourse) courseToDelete).toString());
        } else if (courseToDelete instanceof OfflineCourse) {
             System.out.println(((OfflineCourse) courseToDelete).toString());
        }
        
        deleteCourseLogic(courseToDelete);
    }
    
    private void deleteCourseLogic(Course courseToDelete) {
        boolean confirm = Validator.checkYesNo("Are you sure you want to delete this information? (Y/N): "); 
        if (confirm) {
            courseList.remove(courseToDelete);
            System.out.println("Information deleted successfully."); 
        }
    }
    
    private void updateCourseLogic(Course courseToModify) {
        System.out.println("\n*** Updating ***"); 
        System.out.println("Note: Enter empty if you don't want to change it."); 

        // --- Cập nhật các thuộc tính chung (Course) ---
        String newName = Validator.checkOptionalString2("Course name", courseToModify.getCourseName()); 
        if (!newName.isEmpty()) {
            // Check Unique Name
            if (courseList.stream().anyMatch(c -> !c.getCourseID().equals(courseToModify.getCourseID()) && c.getCourseName().equalsIgnoreCase(newName))) {
                System.out.println("Data input is invalid, Course Name must be unique. Keeping old name.");
            } else {
                courseToModify.setCourseName(newName);
            }
        }
        
        // Credits ( > 0)
        int newCredits = Validator.checkCredits("Credits (> 0): "); 
        if (newCredits != -1) {
            courseToModify.setCredits(newCredits);
        }
        
        // Instructors
        String newInstructors = Validator.checkOptionalString2("Instructors", courseToModify.getInstructors()); 
        if (!newInstructors.isEmpty()) {
            courseToModify.setInstructors(newInstructors);
        }
        
        // --- Cập nhật các thuộc tính riêng (Online/Offline) ---
        if (courseToModify instanceof OnlineCourse) {
            OnlineCourse online = (OnlineCourse) courseToModify;
            
            String newPlatform = Validator.checkOptionalString2("Platform", online.getPlatform()); 
            if (!newPlatform.isEmpty()) {
                online.setPlatform(newPlatform);
            }
            
            String newNote = Validator.checkOptionalString2("Note", online.getNote()); 
            if (!newNote.isEmpty()) {
                online.setNote(newNote);
            }
        } else if (courseToModify instanceof OfflineCourse) {
            OfflineCourse offline = (OfflineCourse) courseToModify;
            
            String newCampus = Validator.checkOptionalString2("Campus", offline.getCampus());
            if (!newCampus.isEmpty()) {
                offline.setCampus(newCampus);
            }
            
            // Cập nhật Begin/End Date
            LocalDate currentBegin = offline.getBegin();
            LocalDate currentEnd = offline.getEnd();

            // Cập nhật Begin
            String changeBegin = Validator.checkOptionalString2("Change Begin Date? (D/M/YYYY)", currentBegin.format(Validator.DATE_FORMATTER));
            if (!changeBegin.isEmpty()) {
                try {
                    LocalDate newBegin = LocalDate.parse(changeBegin, Validator.DATE_FORMATTER);
                    if (newBegin.isAfter(LocalDate.now()) && newBegin.isBefore(currentEnd)) {
                        offline.setBegin(newBegin);
                        currentBegin = newBegin; // Cập nhật biến tạm để check End
                    } else {
                        System.out.println("Invalid Begin Date. Must be future and before End Date. Keeping old value.");
                    }
                } catch (DateTimeParseException e) {
                    System.out.println("Invalid Date format. Keeping old value.");
                }
            }
            
            // Cập nhật End (phải sau Begin mới/cũ)
            String changeEnd = Validator.checkOptionalString2("Change End Date? (D/M/YYYY)", currentEnd.format(Validator.DATE_FORMATTER));
            if (!changeEnd.isEmpty()) {
                try {
                    LocalDate newEnd = LocalDate.parse(changeEnd, Validator.DATE_FORMATTER);
                    if (newEnd.isAfter(LocalDate.now()) && newEnd.isAfter(currentBegin)) {
                        offline.setEnd(newEnd);
                    } else {
                        System.out.println("Invalid End Date. Must be future and after Begin Date. Keeping old value.");
                    }
                } catch (DateTimeParseException e) {
                    System.out.println("Invalid Date format. Keeping old value.");
                }
            }
        }

        System.out.println("Updated successfully"); 
    }

    // --- CHỨC NĂNG 4: PRINT COURSE ---
    private void printCourse() {
        if (courseList.isEmpty()) {
            System.out.println("No course information to view."); 
            return;
        }

        System.out.println("\n*** Print course ***"); 
        String type = Validator.checkPrintType("Do you want to print all (A), online course (O) or offline course (F): "); 
        
        List<Course> listToPrint;
        
        if (type.equals("A")) {
            listToPrint = courseList;
        } else if (type.equals("O")) {
            listToPrint = courseList.stream()
                    .filter(c -> c instanceof OnlineCourse)
                    .collect(Collectors.toList());
        } else { 
            listToPrint = courseList.stream()
                    .filter(c -> c instanceof OfflineCourse)
                    .collect(Collectors.toList());
        }
        
        if (listToPrint.isEmpty()) {
            System.out.println("No " + (type.equals("O") ? "Online" : "Offline") + " course to display.");
            return;
        }
        
        System.out.println("--- Course List ---");
        // Header
        if (type.equals("A")) {
            System.out.println("Course ID-Course name-Credits"); 
        } else if (type.equals("O")) {
            System.out.println("Course ID-Course name-Credits-Platform-Instructors-Note"); 
        } else { 
            System.out.println("Course ID-Course name-Credits-Begin-End-Instructors-Campus");
        }

        for (Course course : listToPrint) {
            // Sử dụng toString() của lớp con để in ra format chi tiết
            System.out.println(course.toString());
        }
    }

    // --- CHỨC NĂNG 5: SEARCH COURSE ---
    private void searchCourse() {
        System.out.println("\n*** Searching ***"); 
        String searchName = "";
        List<Course> foundCourses = new ArrayList<>();
        
        while (foundCourses.isEmpty()) {
            searchName = Validator.checkString("Enter Course name or part of name to search: ");
            
            final String finalSearchName = searchName.toLowerCase();
            foundCourses = courseList.stream()
                    .filter(c -> c.getCourseName().toLowerCase().contains(finalSearchName))
                    .collect(Collectors.toList());
            
            if (foundCourses.isEmpty()) {
                System.out.println("*** No data found ***"); 
                boolean findAgain = Validator.checkYesNo("Do you want to find again? (Y/N): "); 
                if (!findAgain) return;
            }
        }
        
        System.out.println("\n*** Search results ***"); 
        for (Course course : foundCourses) {
            // Hiển thị đầy đủ thông tin của khóa học tìm được
            System.out.println("------------------------------------------");
            System.out.printf("Course ID: %s\n", course.getCourseID()); 
            System.out.printf("Course name: %s\n", course.getCourseName()); 
            System.out.printf("Credits: %d\n", course.getCredits()); 
            System.out.printf("Instructors: %s\n", course.getInstructors());
            
            if (course instanceof OnlineCourse) {
                OnlineCourse online = (OnlineCourse) course;
                System.out.printf("Platform: %s\n", online.getPlatform()); 
                System.out.printf("Note: %s\n", online.getNote()); 
            } else if (course instanceof OfflineCourse) {
                OfflineCourse offline = (OfflineCourse) course;
                System.out.printf("Begin: %s\n", offline.getBegin().format(Validator.DATE_FORMATTER));
                System.out.printf("End: %s\n", offline.getEnd().format(Validator.DATE_FORMATTER));
                System.out.printf("Campus: %s\n", offline.getCampus());
            }
        }
        System.out.println("------------------------------------------");
    }

    public static void main(String[] args) {
        CourseManager manager = new CourseManager();
        manager.run();
    }
}