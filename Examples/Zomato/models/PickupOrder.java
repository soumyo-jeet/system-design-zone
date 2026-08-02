package models;

import java.util.List;

public class PickupOrder extends Order {
    private String restAddr;

    public PickupOrder (List<Item> items, Resturant r, User user, double total, boolean scheduled) {
        super(items, r, user, total, scheduled);
        this.restAddr = r.getAddr();
    }

    
    @Override
    public void getType() {
        System.out.println("This is a pickup order. Please receive the order from " + this.restAddr);
    }
    
}
