
package slot3;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Validator {
    private static final Scanner scanner = new Scanner(System.in);

    public static int checkNumInt(String message, boolean requirePositive) {
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
    
    public static double checkNumDouble(String message, boolean requirePositive) {
        double number;
        while (true) {
            try {
                System.out.println(message);
                number =  scanner.nextDouble();
                scanner.nextLine();
                if (requirePositive && number <= 0) {
                    System.out.println("The number must be positive. Please try again.");
                } else {
                    return number;
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid double.");
                scanner.nextLine(); // Clear the invalid input from the scanner.
            }
        }
    }
    
    
    public static String checkOperator(String message) {
        String operatorSymbol;
        List<String> validOperators = List.of("+", "-", "*", "/", "^", "=");
        while (true) {
            try {
                System.out.println(message);
                operatorSymbol =  scanner.nextLine();
                if (!validOperators.contains(operatorSymbol)) {
                    System.out.println("Wrong operator, it not in '+,-,*,/,^,='. Please try again.");
                } else {
                    return operatorSymbol;
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid String.");
                scanner.nextLine(); 
            }
        }
    }
    
}
