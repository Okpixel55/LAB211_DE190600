/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package slot1.short08;

import java.util.Scanner;

/**
 *
 * @author ADMIN
 */
public class Main_08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your content: ");
        String content = scanner.nextLine();
        scanner.close();

        Short08_LetterAndCharactersCout program = new Short08_LetterAndCharactersCout();
        
        program.doCountWords(content);
        program.doCountCharacters(content);
    }
}
