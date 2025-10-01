/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package slot4.long21;

/**
 *
 * @author ADMIN
 */
public class Main_21 {
    public static void main(String[] args) {
        String[] menuItems = {"Create", "Find and Sort", "Update/Delete", "Report", "Exit"};
        StudentManager app = new StudentManager("WELCOME TO STUDENT MANAGEMENT", menuItems);
        
        app.run();
    }
}
