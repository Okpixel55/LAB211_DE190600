
package slot1;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Validator {
    private static final Scanner scanner = new Scanner(System.in);

    public static int checkNum(String message, boolean requirePositive) {
        int number;
        while (true) {
            try {
                System.out.println(message);
                number =  scanner.nextInt();
                if (requirePositive && number <= 0) {
                    System.out.println("The number must be positive. Please try again.");
                } else {
                    return number;
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid integer.");
                scanner.nextLine(); // Clear the invalid input from the scanner.
            }
        }
    }
}
