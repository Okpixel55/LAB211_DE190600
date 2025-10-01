/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package slot4.short105;
import slot4.Validator;

/**
 *
 * @author ADMIN
 */
import java.util.Calendar;

public class Student extends Person {
    private int yearOfAdmission;
    private double entranceEnglishScore;

    
    public Student() {
        super();
        this.yearOfAdmission = 0;
        this.entranceEnglishScore = 0.0;
    }

    
    public int getYearOfAdmission() { return yearOfAdmission; }
    public double getEntranceEnglishScore() { return entranceEnglishScore; }
    //...

    
    @Override
    public void InputAll() {
        super.InputAll(); 
        System.out.println("--- Input Student Specific Info ---");
        
        
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        
        
        this.yearOfAdmission = Validator.checkYear(
                "Year of admission (" + getYearOfBirth() + " to " + currentYear + "): ",
                getYearOfBirth(), currentYear);
        
        
        this.entranceEnglishScore = Validator.checkDoubleInRange(
                "Entrance English score (0 to 100): ", 
                0.0, 100.0);
        System.out.println("--- Input finished ---");
    }

    
    @Override
    public String toString() {
        return String.format("%s %-20d %-10.1f", 
                super.toString(), yearOfAdmission, entranceEnglishScore);
    }
}
