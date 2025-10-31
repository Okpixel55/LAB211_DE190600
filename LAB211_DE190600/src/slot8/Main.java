package slot8;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        CandidateManager manager = new CandidateManager();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\nCANDIDATE MANAGEMENT SYSTEM");
            System.out.println("1. Experience");
            System.out.println("2. Fresher");
            System.out.println("3. Internship");
            System.out.println("4. Searching");
            System.out.println("5. Exit");
            System.out.print("Choose: ");

            try {
                int choice = Integer.parseInt(sc.nextLine());
                switch (choice) {
                    case 1 -> manager.createCandidate(0);
                    case 2 -> manager.createCandidate(1);
                    case 3 -> manager.createCandidate(2);
                    case 4 -> manager.search();
                    case 5 -> {
                        System.out.println("END. See you agian");
                        return;
                    }
                    default -> System.out.println("→ Invalid choice!");
                }
            } catch (Exception e) {
                System.out.println("→ Do again now!");
            }
        }
    }
}

