/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package slot7;

/**
 *
 * @author ADMIN
 */
public class Tetrahedron extends ThreeDimensionalShape {
    private double edge; // Độ dài cạnh 'a'

    public Tetrahedron(double edge) {
        this.edge = edge;
    }

    @Override
    public double getArea() {
        // Diện tích bề mặt tứ diện: A = sqrt(3) * a^2 
        return Math.sqrt(3) * edge * edge;
    }

    @Override
    public double getVolume() {
        // Thể tích tứ diện: V = (1/12) * sqrt(2) * a^3 
        return (1.0 / 12.0) * Math.sqrt(2) * Math.pow(edge, 3);
    }

    @Override
    public String toString() {
        return "Tetrahedron with edge length: " + edge; 
    }
}
