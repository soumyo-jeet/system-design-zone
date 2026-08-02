package factories;

import java.util.List;
import models.*;

public class ScheduledOrderFactory implements OrderFactory {

    private static ScheduledOrderFactory instance;
    private ScheduledOrderFactory () {}

    public static ScheduledOrderFactory getInstance () {
        if(instance == null) instance = new ScheduledOrderFactory();
        return instance;
    }


    @Override
    public Order createPickupOrder 
    (List<Item> items, Resturant r, User user, double total) {
        return new PickupOrder(items, r, user, total, true);
    }

    @Override
    public Order createDeliveryOrder 
    (List<Item> items, Resturant r, User user, double total) {
        return new DeliveryOrder(items, r, user, total, true);
    }
}