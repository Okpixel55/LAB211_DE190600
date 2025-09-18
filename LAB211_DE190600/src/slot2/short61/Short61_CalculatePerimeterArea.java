/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package slot2.short61;

/**
 *
 * @author ADMIN
 */
import slot2.Validator;

public class Short61_CalculatePerimeterArea {
       public void printResult() {
        
        System.out.println("----- Circle -----");
        double circleInput = Validator.checkNumDouble("Radius: ", true);
        Shape circle =new Circle(circleInput);   
        double areaOfCircle = circle.getArea();
        double perimeterOfCircle = circle.getPerimeter();
        System.out.println("The area of the circle is: " + areaOfCircle);
        System.out.println("The perimeter of the circle is: " + perimeterOfCircle);
        
        System.out.println("----- Rectangle -----");
        double rectangleLengthInput = Validator.checkNumDouble("Length: ", true);
        double rectangleWidthInput = Validator.checkNumDouble("Width: ", true);
        Shape rectangle =new Rectangle(rectangleLengthInput,rectangleWidthInput);   
        double areaOfRectangle = rectangle.getArea();
        double perimeterOfRectangle = rectangle.getPerimeter();
        System.out.println("The area of the rectangle is: " + areaOfRectangle);
        System.out.println("The perimeter of the rectangle is: " + perimeterOfRectangle);
        
       System.out.println("----- Triangle -----");
        double a = Validator.checkNumDouble("Side A: ", true);
        double b = Validator.checkNumDouble("Side B: ", true);
        double c = Validator.checkNumDouble("Side C: ", true);
        Shape triangle =new Triangle(a,b,c);   
        double areaOfTriangle = triangle.getArea();
        double perimeterOfTriangle = triangle.getPerimeter();
        System.out.println("The area of the Triangle is: " + areaOfTriangle);
        System.out.println("The perimeter of the Triangle is: " + perimeterOfTriangle);
        
    } 
}
