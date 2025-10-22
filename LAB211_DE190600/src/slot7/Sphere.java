/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package slot7;

/**
 *
 * @author ADMIN
 */
public class Sphere extends ThreeDimensionalShape {
    private double radius;

    public Sphere(double radius) {
        this.radius = radius;
    }

    @Override
    public double getArea() {
        // Diện tích bề mặt hình cầu: A = 4 * pi * r^2 
        return 4 * Math.PI * radius * radius;
    }

    @Override
    public double getVolume() {
        // Thể tích hình cầu: V = (4/3) * pi * r^3 
        return (4.0 / 3.0) * Math.PI * Math.pow(radius, 3);
    }

    @Override
    public String toString() {
        return "Sphere with radius: " + radius; 
    }
}
