package managers;

import java.util.*;
import models.*;
import services.*;

// save the orders to db etc
public class OrderManager {
    private static OrderManager instance;
    List<Order> orders;
    private PaymentService payment = new PaymentService();



    private OrderManager () {
        orders = new ArrayList<>();
    }

    public static OrderManager getInstance () {
        if(instance == null) instance = new OrderManager();
        return instance;
    }

    public void addOrder (Order order) {
        this.orders.add(order);
        System.out.println("Order added successfully.");
    } 

    public void listOrders () {
        System.out.println("List of your orders: ");
    
        for(Order o : orders) {
            System.out.print(o.getId() + "| " + o.getTotal() + ": ");
            o.getType();
            if(o.isScheduled()) System.out.println("(Receive on scheduled time.)");
        }
    }

    public void placeOrder () {
        double total = 0;
        for(Order o : orders) {
            total += o.getTotal();
        }
        payment.pay(total);
    }
}
