package models;
import java.util.*;

public abstract class Order {
    private static int nextId = 0;

    private int id;
    private List<Item> items;
    private Resturant r;
    private User user;
    private double total;
    private boolean scheduled;

    public Order (List<Item> items, Resturant r, User user, double total, boolean scheduled) {
        this.items = items;
        this.r = r;
        this.user = user;
        this.total = total;
        this.scheduled = scheduled;
        this.id = ++nextId;
    }


    public List<Item> getItems () {
        return items;
    }

    public User getUser () {
        return user;
    }

    public double getTotal () {
        return total;
    }

    public double getId() {
        return id;
    }

    public boolean isScheduled() {
        return scheduled;
    }

    public abstract void getType() ;


}