package models;
import java.util.List;

public class DeliveryOrder extends Order {
    private String userAddr;

    public DeliveryOrder (List<Item> items, Resturant r, User user, double total, boolean scheduled) {
        super(items, r, user, total, scheduled);
        this.userAddr = user.getAddr();
    }

    
    @Override
    public void getType() {
        System.out.println("This is a delivery order. Please receive the order from " + this.userAddr);
    }
}