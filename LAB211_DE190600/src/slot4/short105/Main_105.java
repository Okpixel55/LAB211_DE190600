/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package slot4.short105;

/**
 *
 * @author ADMIN
 */
public class Main_105 {
     public static void main(String[] args) {
        String[] menuItems = {"Teacher", "Student", "Person", "Exit"};
        Management mainApp = new Management("Information Management", menuItems);
        
        System.out.println("Information Management");
        System.out.println("***");
        mainApp.run();
    }
}
