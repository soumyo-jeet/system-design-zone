interface Burger {
    void serve();
}

interface Momo {
    void serve();
}

// Burger type A 
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


// Momo type A 
class MomoType1A implements Momo {
    @Override
    public void serve () {
        System.out.println("This is Momo A Type 1.");
    }
}

class MomoType2A implements Momo{
    @Override
    public void serve () {
        System.out.println("This is Momo A Type 2.");
    }
}

class MomoType3A implements Momo {
    @Override
    public void serve () {
        System.out.println("This is Momo A Type 3.");
    }
}

// type B
class MomoType1B implements Momo {
    @Override
    public void serve () {
        System.out.println("This is Momo B Type 1.");
    }
}

class MomoType2B implements Momo {
    @Override
    public void serve () {
        System.out.println("This is Momo B Type 2.");
    }
}

class MomoType3B implements Momo {
    @Override
    public void serve () {
        System.out.println("This is Momo B Type 3.");
    }
}

// Factory
interface Factory {
    Burger cookBurger(int type) ;
    Momo cookMomo(int type) ;
}

class FactoryA implements Factory {
    @Override
    public Burger cookBurger(int type) {
        if (type == 1) return new BurgerType1A();
        else if (type == 2) return new BurgerType2A();
        else return new BurgerType3A();
    }

    @Override
    public Momo cookMomo(int type) {
        if (type == 1) return new MomoType1A();
        else if (type == 2) return new MomoType2A();
        else return new MomoType3A();
    }

}

class FactoryB implements Factory {
    @Override
    public Burger cookBurger(int type) {
        if (type == 1) return new BurgerType1B();
        else if (type == 2) return new BurgerType2B();
        else return new BurgerType3B();
    }

    @Override
    public Momo cookMomo(int type) {
        if (type == 1) return new MomoType1B();
        else if (type == 2) return new MomoType2B();
        else return new MomoType3B();
    }

}


public class AbstractFactory {
    public static void main (String [] args) {
        Factory factoryA = new FactoryA();
        Factory factoryB = new FactoryB();

        factoryA.cookBurger(3).serve();
        factoryA.cookMomo(2).serve();
        factoryB.cookBurger(1).serve();
        factoryB.cookMomo(3).serve();

    }
    
}
