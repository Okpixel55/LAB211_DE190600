package slot5.short84;

import java.util.Scanner;
import java.math.BigInteger; // Cần thiết cho hàm test
import slot5.Validator;

public class Main_84 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\n--- LARGE NUMBER CALCULATOR ---");

        String strA = Validator.checkString("Enter the first large number (A): ");
        String strB = Validator.checkString("Enter the second large number (B): ");

        Short84_LargeNumber numA = new Short84_LargeNumber(strA);
        Short84_LargeNumber numB = new Short84_LargeNumber(strB);

        BigInteger bigA = new BigInteger(strA);
        BigInteger bigB = new BigInteger(strB);

        String customAdd = numA.add(numB).getNumber();
        String customMul = numA.multiply(numB).getNumber();

        String bigAdd = bigA.add(bigB).toString();
        String bigMul = bigA.multiply(bigB).toString();

        System.out.println("\n--- TEST COMPARISON (" + strA + " vs " + strB + ") ---");

        boolean isAddCorrect = customAdd.equals(bigAdd);
        System.out.println("add: " + (isAddCorrect ? "ĐÚNG️" : "SAI "));
        System.out.println("       LargeNumber: " + customAdd);
        System.out.println("       BigInteger: " + bigAdd);

        boolean isMulCorrect = customMul.equals(bigMul);
        System.out.println("multiply: " + (isMulCorrect ? "ĐÚNG ️" : "SAI "));
        System.out.println("       LargeNumber: " + customMul);
        System.out.println("       BigInteger: " + bigMul);
    }

}
