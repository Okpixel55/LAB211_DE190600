/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package slot5.short84;

/**
 *
 * @author ADMIN
 */
public class Short84_LargeNumber {

    private String number;

    public Short84_LargeNumber(String number) {
        this.number = number;
    }

    public String getNumber() {
        return number;
    }
    
    

    public String covertToString(int[] arr) {
        if (arr.length == 1 && arr[0] == 0) {
            return "0";
        }

        StringBuilder kqString = new StringBuilder();

        int start = (arr[0] == 0) ? 1 : 0;

        for (int i = start; i < arr.length; i++) {
            kqString.append(arr[i]);
        }

        return kqString.toString();
    }

    public Short84_LargeNumber add(Short84_LargeNumber other) {
        int k = Math.max(this.number.length(), other.number.length());
        int[] result = new int[k + 1];
        int i = this.number.length() - 1;
        int j = other.number.length() - 1;
        int sodu = 0;
        while (i >= 0 || j >= 0) {
            int so1 = ((i >= 0) ? this.number.charAt(i) - '0' : 0);
            int so2 = ((j >= 0) ? other.number.charAt(j) - '0' : 0);

            int sum = so1 + so2 + sodu;
            result[k] = sum % 10;
            sodu = sum / 10;
            i--;
            j--;
            k--;

        }
        if (sodu > 0) {
            result[k] = sodu;
        }
        return new Short84_LargeNumber(covertToString(result));
    }

    public Short84_LargeNumber multiply(Short84_LargeNumber other) {

        int k = this.number.length() + other.number.length();

        int[] result = new int[k];
        int i = this.number.length() - 1;

        while (i >= 0) {
            int j = other.number.length() - 1;
            int sodu = 0;
            int so1 = ((i >= 0) ? this.number.charAt(i) - '0' : 0);
            while (j >= 0) {
                int so2 = ((j >= 0) ? other.number.charAt(j) - '0' : 0);
                int p2 = i + j + 1;
                int nhan = so1 * so2 + result[p2] + sodu;
                result[p2] = nhan % 10;
                sodu = nhan / 10;
                j--;
            }
            result[i] +=sodu;
            i--;
        }

        return new Short84_LargeNumber(covertToString(result));

    }
}
