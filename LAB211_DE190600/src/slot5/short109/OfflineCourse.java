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
import java.util.ArrayList;

public class OfflineCourse extends Course {
    private LocalDate begin;
    private LocalDate end;
    private String campus;
    
    public OfflineCourse() {
        super();
        this.begin = LocalDate.now(); 
        this.end = LocalDate.now();
        this.campus = "";
    }
    
    // Getters and Setters
    public LocalDate getBegin() { return begin; }
    public void setBegin(LocalDate begin) { this.begin = begin; }
    public LocalDate getEnd() { return end; }
    public void setEnd(LocalDate end) { this.end = end; }
    public String getCampus() { return campus; }
    public void setCampus(String campus) { this.campus = campus; }
    
    @Override
    public void InputAll(ArrayList<Course> courseList) {
        System.out.println("--- Create new offline course ---");
        super.InputAll(courseList);

        this.instructors = Validator.checkString("Instructors: ");
        
        // Begin phải là tương lai
        this.begin = Validator.checkFutureDate("Begin: ");
        
        // End phải là tương lai và sau Begin
        this.end = Validator.checkEndDate("End: ", this.begin);
        
        this.campus = Validator.checkString("Campus: "); 
    }

    @Override
    public String toString() {
        // Format chuẩn cho Print Offline (F)
        return String.format("%s-%s-%d-%s-%s-%s-%s", 
                courseID, courseName, credits, 
                begin.format(Validator.DATE_FORMATTER), 
                end.format(Validator.DATE_FORMATTER), 
                instructors, campus);
    }
}
