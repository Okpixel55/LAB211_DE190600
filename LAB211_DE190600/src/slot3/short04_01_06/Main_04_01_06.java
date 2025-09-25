/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package slot3.short04_01_06;

import java.util.Arrays;
import slot3.Validator;

/**
 *
 * @author ADMIN
 */
public class Main_04_01_06 {
    public static void main(String[] args) {
Short4_1_6 program = new Short4_1_6();
        int numberofarray = Validator.checkNumInt( "Enter number of array:", true);
        int radomArray[]=program.makeRandomArrayOnNumber(numberofarray);
        
        
        program.bubbleSortAlgorithm(radomArray);
        System.out.println("The array bubble Sort: " + Arrays.toString(radomArray));
        
        program.quickSort(radomArray, 0, radomArray.length-1);
        System.out.println("The array quick Sort: " + Arrays.toString(radomArray));

        int search = Validator.checkNumInt( "Enter number to search:", true);
        int rs= program.binarySearch(radomArray, 0,radomArray.length-1 , search);
        System.out.println("Result binary search index at :" + rs);
    }
}
