/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package slot7;

/**
 *
 * @author ADMIN
 */
public class Main {
    public static void main(String[] args) {
        // 1. Khởi tạo mảng các tham chiếu Shape đến các đối tượng cụ thể 
        Shape[] shapes = new Shape[]{
            new Circle(5.0),
            new Square(4.0),
            new Triangle(6.0, 8.0),
            new Sphere(3.0),
            new Cube(5.0),
            new Tetrahedron(7.0)
        };

        System.out.println("--- Processing Shapes Array ---");

        // 2. Vòng lặp xử lý tất cả các hình 
        for (Shape shape : shapes) {
            System.out.println("\n-------------------------------------");

            // 3. In đối tượng
            System.out.println("Object reference: " + shape.toString());

            // 4. Kiểm tra loại hình và hiển thị thông tin 

            if (shape instanceof TwoDimensionalShape) {
                // Nếu là hình hai chiều, hiển thị diện tích 
                TwoDimensionalShape twoD = (TwoDimensionalShape) shape;
                System.out.println("Shape Type: Two-Dimensional");
                System.out.printf("Area: %.2f\n", twoD.getArea());
            } 
            else if (shape instanceof ThreeDimensionalShape) {
                // Nếu là hình ba chiều, hiển thị diện tích (bề mặt) và thể tích 
                ThreeDimensionalShape threeD = (ThreeDimensionalShape) shape;
                System.out.println("Shape Type: Three-Dimensional");
                System.out.printf("Surface Area: %.2f\n", threeD.getArea());
                System.out.printf("Volume: %.2f\n", threeD.getVolume());
            }
        }
    }
}
