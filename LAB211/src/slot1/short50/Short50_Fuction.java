
package slot1.short50;

import java.util.ArrayList;
import java.util.List;


public class Short50_Fuction {

    
    public List<Float> solveSuperlativeEquation(float a, float b) {
        if (a == 0) {
            if (b == 0) {
                return new ArrayList<>(); 
            } else {
                return null; 
            }
        } else {
            float x = -b / a;
            List<Float> solutions = new ArrayList<>();
            solutions.add(x);
            return solutions;
        }
    }
    
    
    public List<Float> solveQuadraticEquation(float a, float b, float c) {
        List<Float> solutions = new ArrayList<>();
        if (a == 0) {
           
            return solveSuperlativeEquation(b, c);
        }
        
        float delta = b * b - 4 * a * c;
        if (delta < 0) {
            return solutions; 
        } else if (delta == 0) {
            float x = -b / (2 * a);
            solutions.add(x);
        } else {
            float sqrtDelta = (float) Math.sqrt(delta);
            float x1 = (-b + sqrtDelta) / (2 * a);
            float x2 = (-b - sqrtDelta) / (2 * a);
            solutions.add(x1);
            solutions.add(x2);
        }
        return solutions;
    }

    
    public boolean isOdd(float number) {
        if (number % 1 != 0) { 
            return false;
        }
        int integerNumber = (int) number;
        return integerNumber % 2 != 0;
    }

    
    public boolean isPerfectSquare(float number) {
        if (number < 0) {
            return false;
        }
        float sqrt = (float) Math.sqrt(number);
        
        return sqrt == (int) sqrt;
    }
    
    
    public void checkAndPrintProperties(float number) {
        if (isOdd(number)) {
            System.out.println("The number is Odd: " + number);
        } else {
            System.out.println("The number is Even: " + number);
        }

        if (isPerfectSquare(number)) {
            System.out.println("Number is a Perfect Square: " + number);
        }
    }
}

