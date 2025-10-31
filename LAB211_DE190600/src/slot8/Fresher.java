/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package slot8;

// ===== Lớp con 2: Fresher =====
public class Fresher extends Candidate {
    private int graduationYear;
    private String graduationRank, education;

    public Fresher(String id, String firstName, String lastName, int birthYear,
                   String address, String phone, String email,
                   int graduationYear, String graduationRank, String education) {
        super(id, firstName, lastName, birthYear, address, phone, email, 1);
        this.graduationYear = graduationYear;
        this.graduationRank = graduationRank;
        this.education = education;
    }
}

