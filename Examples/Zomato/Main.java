import models.*;

public class Main {
    public static void main (String args[]) {
        App app = new App();

        // user login
        User user = app.login("sunil", "mukundapur", "s@gmail.com");

        // nearby resturants display
        app.searchNearbyResturants(user);

        // select one resturant
        Resturant r1 = app.getResturantById(2);

        // fill cart
        app.addToCart(user, app.selectItemByName(r1, "kebab"), r1);

        // make order
        app.makeSchPickupOrder(user);


        app.addToCart(user, app.selectItemByName(r1, "biryani"), r1);
        app.makeNSchDeliveryOrder(user);

        app.addToCart(user, app.selectItemByName(r1, "pizza"), r1);
        app.makeSchDeliveryOrder(user);

        app.addToCart(user, app.selectItemByName(r1, "momo"), r1);
        app.makeNSchPickupOrder(user);



        // show orders 
        app.showOrders();

        // place order
        app.placeOrder(user.getEmail());
    }
}
