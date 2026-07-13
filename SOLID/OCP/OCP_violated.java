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
}

class Invoice {
    Vector<Product> products;

    Invoice (Cart cart) {
        this.products = cart.products;
    }


    // Responsibility 1: print invoice
    void printInvoice() {
        double total = 0;

        for (Product p : products) {
            System.out.println(p.name + " : " + p.price);
            total += p.price;
        }

        System.out.println("Total = " + total);
    }

}

class DB {
    // Responsibility 1: record to db
    
    // Feature 1: record to mongo
    void recordToMongo() {
        System.out.println("Record stored to MongoDB");
    }

    // Feature 2: record to sql
    void recordToSQL() {
        System.out.println("Record stored to MongoDB");
    }

    // Feature 3: record to excel
    void recordToSheet() {
        System.out.println("Record stored to MongoDB");
    }
}



public class OCP_violated {
    public static void main (String [] args) {
        Cart myCart = new Cart();
        myCart.addProduct(new Product("biscuits", 5.36));
        myCart.addProduct(new Product("Milk", 30.50));
        
        Invoice myInvoice = new Invoice(myCart);
        myInvoice.printInvoice();

        DB myDb = new DB();
        myDb.recordToMongo();
    }
}