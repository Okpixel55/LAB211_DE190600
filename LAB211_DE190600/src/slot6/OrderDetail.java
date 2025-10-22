/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package slot6;

/**
 *
 * @author ADMIN
 */
public class OrderDetail {
    private Fruit fruit;
    private int soluongmua;
    private double amount;

    public OrderDetail(Fruit fruit, int soluongmua) {
        this.fruit = fruit;
        this.soluongmua = soluongmua;
        this.amount = fruit.getPrice()*soluongmua;
    }

    public Fruit getFruit() {
        return fruit;
    }

    public void setFruit(Fruit fruit) {
        this.fruit = fruit;
    }

    public int getSoluongmua() {
        return soluongmua;
    }

    public void setSoluongmua(int soluongmua) {
        this.soluongmua = soluongmua;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "OrderDetail{" + "fruit=" + fruit.getName() + ", soluongmua=" + soluongmua + ", amount=" + amount + '}';
    }
    
    
}
