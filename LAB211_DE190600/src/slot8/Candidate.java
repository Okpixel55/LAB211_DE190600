/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package slot8;


// ===== Lớp cha (Superclass) =====
public class Candidate {
    protected String id, firstName, lastName, address, phone, email;
    protected int birthYear, type; // 0: Experience, 1: Fresher, 2: Intern

    public Candidate(String id, String firstName, String lastName, int birthYear,
                     String address, String phone, String email, int type) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthYear = birthYear;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.type = type;
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }

    public int getType() {
        return type;
    }

    @Override
    public String toString() {
        return getFullName() + " | " + birthYear + " | " + address + " | "
                + phone + " | " + email + " | " + type;
    }
}

