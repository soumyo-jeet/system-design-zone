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

interface DB {
    // Responsibility 1: record to db
    void record();
}

class Mongo implements  DB {
    @Override
    public void record() {
        System.out.println("Record stored to MongoDB");
    }
}

class SQL implements  DB {
    @Override
    public void record() {
        System.out.println("Record stored to SQL");
    }
}

class Excel implements  DB {
    @Override
    public void record() {
        System.out.println("Record stored to Excel");
    }
}



public class OCP_followed {
    public static void main (String [] args) {
        Cart myCart = new Cart();
        myCart.addProduct(new Product("biscuits", 5.36));
        myCart.addProduct(new Product("Milk", 30.50));
        
        Invoice myInvoice = new Invoice(myCart);
        myInvoice.printInvoice();

        DB mongoDb = new Mongo();
        DB sqlDb = new SQL();
        DB excel = new Excel();

        mongoDb.record();
        sqlDb.record();
        excel.record();
    }
}