/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package slot4.long21;

/**
 *
 * @author ADMIN
 */
public class Student {
    private int id;
    private String studentName;
    private String semester;
    private String courseName; // Java, .Net, C/C++

    public Student(int id, String studentName, String semester, String courseName) {
        this.id = id;
        this.studentName = studentName;
        this.semester = semester;
        this.courseName = courseName;
    }

    // --- Getters ---
    public int getId() { return id; }
    public String getStudentName() { return studentName; }
    public String getSemester() { return semester; }
    public String getCourseName() { return courseName; }

    // --- Setters (Dùng cho Update) ---
    public void setStudentName(String studentName) { this.studentName = studentName; }
    public void setSemester(String semester) { this.semester = semester; }
    public void setCourseName(String courseName) { this.courseName = courseName; }

    @Override
    public String toString() {
        return String.format("%-5d %-25s %-15s %-10s", 
                id, studentName, semester, courseName);
    }
}
