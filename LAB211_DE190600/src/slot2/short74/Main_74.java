/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package slot2.short74;

/**
 *
 * @author ADMIN
 */
import slot4.short105.Menu;
import slot2.Validator;

public class Main_74 extends Menu {

    public Main_74(String td, String[] mc) {
        super(td, mc);
    }

    // Main method to run the program
    public static void main(String[] args) {
        String[] options = {"Addition Matrix", "Subtraction Matrix", "Multiplication Matrix", "Quit"};
        Main_74 main = new Main_74("======= Calculator program ======", options);
        main.run();
    }

    // Method to get matrix dimensions and values from user
        private Short74_Matrix getMatrix(String matrixName) {
        int rows = Validator.checkNumInt(ColorConsole.ANSI_GREEN+"Enter Row " + matrixName + ":"+ColorConsole.ANSI_RESET, true);
        int cols = Validator.checkNumInt(ColorConsole.ANSI_GREEN+"Enter Column " + matrixName + ":"+ColorConsole.ANSI_RESET, true);
        Short74_Matrix matrix = new Short74_Matrix(rows, cols);
        matrix.inputMatrix(matrixName);
        return matrix;
    }

    @Override
    public void execute(int choice) {
        switch (choice) {
            case 1:
                performOperation("Addition", 1);
                break;
            case 2:
                performOperation("Subtraction", 2);
                break;
            case 3:
                performOperation("Multiplication", 3);
                break;
            case 4:
                System.out.println("Exiting program.");
                System.exit(0);
                break;
            default:
                System.out.println("Invalid choice. Please select an option from 1 to 4.");
        }
    }

    // Helper method to perform the selected operation
    // Trong lớp Main_74
    private void performOperation(String operationName, int operationType) {
        System.out.println( "-------- " + operationName + " --------" );
        try {
            Short74_Matrix matrix1 = getMatrix("Matrix 1");
            Short74_Matrix matrix2 = getMatrix("Matrix 2");

            // In ma trận thứ nhất
            System.out.println("Matrix 1:");
            matrix1.display();

            // In toán tử
            String operator = "";
            switch (operationType) {
                case 1:
                    operator = "+";
                    break;
                case 2:
                    operator = "-";
                    break;
                case 3:
                    operator = "*";
                    break;
            }
            System.out.println(operator);

            // In ma trận thứ hai
            System.out.println("Matrix 2:");
            matrix2.display();

            // In dấu bằng
            System.out.println("=");

            Short74_Matrix result = null;
            if (operationType == 1) {
                result = matrix1.additionMatrix(matrix2);
            } else if (operationType == 2) {
                result = matrix1.subtractionMatrix(matrix2);
            } else if (operationType == 3) {
                result = matrix1.multiplicationMatrix(matrix2);
            }

            System.out.println("Result:");
            if (result != null) {
                result.display();
            }

        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
        System.out.println("---------------------------------");
    }
}
