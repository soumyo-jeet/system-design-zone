package factories;

import java.util.List;
import models.*;

public class NonScheduledOrderFactory implements OrderFactory {
    private static NonScheduledOrderFactory instance;
    private NonScheduledOrderFactory () {}

    public static NonScheduledOrderFactory getInstance () {
        if(instance == null) instance = new NonScheduledOrderFactory();
        return instance;
    }
    
    @Override
    public Order createPickupOrder 
    (List<Item> items, Resturant r, User user, double total) {
        return new PickupOrder(items, r, user, total, false);
    }

    @Override
    public Order createDeliveryOrder 
    (List<Item> items, Resturant r, User user, double total) {
        return new DeliveryOrder(items, r, user, total, false);
    }
}
