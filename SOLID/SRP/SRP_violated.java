import java.util.Vector;
class Product {
    String name;
    double price;

    Product(String name, double price) {
        this.name = name;
        this.price = price;
    }
}

class Cart {
    Vector<Product> products = new Vector<>();

    // Responsibility 1: add products
    public void addProduct(Product p) {
        products.add(p);
    }

    // Responsibility 2: print invoice
    void printInvoice() {
        double total = 0;

        for (Product p : products) {
            System.out.println(p.name + " : " + p.price);
            total += p.price;
        }

        System.out.println("Total = " + total);
    }

    // Responsibility 3: record to db
    void record() {
        System.out.println("Record stored to database");
    }
}



public class SRP_violated {
    public static void main (String [] args) {
        Cart myCart = new Cart();
        myCart.addProduct(new Product("biscuits", 5.36));
        myCart.addProduct(new Product("Milk", 30.50));

        myCart.printInvoice();
        myCart.record();
    }
}