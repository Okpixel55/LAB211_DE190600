/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package slot3.short83;

/**
 *
 * @author ADMIN
 */
public class Main_83 {
     public static void main(String[] args) {
        MyStack stack = new MyStack();
        System.out.println("--- Demo Push ---");
        
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);
        stack.push(50); 
        stack.display(); 
        
        stack.push(60); 
        stack.display(); 

        System.out.println("\n--- Demo Pop ---");
        int poppedValue = stack.pop(); 
        System.out.println("Popped value: " + poppedValue); 
        stack.display(); 
        
        System.out.println("\n--- Demo Get ---");
        int peekedValue = stack.get(); 
        System.out.println("Top value (using get()): " + peekedValue); 
        stack.display(); 
    }
}
