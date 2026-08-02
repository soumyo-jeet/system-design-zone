// ORCHESTOR CLASS
import java.util.*;
import factories.*;
import managers.*;
import models.*;
import services.*;

public class App {


    public App () {
        initApp();
    }

    public void initApp () {
        ResturantManager rmanager = ResturantManager.getInstance();

        Resturant r1 = new Resturant("mukundapur", "xyz food centre");
        r1.addItem(new Item(1, "kebab", 145));
        r1.addItem(new Item(2, "biryani", 145));
        r1.addItem(new Item(3, "momo", 100));
        r1.addItem(new Item(4, "roll", 60));
        r1.addItem(new Item(5, "pizza", 150));

        Resturant r2 = new Resturant("mukundapur", "fries");
        r2.addItem(new Item(1, "kebab", 55));
        r2.addItem(new Item(2, "biryani", 90));
        r2.addItem(new Item(3, "momo", 50));
        r2.addItem(new Item(4, "roll", 50));
        r2.addItem(new Item(5, "pizza", 100));

        Resturant r3 = new Resturant("garia", "foodyy");
        r3.addItem(new Item(3, "momo", 60));
        r3.addItem(new Item(4, "roll", 50));
        r3.addItem(new Item(5, "mughlai paratha", 110));

        Resturant r4 = new Resturant("garia", "food hub");
        r4.addItem(new Item(3, "momo", 60));
        r4.addItem(new Item(4, "roll", 50));
        r4.addItem(new Item(5, "mughlai paratha", 110));
        r4.addItem(new Item(6, "lachcha paratha", 20));
        r4.addItem(new Item(7, "veg chowmein", 70));

        rmanager.addResturants(r1);
        rmanager.addResturants(r2);
        rmanager.addResturants(r3);
        rmanager.addResturants(r4);

        System.out.println("---WELCOME---");
        rmanager.listResturants ();
    }


    public User login (String username, String addr, String email) {
        Cart cart = new Cart();
        return new User(username, addr, email, cart);
    }

    public void searchNearbyResturants (User user) {
        List<Resturant> resturants = ResturantManager.getInstance().searchResturants (user);
        ResturantManager.getInstance().listResturants(resturants);
    }

    public Resturant getResturantById (int id) {
        return ResturantManager.getInstance().getResturantById(id);
    }

    public Item selectItemByName (Resturant r, String name) {
        List<Item> items = r.getItems();

        for(Item i : items) {
            if(i.getName() == name) return i;
        }
        return null;
    }

    public void addToCart(User user, Item item, Resturant resturant) {
        Cart userCart = user.getCart();
        userCart.setResturant(resturant);
        userCart.addToCart(item);
    }

    public void makeSchDeliveryOrder(User user) {
        Cart cart = user.getCart();

        OrderFactory factory = ScheduledOrderFactory.getInstance();
        Order order = factory.createDeliveryOrder(cart.getItems(), cart.getResturant(), user, cart.getTotal());

        OrderManager.getInstance().addOrder(order);
    }

    public void makeSchPickupOrder(User user) {
        Cart cart = user.getCart();

        OrderFactory factory = ScheduledOrderFactory.getInstance();
        Order order = factory.createPickupOrder(cart.getItems(), cart.getResturant(), user, cart.getTotal());

        OrderManager.getInstance().addOrder(order);
        cart.resetCart();
    }

    public void makeNSchDeliveryOrder(User user) {
        Cart cart = user.getCart();

        OrderFactory factory = NonScheduledOrderFactory.getInstance();
        Order order = factory.createDeliveryOrder(cart.getItems(), cart.getResturant(), user, cart.getTotal());

        OrderManager.getInstance().addOrder(order);
        cart.resetCart();
    }

    public void makeNSchPickupOrder(User user) {
        Cart cart = user.getCart();

        OrderFactory factory = NonScheduledOrderFactory.getInstance();
        Order order = factory.createPickupOrder(cart.getItems(), cart.getResturant(), user, cart.getTotal());

        OrderManager.getInstance().addOrder(order);
        cart.resetCart();
    }


    public void showOrders () {
        OrderManager.getInstance().listOrders();
    }

    public void placeOrder (String email) {
        NotificationService notification = new NotificationService();
        OrderManager.getInstance().placeOrder();
        notification.sendMsg(email);
    }
}