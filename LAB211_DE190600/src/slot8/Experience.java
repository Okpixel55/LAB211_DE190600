/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package slot8;


// ===== Lớp con 1: Experience =====
public class Experience extends Candidate {
    private int expInYear;
    private String proSkill;

    public Experience(String id, String firstName, String lastName, int birthYear,
                      String address, String phone, String email,
                      int expInYear, String proSkill) {
        super(id, firstName, lastName, birthYear, address, phone, email, 0);
        this.expInYear = expInYear;
        this.proSkill = proSkill;
    }
}

