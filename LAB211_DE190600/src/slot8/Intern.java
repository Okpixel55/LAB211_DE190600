/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package slot8;

// ===== Lớp con 3: Intern =====
public class Intern extends Candidate {
    private String majors, university;
    private int semester;

    public Intern(String id, String firstName, String lastName, int birthYear,
                  String address, String phone, String email,
                  String majors, int semester, String university) {
        super(id, firstName, lastName, birthYear, address, phone, email, 2);
        this.majors = majors;
        this.semester = semester;
        this.university = university;
    }
}

