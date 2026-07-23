package FDP;

// SEPARATE THE BUSSINESS LOGIC FROM THE OBJECT CREATION 
interface Burger {
    void serve();
}

class BurgerType1 implements Burger {
    @Override
    public void serve () {
        System.out.println("This is Burger Type 1.");
    }
}

class BurgerType2 implements Burger {
    @Override
    public void serve () {
        System.out.println("This is Burger Type 2.");
    }
}

class BurgerType3 implements Burger {
    @Override
    public void serve () {
        System.out.println("This is Burger Type 3.");
    }
}


// Factory
class BurgerFactory {
    public Burger cook(int type) {
        if (type == 1) return new BurgerType1();
        else if (type == 2) return new BurgerType2();
        else return new BurgerType3();
    }
}

public class SimpleFactory {
    public static void main (String [] args) {
        BurgerFactory factory = new BurgerFactory();
        Burger burger = factory.cook(3);

        burger.serve();
    }
}