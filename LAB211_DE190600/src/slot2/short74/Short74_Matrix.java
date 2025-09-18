package slot2.short74;

import slot2.Validator;

/**
 *
 * @author ADMIN
 */
public class Short74_Matrix {

    private int rows;
    private int columns;
    private double[][] data;

    // Constructor to initialize a matrix
    public Short74_Matrix(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        this.data = new double[rows][columns];
    }

    // Getters
    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

    // Method to input matrix values from the user
    public void inputMatrix(String matrixName) {
        System.out.println("Enter " + matrixName + " values:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                data[i][j] = Validator.checkNumDouble("Enter " + matrixName + "[" + (i + 1) + "][" + (j + 1) + "]: ", false);
            }
        }
    }

    // Method to display the matrix
    // Trong lớp Short74_Matrix
    public void display() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print("[" + data[i][j] + "]");
            }
            System.out.println(); // Xuống dòng sau mỗi hàng
        }
    }

    // Method to add two matrices
    public Short74_Matrix additionMatrix(Short74_Matrix matrix2) {
        if (this.rows != matrix2.getRows() || this.columns != matrix2.getColumns()) {
            throw new IllegalArgumentException("Cannot add matrices of different dimensions.");
        }
        Short74_Matrix result = new Short74_Matrix(rows, columns);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                result.data[i][j] = this.data[i][j] + matrix2.data[i][j];
            }
        }
        return result;
    }

    // Method to subtract two matrices
    public Short74_Matrix subtractionMatrix(Short74_Matrix matrix2) {
        if (this.rows != matrix2.getRows() || this.columns != matrix2.getColumns()) {
            throw new IllegalArgumentException("Cannot subtract matrices of different dimensions.");
        }
        Short74_Matrix result = new Short74_Matrix(rows, columns);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                result.data[i][j] = this.data[i][j] - matrix2.data[i][j];
            }
        }
        return result;
    }

    // Method to multiply two matrices
    public Short74_Matrix multiplicationMatrix(Short74_Matrix matrix2) {
        if (this.columns != matrix2.getRows()) {
            throw new IllegalArgumentException("Cannot multiply matrices. Columns of first matrix must equal rows of second.");
        }
        Short74_Matrix result = new Short74_Matrix(this.rows, matrix2.getColumns());
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < matrix2.getColumns(); j++) {
                for (int k = 0; k < this.columns; k++) {
                    result.data[i][j] += this.data[i][k] * matrix2.data[k][j];
                }
            }
        }
        return result;
    }
}
