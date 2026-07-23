interface Burger {
    void serve();
}

// type A 
class BurgerType1A implements Burger {
    @Override
    public void serve () {
        System.out.println("This is Burger A Type 1.");
    }
}

class BurgerType2A implements Burger {
    @Override
    public void serve () {
        System.out.println("This is Burger A Type 2.");
    }
}

class BurgerType3A implements Burger {
    @Override
    public void serve () {
        System.out.println("This is Burger A Type 3.");
    }
}

// type B
class BurgerType1B implements Burger {
    @Override
    public void serve () {
        System.out.println("This is Burger B Type 1.");
    }
}

class BurgerType2B implements Burger {
    @Override
    public void serve () {
        System.out.println("This is Burger B Type 2.");
    }
}

class BurgerType3B implements Burger {
    @Override
    public void serve () {
        System.out.println("This is Burger B Type 3.");
    }
}


// Factory
interface BurgerFactory {
    Burger cook(int type) ;
}

class FactoryA implements BurgerFactory {
    @Override
    public Burger cook(int type) {
        if (type == 1) return new BurgerType1A();
        else if (type == 2) return new BurgerType2A();
        else return new BurgerType3A();
    }
}

class FactoryB implements BurgerFactory {
    @Override
    public Burger cook(int type) {
        if (type == 1) return new BurgerType1B();
        else if (type == 2) return new BurgerType2B();
        else return new BurgerType3B();
    }
}


public class FactorySystem {
    public static void main (String [] args) {
        BurgerFactory factoryA = new FactoryA();
        BurgerFactory factoryB = new FactoryB();

        factoryA.cook(1).serve();
        factoryB.cook(3).serve();
    }
}
