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

public class Teacher extends Person {
    private int yearInProfession;
    private String contractType;
    private double salaryCoefficient;

    public Teacher() {
        super();
        this.yearInProfession = 0;
        this.contractType = "";
        this.salaryCoefficient = 0.0;
    }

    public int getYearInProfession() { return yearInProfession; }
    public double getSalaryCoefficient() { return salaryCoefficient; }

    @Override
    public void InputAll() {
        super.InputAll(); 
        System.out.println("--- Input Teacher Specific Info ---");
        
        
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        int age = currentYear - getYearOfBirth(); 
        
        
        this.yearInProfession = Validator.checkYear(
                "Year in the profession (0 to < " + age + "): ", 
                0, age - 1);
        
        
        this.contractType = Validator.checkContractType("Contract type ('Long' or 'Short'): ");
        
        
        this.salaryCoefficient = Validator.checkNumDouble("Salary coefficient (>= 0): ", false);
        System.out.println("--- Input finished ---");
    }

    
    @Override
    public String toString() {
        return String.format("%s %-15d %-15s %-10.1f", 
                super.toString(), yearInProfession, contractType, salaryCoefficient);
    }
}
