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


public class OnlineCourse extends Course {
    private String platform;
    private String note;
    
    public OnlineCourse() {
        super();
        this.platform = "";
        this.note = "";
    }
    
    // Getters and Setters
    public String getPlatform() { return platform; }
    public void setPlatform(String platform) { this.platform = platform; }
    public String getNote() { return note; }
    public void setNote(String note) { this.note = note; }
    
    @Override
    public void InputAll(ArrayList<Course> courseList) {
        System.out.println("--- Create new online course ---");
        super.InputAll(courseList);
        
        this.instructors = Validator.checkString("Instructors: ");
        
        this.platform = Validator.checkString("Platform: "); // not empty
        this.note = Validator.checkString("Note: "); // not empty
    }

    @Override
    public String toString() {
        // Format chuẩn cho Print Online (O)
        return String.format("%s-%s-%d-%s-%s-%s", 
                courseID, courseName, credits, platform, instructors, note);
    }
}
