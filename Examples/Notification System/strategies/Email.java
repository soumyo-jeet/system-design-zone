package strategies;

public class Email implements IStrategy {
    String email;

    public Email(String email) {
        this.email = email;
    }

    @Override
    public void send(String msg) {
        System.out.println("Email [" + this.email + "] : " + msg);
    }
    
}
