package managers;
import java.util.*;
import models.*;

public class ResturantManager {
    private static ResturantManager instance;
    List<Resturant> resturants;

    private ResturantManager () {
        resturants = new ArrayList<>();
    }

    public static ResturantManager getInstance () {
        if(instance == null) instance = new ResturantManager();
        return instance;
    }

    public void addResturants (Resturant resturant) {
        resturants.add(resturant);
    }

    public List<Resturant> searchResturants (User user) {
        List<Resturant> nearby = new ArrayList<>();
        for(Resturant r : resturants) {
            if(user.getAddr() == r.getAddr()) nearby.add(r);
        }

        return nearby;
    }

    public void listResturants () {
        System.out.println("List of available resturants: ");
    
        for(Resturant r : this.resturants) {
            System.out.println(r.getId() + "| " + r.getName() + " - " + r.getAddr());
            System.out.println("\tAvailable Items: ");
            for(Item i : r.getItems()) {
                System.out.println(i.getName() + ": " + i.getPrice());
            }
        }
    }

    public void listResturants (List<Resturant> resturants) {
        System.out.println("List of near by resturants: ");
    
        for(Resturant r : resturants) {
            System.out.println(r.getId() + "| " + r.getName() + " - " + r.getAddr());
            System.out.println("\tAvailable Items: ");
            for(Item i : r.getItems()) {
                System.out.println(i.getName() + ": " + i.getPrice());
            }
        }
    } 

    public Resturant getResturantById (int id) {
        for(Resturant r : resturants) {
            if(r.getId() == id) return r;
        }
        return null;
    }
}