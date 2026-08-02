package factories;

import java.util.List;
import models.*;

public interface OrderFactory {
    public Order createPickupOrder 
    (List<Item> items, Resturant r, User user, double total);

    public Order createDeliveryOrder 
    (List<Item> items, Resturant r, User user, double total);
}