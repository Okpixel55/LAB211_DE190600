/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package slot2.short51;
import slot2.short51.Main_51.Memory;
/**
 *
 * @author ADMIN
 */  
public class Short51_ComputerProgram {
    
    public void calculatorBMI(double height, double weight){
        double BMI=weight/(height*height);
        System.out.println("BMI Number: "+BMI);
            if(BMI<19){
            System.out.println("BMI Status: Under-standard");
            }else if(19<=BMI && BMI<25){
            System.out.println("BMI Status: standard");
            }else if(25<=BMI && BMI<30){
            System.out.println("BMI Status: over-weight");
            }else if(30<=BMI && BMI<40){
            System.out.println("BMI Status: Fat - should lose weight");
            }else if(BMI>=40){
            System.out.println("BMI Status: Very fat - should lose weight immediately");
            }
}
    
    
    public double calculate(Memory memory, String operator, double b) {
         double a = memory.getNumber();
         
        switch (operator) {
            case "+":
                return a + b;
            case "-":
                return a - b;
            case "*":
                return a * b;
            case "/":
                if (b != 0) {
                    return a / b;
                } else {
                    System.out.println("cannot div 0.");
                    return Double.NaN;
                }
            case "^":
                return Math.pow(a, b);
            default: 
            System.out.println("Invalid operator.");
            return Double.NaN;
                
        }
    }

    

   
    
}
