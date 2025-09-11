
package slot1.short50;
import java.util.List;
import java.util.Scanner;
import slot1.Validator;


public class Main_50 extends Menu {
    private final Scanner scanner;
    Short50_Fuction fuction = new Short50_Fuction();

    
    public Main_50() {
        super("Equation Program", new String[] {
            "Calculate Superlative Equation",
            "Calculate Quadratic Equation",
            "Exit"
        });
        this.scanner = new Scanner(System.in);
    }
    
    
    @Override
    public void execute(int ch) {
        switch (ch) {
            case 1:
                calculateSuperlativeEquation();
                break;
            case 2:
                calculateQuadraticEquation();
                break;
            case 3:
                System.out.println("Exiting the program. Goodbye!");
                scanner.close();
                System.exit(0);
            default:
                System.out.println("Invalid choice. Please try again.");
                break;
        }
    }

    
    private void calculateSuperlativeEquation() {
        System.out.println("--- Superlative Equation ---");
        float a = Validator.checkNum("Enter A:", false);
        float b = Validator.checkNum("Enter B:", false);
        
        List<Float> solutions = fuction.solveSuperlativeEquation(a, b);
        
        if (solutions == null) {
            System.out.println("No solution.");
        } else if (solutions.isEmpty()) {
            System.out.println("Infinitely many solutions.");
        } else {
            System.out.println("Solution: x = " + solutions.get(0));
            fuction.checkAndPrintProperties(a);
            fuction.checkAndPrintProperties(b);
        }
    }
    
    private void calculateQuadraticEquation() {
        System.out.println("--- Quadratic Equation ---");
        float a = Validator.checkNum("Enter A:", false);
        float b = Validator.checkNum("Enter B:", false);
        float c = Validator.checkNum("Enter C:", false);

        List<Float> solutions = fuction.solveQuadraticEquation(a, b, c);

        if (solutions.isEmpty()) {
            System.out.println("No solution.");
        } else if (solutions.size() == 1) {
            System.out.println("There is a single solution: x = " + solutions.get(0));
            fuction.checkAndPrintProperties(solutions.get(0));
        } else {
            System.out.println("There are two solutions:");
            System.out.println("x1 = " + solutions.get(0));
            System.out.println("x2 = " + solutions.get(1));
            fuction.checkAndPrintProperties(a);
            fuction.checkAndPrintProperties(b);
            fuction.checkAndPrintProperties(c);
            
        }
    }

    
    public static void main(String[] args) {
        Main_50 program = new Main_50();
        program.run();
    }
}
