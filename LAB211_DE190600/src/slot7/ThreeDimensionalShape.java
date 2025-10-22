/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package slot7;

/**
 *
 * @author ADMIN
 */
// Lớp trừu tượng cho các hình ba chiều
public abstract class ThreeDimensionalShape extends Shape {

    // Mọi hình ba chiều phải có phương thức getArea() (diện tích bề mặt) và getVolume()
    public abstract double getArea();
    public abstract double getVolume(); 

    @Override
    public String toString() {
        return "This is a Three-Dimensional Shape."; 
    }
}
