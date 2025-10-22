/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package slot6;

import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author ADMIN
 */
public class FruitShop {

    private List<Fruit> fruits = new ArrayList<>();
    private List<Order> orders = new ArrayList<>();

    public void run() {
    addFruits();
    showFruits();
    shopping();
    viewOrders();
    showFruits();
    }

    private void addFruits() {
        fruits.add(new Fruit("01", "banana", 3.0, 12, "VN"));
        fruits.add(new Fruit("05", "apple", 2.0, 15, "VN"));
        fruits.add(new Fruit("06", "coconut", 6.0, 10, "VN"));
    }

    private void showFruits() {

        System.out.println("| Item | Fruit Name | Origin | Price | Quantity |");
        int i = 1;
        for (Fruit f : fruits) {
            System.out.printf(
                    "| %-4d | %-10s | %-6s | $%-4.2f | %-8d |\n",
                    i++, // Item number
                    f.getName(), // Fruit Name
                    f.getOrigin(), // Origin
                    f.getPrice(), // Price (formatted to 2 decimal places with $)
                    f.getQuantity() // Quantity
            );
        }

    }
    
    private void shopping(){
        System.out.println("\n--- Bắt đầu Shopping ---");
        
        // ********************
        // *** ĐƠN HÀNG 1: HUNG ***
        // ********************
        Order order1 = new Order("Hung");
        List<OrderDetail> bag1 =new ArrayList<>();
        
        // 1.1 Mua Apple (Qty: 10)
        Fruit item1 = fruits.get(1); // Apple, tồn kho ban đầu: 15
        int qty1=10;
        
        // KIỂM TRA TỒN KHO TRƯỚC KHI GIẢM
        if (item1.getQuantity() >= qty1) {
            item1.setQuantity(item1.getQuantity() - qty1); // 15 -> 5
            bag1.add(new OrderDetail(item1, qty1));
        } else {
            System.out.println("ALERT: Hung không mua được " + item1.getName() + " (Hết hàng/Không đủ).");
        }
        
        // 1.2 Mua Coconut (Qty: 10)
        Fruit item2 = fruits.get(2); // Coconut, tồn kho ban đầu: 10
        int qty2=10;
        
        // KIỂM TRA TỒN KHO TRƯỚC KHI GIẢM
        if (item2.getQuantity() >= qty2) {
            item2.setQuantity(item2.getQuantity() - qty2); // 10 -> 0
            bag1.add(new OrderDetail(item2, qty2));
        } else {
            System.out.println("ALERT: Hung không mua được " + item2.getName() + " (Hết hàng/Không đủ).");
        }
        
        for(OrderDetail od : bag1){
            order1.addDetail(od);
        }
        orders.add(order1);
        System.out.println("Đơn hàng 1 (Hung) đã tạo.");
        
        // ********************
        // *** ĐƠN HÀNG 2: MARY ***
        // ********************
        Order order2 = new Order("Mary");
        List<OrderDetail> bag2 = new ArrayList<>();

        // 2.1 Mua Banana (Qty: 5)
        Fruit item3 = fruits.get(0); // Banana, tồn kho ban đầu: 12
        int qty3 = 5; 
        
        // KIỂM TRA TỒN KHO TRƯỚC KHI GIẢM
        if (item3.getQuantity() >= qty3) {
            item3.setQuantity(item3.getQuantity() - qty3); // 12 -> 7
            bag2.add(new OrderDetail(item3, qty3));
        } else {
            System.out.println("ALERT: Mary không mua được " + item3.getName() + " (Hết hàng/Không đủ).");
        }
        
        // 2.2 Mua Apple (Qty: 8) -> Lỗi: Apple chỉ còn 5 sau đơn hàng 1
        // (Sử dụng item1 vì nó là tham chiếu đến quả Apple trong list fruits)
        int qty4 = 8; 

        // KIỂM TRA TỒN KHO TRƯỚC KHI GIẢM
        if (item1.getQuantity() >= qty4) { 
            item1.setQuantity(item1.getQuantity() - qty4); 
            bag2.add(new OrderDetail(item1, qty4));
        } else {
            System.out.println("ALERT: Mary không mua được " + item1.getName() + ". (Còn: " + item1.getQuantity() + ", Yêu cầu: " + qty4 + ").");
        }

        for(OrderDetail od : bag2){
            order2.addDetail(od);
        }
        // Chỉ thêm order nếu có ít nhất một mặt hàng được mua thành công
        if (!bag2.isEmpty()) { 
            orders.add(order2);
            System.out.println("Đơn hàng 2 (Mary) đã tạo.");
        }
        
        // ********************
        // *** ĐƠN HÀNG 3: JOHN ***
        // ********************
        Order order3 = new Order("John");
        List<OrderDetail> bag3 = new ArrayList<>();
        
        // 3.1 Mua Coconut (Qty: 1) -> Lỗi: Coconut đã hết (Qty: 0) sau đơn hàng 1
        // (Sử dụng item2 vì nó là tham chiếu đến quả Coconut trong list fruits)
        int qty5 = 1;

        // KIỂM TRA TỒN KHO TRƯỚC KHI GIẢM
        if (item2.getQuantity() >= qty5) {
            item2.setQuantity(item2.getQuantity() - qty5);
            bag3.add(new OrderDetail(item2, qty5));
        } else {
            System.out.println("ALERT: John không mua được " + item2.getName() + ". (Còn: " + item2.getQuantity() + ", Yêu cầu: " + qty5 + ").");
        }
        
        // 3.2 Mua Banana (Qty: 2)
        int qty6 = 2; // Banana còn 7

        // KIỂM TRA TỒN KHO TRƯỚC KHI GIẢM
        if (item3.getQuantity() >= qty6) {
            item3.setQuantity(item3.getQuantity() - qty6); // 7 -> 5
            bag3.add(new OrderDetail(item3, qty6));
        } else {
            System.out.println("ALERT: John không mua được " + item3.getName() + " (Hết hàng/Không đủ).");
        }
        
        for(OrderDetail od : bag3){
            order3.addDetail(od);
        }

        if (!bag3.isEmpty()) {
            orders.add(order3);
            System.out.println("Đơn hàng 3 (John) đã tạo.");
        }
        System.out.println("--- Kết thúc Shopping ---");
    }
    
    private void viewOrders() {
        if (orders.isEmpty()) {
            System.out.println("\n*** No orders have been placed yet. ***");
            return;
        }

        System.out.println("\n======== ALL ORDERS (Order Detail Mode) ========");
        
        // Lặp qua từng đơn hàng trong orders List
        for (int i = 0; i < orders.size(); i++) {
            Order order = orders.get(i);
            
            System.out.println("----------------------------------------------------------------");
            // Gọi toString() của Order để in chi tiết theo format đã sửa
            System.out.println(order.toString());
        }
        System.out.println("==========================================");
    }

    
}
