package slot4.short105;

import slot4.Validator;
public class Person {
    private String id;
    private String fullName;
    private String phoneNumber;
    private int yearOfBirth;
    private String major;

    
    public Person() {
        this.id = "";
        this.fullName = "";
        this.phoneNumber = "";
        this.major = "";
        this.yearOfBirth = 0;
    }

   
    public String getId() { return id; }
    public String getFullName() { return fullName; }
    public int getYearOfBirth() { return yearOfBirth; }
    public String getMajor() { return major; }
    public String getPhoneNumber() { return phoneNumber; }
    
    
    public void setId(String id) { this.id = id; }
    public void setFullName(String fullName) { this.fullName = fullName; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }
    public void setYearOfBirth(int yearOfBirth) { this.yearOfBirth = yearOfBirth; }
    public void setMajor(String major) { this.major = major; }

    public void InputAll() {
        System.out.println("\n--- Input Person Info ---");
        // Sử dụng Setters
        setId(Validator.checkID("ID (6 digits): "));
        setFullName(Validator.checkFullName("Fullname (alphabet and blanks): "));
        setPhoneNumber(Validator.checkPhoneNumber("Phone number (12 digits): "));
        setYearOfBirth(Validator.checkYearOfBirth("Year of birth (before current year): "));
        setMajor(Validator.checkMajor("Major (max 30 characters): "));
    }
    
    @Override
    public String toString() {
        return String.format("%-10s %-25s %-15s %-15d %-20s",
                id, fullName, phoneNumber, yearOfBirth, major);
    }
}