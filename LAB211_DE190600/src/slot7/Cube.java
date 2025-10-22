/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package slot7;

/**
 *
 * @author ADMIN
 */
public class Cube extends ThreeDimensionalShape {
    private double side;

    public Cube(double side) {
        this.side = side;
    }

    @Override
    public double getArea() {
        // Diện tích bề mặt hình lập phương: A = 6 * side^2
        return 6 * side * side;
    }

    @Override
    public double getVolume() {
        // Thể tích hình lập phương: V = side^3
        return side * side * side;
    }

    @Override
    public String toString() {
        return "Cube with side length: " + side; 
    }
}
