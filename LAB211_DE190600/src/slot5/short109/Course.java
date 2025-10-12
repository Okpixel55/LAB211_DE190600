/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package slot5.short109;

/**
 *
 * @author ADMIN
 */
import java.util.ArrayList;
import slot5.Validator;

public class Course {

    protected String courseID;
    protected String courseName;
    protected int credits;
    protected String instructors; // Thêm instructors vào Course để OnlineCourse và OfflineCourse kế thừa

    public Course() {
        this.courseID = "";
        this.courseName = "";
        this.credits = 0;
        this.instructors = "";
    }

    // Getters and Setters
    public String getCourseID() {
        return courseID;
    }

    public void setCourseID(String courseID) {
        this.courseID = courseID;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public String getInstructors() {
        return instructors;
    }

    public void setInstructors(String instructors) {
        this.instructors = instructors;
    }

    public void InputAll(ArrayList<Course> courseList) {
        System.out.println("--- Input Course Info ---");
        // 1. Course ID (Unique, Not empty)
        while (true) {
            this.courseID = Validator.checkString("Course ID: ");
            boolean idExists = courseList.stream()
                    .anyMatch(c -> c.getCourseID().equalsIgnoreCase(this.courseID));

            if (idExists) {
                System.out.println("Data input is invalid, ID must be unique.");
            } else {
                break;
            }
        }

        // 2. Course Name (Unique, Not empty)
        while (true) {
            this.courseName = Validator.checkString("Course name: ");
            boolean idExists = courseList.stream()
                    .anyMatch(c -> c.getCourseID().equalsIgnoreCase(this.courseID));

            if (idExists) {
                System.out.println("Data input is invalid, ID must be unique.");
            } else {
                break;
            }
        }

        // 3. Credits (> 0)
        while (true) {
            int c = Validator.checkCredits("Credits (> 0): ");
            if (c != -1) {
                this.credits = c;
                break;
            }
            // Nếu là -1 (skip) thì lặp lại vì Credits bắt buộc phải có giá trị > 0 khi tạo mới
            System.out.println("Credits must be a valid number greater than 0.");
        }
    }

    @Override
    public String toString() {
        // Format chuẩn cho Print All (A)
        return String.format("%s-%s-%d", courseID, courseName, credits);
    }
}
