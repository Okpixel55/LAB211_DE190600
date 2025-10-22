/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package slot6;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public class Order {
    private String cusName;
    private List<OrderDetail> items =new ArrayList<>();
    private double total;

    public Order(String cusName) {
        this.cusName = cusName;
    }

    public String getCusName() {
        return cusName;
    }

    public void setCusName(String cusName) {
        this.cusName = cusName;
    }

    public List<OrderDetail> getItems() {
        return items;
    }

    public void setItems(List<OrderDetail> items) {
        this.items = items;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
    
    public void addDetail(OrderDetail od){
    items.add(od);
    total += od.getAmount();
    }

    @Override
    public String toString() {
        StringBuilder sb=new StringBuilder();
        sb.append("Customer: ").append(cusName).append("\n");
        sb.append("Product     | Qty | Price | Amount\n");
        int i=1;
        for(OrderDetail od: items){
        sb.append(i++).append(".").append(od.toString()).append("\n");
        }
         sb.append("Total: ").append(String.format("%.0f$", getTotal()));
    
    return sb.toString();
    }
    
    
}
