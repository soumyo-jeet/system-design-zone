// Post Contd. : After execution of the brake methd speed should be decreased
class Car {
    int speed;

    public Car() {
        this.speed = 100;
    }

    public void brake () {
        this.speed -= 20;
    }
}

// Post Contd. increases 
class HybridCar extends Car{
    int charge; 

    public HybridCar() {
        charge = 100;
    }

    @Override
    public void brake () {
        this.speed -= 20;
        this.charge += 10;
    }
}

public class Postcondition {
    
}
