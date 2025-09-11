
package slot1.short11;


public class Short11_ChangeBaseNumber {

   
    public static long toDecimal(String inputNumber, int base) {
        return Long.parseLong(inputNumber, base);
    }

 
    public static String fromDecimal(long decimalNumber, int targetBase) {
        if (targetBase == 2) {
            return Long.toBinaryString(decimalNumber);
        } else if (targetBase == 16) {
            return Long.toHexString(decimalNumber).toUpperCase();
        }
        return String.valueOf(decimalNumber);
    }

    
    public static boolean validateNumber(String inputNumber, int base) {
        if (inputNumber == null || inputNumber.trim().isEmpty()) {
            return false;
        }
        try {
            Long.parseLong(inputNumber, base);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
