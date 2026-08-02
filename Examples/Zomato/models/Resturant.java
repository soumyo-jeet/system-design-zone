package  models;
import java.util.*;

public class Resturant {
    private static int nextId = 0;

    private int id;
    private String addr;
    private String name;
    private List<Item> items;

    public Resturant (String addr, String name) {
        this.id = ++nextId;
        this.addr = addr;
        this.name = name; 
        items = new ArrayList<>();
    }

    public void addItem (Item i) {
        this.items.add(i);
    }

    public String getAddr () {
        return addr;
    }
    public String getName () {
        return name;
    }
    public List<Item> getItems () {
        return items;
    }
    public int getId () {
        return id;
    }
}
