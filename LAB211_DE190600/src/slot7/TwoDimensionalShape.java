/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package slot7;

/**
 *
 * @author ADMIN
 */
// Lớp trừu tượng cho các hình hai chiều
public abstract class TwoDimensionalShape extends Shape {

    // Mọi hình hai chiều phải có phương thức getArea()
    public abstract double getArea(); 

    @Override
    public String toString() {
        return "This is a Two-Dimensional Shape."; 
    }
}
