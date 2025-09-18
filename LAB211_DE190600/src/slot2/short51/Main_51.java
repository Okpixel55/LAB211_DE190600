/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package slot2.short51;

import java.util.Scanner;
import slot2.Validator;

/**
 *
 * @author ADMIN
 */
public class Main_51 extends Menu {

    Short51_ComputerProgram cal = new Short51_ComputerProgram();

    public class Memory {

        private double number;

        public Memory(double number) {
            this.number = number;
        }

        public double getNumber() {
            return number;
        }

        public void setNumber(double number) {
            this.number = number;
        }
    }

    private final Scanner sc;

    public Main_51() {
        super("Calulator program", new String[]{
            "Normal calulator",
            "BMI calulator",
            "Exit"
        });
        this.sc = new Scanner(System.in);
    }

    @Override
    public void execute(int ch) {
        switch (ch) {
            case 1:
                inputCalulator();
                break;
            case 2:
                inputCalulatorBMI();
            case 3:
                System.out.println("Exiting the program. Goodbye!");
                sc.close();
                System.exit(0);
            default:
                System.out.println("Invalid choice. Please try again.");
                break;
        }
    }

    private void inputCalulator() {
        System.out.println("----- Normal Calculator -----");
        double a = Validator.checkNumDouble("Enter Number: ", false);
        String op;
        Memory memory = new Memory(a);
        do {
            op = Validator.checkOperator("Enter Opertator( '=' to stop calculator): ");
            if (op.equals("=")) {
                break;
            }
            double b = Validator.checkNumDouble("Enter Number: ", false);
            double rs = cal.calculate(memory, op, b);
            memory.setNumber(rs);
            System.out.println("Result: " + rs);
        } while (true);
        System.out.println("Final Result: " + memory.getNumber());
    }

    private void inputCalulatorBMI() {
        System.out.println("----- BMI Calculator -----");
        String choice;

        do {
            double height = Validator.checkNumDouble("Enter height (m): ", true);
            double weight = Validator.checkNumDouble("Enter weight (kg): ", true);
            cal.calculatorBMI(height, weight);

            System.out.print("Do you want to calculate another BMI? (y/n): ");
            choice = sc.nextLine();
        } while (choice.equalsIgnoreCase("y"));

    }

    public static void main(String[] args) {
        Main_51 program = new Main_51();
        program.run();
    }

}
