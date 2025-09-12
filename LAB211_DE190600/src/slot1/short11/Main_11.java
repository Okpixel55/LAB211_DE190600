
package slot1.short11;

import java.util.Scanner;


public class Main_11 extends Menu {
    private final Scanner scanner;
    
    public Main_11() {
        super("Number Base Conversion", new String[] {
            "Convert a number",
            "Exit"
        });
        this.scanner = new Scanner(System.in);
    }
    
    @Override
    public void execute(int ch) {
        switch (ch) {
            case 1:
                convertNumber();
                break;
            case 2:
                System.out.println("Exiting the program. Goodbye!");
                scanner.close();
                System.exit(0);
            default:
                System.out.println("Invalid choice. Please try again.");
                break;
        }
    }

    private void convertNumber() {
        System.out.println("--- Convert a Number ---");
        
        
        int inputBase = getBaseChoice("Enter the input base:\n1. Binary (2)\n2. Decimal (10)\n3. Hexadecimal (16)\nYour choice: ");
        
        
        int outputBase = getBaseChoice("Enter the output base:\n1. Binary (2)\n2. Decimal (10)\n3. Hexadecimal (16)\nYour choice: ");
        
        
        String inputValue = getInputNumber(inputBase);
        
        
        long decimalValue = Short11_ChangeBaseNumber.toDecimal(inputValue, inputBase);
        String outputValue = Short11_ChangeBaseNumber.fromDecimal(decimalValue, outputBase);
        
        System.out.println("The converted value is: " + outputValue);
    }

    
    private int getBaseChoice(String message) {
        while (true) {
            try {
                System.out.print(message);
                String choiceStr = scanner.nextLine();
                int choice = Integer.parseInt(choiceStr);
                if (choice == 1) return 2;
                if (choice == 2) return 10;
                if (choice == 3) return 16;
                System.out.println("Invalid choice. Please enter a number from 1 to 3.");
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
            }
        }
    }

    
    private String getInputNumber(int base) {
        String number;
        while (true) {
            System.out.print("Enter the number in base " + base + ": ");
            number = scanner.nextLine().trim();
            try {
                if (base == 2) {
                    Long.parseLong(number, 2);
                } else if (base == 10) {
                    Long.parseLong(number, 10);
                } else if (base == 16) {
                    Long.parseLong(number, 16);
                }
                return number;
            } catch (NumberFormatException e) {
                System.out.println("The number is invalid for base " + base + ". Please try again.");
            }
        }
    }
    
    public static void main(String[] args) {
        Main_11 program = new Main_11();
        program.run();
    }
}
