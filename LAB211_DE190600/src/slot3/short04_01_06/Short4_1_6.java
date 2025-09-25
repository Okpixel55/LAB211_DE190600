/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package slot3.short04_01_06;

import java.util.Arrays;
import java.util.Random;

/**
 *
 * @author ADMIN
 */
public class Short4_1_6 {

    public int[] makeRandomArrayOnNumber(int number) {
        int[] randomArray = new int[number];
        Random random = new Random();

        for (int i = 0; i < randomArray.length; i++) {
            randomArray[i] = random.nextInt(10 - 1 + 1) + 1;
        }

        System.out.println("The array: " + Arrays.toString(randomArray));
        return randomArray;

    }

    public void swap(int[] randomArray, int i, int j) {
        int temp = randomArray[i];
        randomArray[i] = randomArray[j];
        randomArray[j] = temp;
    }

    public void bubbleSortAlgorithm(int[] randomArray) {
        boolean check = false;

        for (int i = 0; i < randomArray.length; i++) {
            for (int j = 0; j < randomArray.length - 1; j++) {
                if (randomArray[j] > randomArray[j + 1]) {
                    swap(randomArray, j, j + 1);
                    check = true;
                }
            }
            if (!check) {
                break;
            }

        }

    }

    public int partition(int[] randomArray, int start, int end) {
        int pivot = randomArray[end];

        int i = start - 1;

        for (int j = start; j < end; j++) {
            if (randomArray[j] <= pivot) {
                i++;
                swap(randomArray, i, j);
            }
        }
        swap(randomArray, i + 1, end);
        return i + 1;
    }

    public void quickSort(int[] randomArray, int start, int end) {
        if (start < end) {
            int pivotIndex = partition(randomArray, start, end);

            quickSort(randomArray, start, pivotIndex - 1);

            quickSort(randomArray, pivotIndex + 1, end);
        }
    }

    public int binarySearch(int[] randomArray, int start, int end, int search) {
    if (start > end) {
        return -1;
    }

    int midIndex = start + (end - start) / 2;
    int midValue = randomArray[midIndex];

    if (midValue == search) {
        return midIndex;
    }

    if (search < midValue) {
        return binarySearch(randomArray, start, midIndex - 1, search);
    } 
    
    else {
        return binarySearch(randomArray, midIndex + 1, end, search);
    }
}
}
