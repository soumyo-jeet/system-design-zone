package  models;

public class User {
    private static int nextId = 0;

    private int id;
    private String username;
    private String addr;
    private String email;
    private Cart myCart;

    public User (String username, String addr, String email, Cart myCart) {
        this.username = username;
        this.addr = addr;
        this.email = email;
        this.myCart = myCart;
        this.id = ++nextId;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUsername (String username) {
        this.username = username;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return  username;
    }

    public String getAddr() {
        return  addr;
    }

    public String getEmail() {
        return  email;
    }

    public Cart getCart() {
        return  myCart;
    }

}
