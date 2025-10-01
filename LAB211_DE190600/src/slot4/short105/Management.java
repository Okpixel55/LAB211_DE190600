
package slot4.short105;
import slot4.Validator;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Management extends Menu<String> {
    private final ArrayList<Teacher> teacherList = new ArrayList<>();
    private final ArrayList<Student> studentList = new ArrayList<>();

    public Management(String title, String[] choices) {
        super(title, choices);
    }
    
    @Override
    public void execute(int ch) {
        switch (ch) {
            case 1: 
                new TeacherMenu("Teacher Management", new String[]{"Input", "Print", "Exit"}).run();
                break;
            case 2: 
                new StudentMenu("Student Management", new String[]{"Input", "Print", "Exit"}).run();
                break;
            case 3: 
                new PersonMenu("Person Management", new String[]{"Search", "Print all", "Exit"}).run();
                break;
            case 4: 
                System.out.println("BYE AND SEE YOU NEXT TIME"); 
                System.exit(0);
        }
    }
    
    class TeacherMenu extends Menu<String> {
        public TeacherMenu(String title, String[] choices) {
            super(title, choices);
        }

        @Override
        public void execute(int ch) {
            switch (ch) {
                case 1: 
                    int n = Validator.checkNumInt("Enter number of teachers (n): ", true);
                    for (int i = 0; i < n; i++) {
                        System.out.println("\n--- Entering Teacher " + (i + 1) + " ---");
                        Teacher t = new Teacher();
                        t.InputAll();
                        teacherList.add(t);
                    }
                    break;
                case 2: 
                    printTeachers();
                    break;
                case 3: 
                    break;
            }
        }
        
        
        private void printTeachers() {
            if (teacherList.isEmpty()) {
                System.out.println("No teachers have been entered yet.");
                return;
            }
            
            teacherList.sort(Comparator.comparing(Teacher::getYearInProfession).reversed());
            
            System.out.println("\n--- Teacher List (Sorted by Year in Profession Descending) ---");
            System.out.printf("# %-10s %-25s %-15s %-15s %-20s %-15s %-15s %-10s\n", 
                    "ID", "Fullname", "Phone number", "Year of birth", "Major", 
                    "Year in the profession", "Contract type", "Salary coefficient");
            System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------");
            for (int i = 0; i < teacherList.size(); i++) {
                System.out.printf("%d %s\n", (i + 1), teacherList.get(i).toString());
            }
        }
    }

   
    class StudentMenu extends Menu<String> {
        public StudentMenu(String title, String[] choices) {
            super(title, choices);
        }

        @Override
        public void execute(int ch) {
            switch (ch) {
                case 1: // Input n students [cite: 54]
                    int n = Validator.checkNumInt("Enter number of students (n): ", true);
                    for (int i = 0; i < n; i++) {
                        System.out.println("\n--- Entering Student " + (i + 1) + " ---");
                        Student s = new Student();
                        s.InputAll();
                        studentList.add(s);
                    }
                    break;
                case 2: 
                    printStudents();
                    break;
                case 3: // Exit
                    break;
            }
        }
        
        
        private void printStudents() {
            if (studentList.isEmpty()) {
                System.out.println("No students have been entered yet.");
                return;
            }
            
            studentList.sort(Comparator.comparing(Student::getYearOfAdmission));
            
            System.out.println("\n--- Student List (Sorted by Year of Admission Increasing) ---");
            System.out.printf("# %-10s %-25s %-15s %-15s %-20s %-20s %-10s\n", 
                    "ID", "Fullname", "Phone number", "Year of birth", "Major", 
                    "Year of admission", "Entrance English score");
            System.out.println("------------------------------------------------------------------------------------------------------------------------------------");
            for (int i = 0; i < studentList.size(); i++) {
                System.out.printf("%d %s\n", (i + 1), studentList.get(i).toString());
            }
        }
    }

    
    class PersonMenu extends Menu<String> {
        public PersonMenu(String title, String[] choices) {
            super(title, choices);
        }

        @Override
        public void execute(int ch) {
            switch (ch) {
                case 1: 
                    searchPerson();
                    break;
                case 2: 
                    printAllPeople();
                    break;
                case 3: 
                    break;
            }
        }

        
        private void searchPerson() {
            String searchName = Validator.checkString("Name: ");
            
            List<Person> foundPeople = new ArrayList<>();
            
            
            foundPeople.addAll(teacherList.stream()
                    .filter(p -> p.getFullName().toLowerCase().contains(searchName.toLowerCase()))
                    .collect(Collectors.toList()));
            foundPeople.addAll(studentList.stream()
                    .filter(p -> p.getFullName().toLowerCase().contains(searchName.toLowerCase()))
                    .collect(Collectors.toList()));
            
            if (foundPeople.isEmpty()) {
                System.out.println("Result: not found");
                return;
            }
            
            
            foundPeople.sort(Comparator.comparing(Person::getYearOfBirth).reversed());
            
            System.out.println("Result:");
            printPersonList(foundPeople);
        }

        
        private void printAllPeople() {
            List<Person> allPeople = new ArrayList<>();
            allPeople.addAll(teacherList);
            allPeople.addAll(studentList);
            
            if (allPeople.isEmpty()) {
                System.out.println("No person data available.");
                return;
            }
            
           
            allPeople.sort(Comparator.comparing(Person::getYearOfBirth).reversed());
            
            System.out.println("\n--- All Person List (Sorted by Year of Birth Descending) ---");
            printPersonList(allPeople);
        }
        
        
        private void printPersonList(List<Person> people) {
            System.out.printf("# %-10s %-25s %-15s %-15s %-20s\n", 
                    "ID", "Fullname", "Phone number", "Year of birth", "Major");
            System.out.println("------------------------------------------------------------------------------------------");
            for (int i = 0; i < people.size(); i++) {
                System.out.printf("%d %s\n", (i + 1), people.get(i).toString());
            }
        }
    }
}