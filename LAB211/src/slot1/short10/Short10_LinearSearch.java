/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package slot1.short10;

import java.util.Scanner;
import java.util.Random;
import java.util.Arrays;

/**
 *
 * @author ADMIN
 */
public class Short10_LinearSearch {
    public void makeRandomArrayOnNumberAndSearch(int number, int search) {
        int[] randomArray = new int[number];
        Random random = new Random();

        for (int i = 0; i < randomArray.length; i++) {
            randomArray[i] = random.nextInt(10 - 1 + 1) + 1;
        }

        System.out.println("The array: " + Arrays.toString(randomArray));

        boolean found = false;

        for (int i = 0; i < randomArray.length; i++) {
            if (randomArray[i] == search) {
                System.out.println("Found " + search + " at index: " + i);
                found = true;
                break;
                
            }
        }

        if (!found) {
            System.out.println("Could not find a " + search + " in the array.");
        }
    }
}