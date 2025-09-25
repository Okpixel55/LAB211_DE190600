package slot3.short83;

import java.util.EmptyStackException;


public class MyStack {

    
    private int[] stackValues;
    private int capacity;      
    private int length;        

   
    public MyStack() {
        this(5);
    }

  
    public MyStack(int cap) {
        if (cap <= 0) {
            throw new IllegalArgumentException("Capacity must be greater than 0");
        }
        this.capacity = cap;
        this.stackValues = new int[capacity];
        this.length = 0;
    }

   
    public boolean isEmpty() {
        return length == 0;
    }

   
    public boolean isFull() {
        return length == capacity;
    }

    
    private void increaseCapacity() {
        int newCap = capacity * 2;
        int[] newArray = new int[newCap];

        
        System.arraycopy(stackValues, 0, newArray, 0, length);

        stackValues = newArray;
        capacity = newCap;
        System.out.println("\n[INFO] Stack capacity increased to " + capacity);
    }

    
    public void push(int x) {
        if (isFull()) {
            increaseCapacity();
        }
        stackValues[length++] = x;
    }

    
    public int pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return stackValues[--length];
    }

    
    public int get() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return stackValues[length - 1];
    }

   
    public void display() {
        if (isEmpty()) {
            System.out.println("Stack is empty.");
            return;
        }
        System.out.print("Stack (bottom-->top): ");
        for (int i = 0; i < length; i++) {
            System.out.print(stackValues[i] + (i == length - 1 ? "" : " "));
        }
        System.out.println(" (Top is " + stackValues[length - 1] + ")");
    }

    

}