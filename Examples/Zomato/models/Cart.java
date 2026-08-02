package models;

import java.util.*;

public class Cart {
    private Resturant resturant;
    private List<Item> items;
    double total;

    public Cart () {
        items = new ArrayList<>();
        this.total = 0;
    }
    

    public void addToCart (Item item) {
        items.add(item);
        total += item.getPrice();
    }

    public void setResturant (Resturant resturant) {
        this.resturant = resturant;
    }

    public Resturant getResturant () {
        return resturant;
    }

    public List<Item> getItems () {
        return items;
    }

    public double getTotal () {
        return total;
    }

    public void resetCart() {
        items = new ArrayList<>();
        this.total = 0;
    }
}
