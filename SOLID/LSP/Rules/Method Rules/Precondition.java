// Pre condition for sign up: password len should be greater than 8
class User {
    void signup (String pass) {
        if(pass.length() >= 8) {
            System.out.println("Sign up successfully");
        }
        else System.out.println("Bad password");
    }
}


// Pre condition reduces
class Admin extends User {
    @Override
    void signup (String pass) {
        if(pass.length() >= 6) {
            System.out.println("Sign up successfully");
        }
        else System.out.println("Bad password");
    }
}

public class Precondition {
    
}
