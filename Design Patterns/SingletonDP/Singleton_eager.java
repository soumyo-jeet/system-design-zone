// CREATE THE OBJECT / INSTANCE EVEN WHEN ITS NOT ASKED 

class A {
    private static A instanceA = new A();

    private A () {
        System.out.println("Object created!");
    }

    public static A makeA () {
        if(instanceA == null){
            instanceA = new A();
        }

        else {
            System.out.println("Created instance returned!");
        }

        return instanceA;
    }
}

public class Singleton_eager {
    public static void main(String[] args) {
        A a1 = A.makeA();
        A a2 = A.makeA();
        A a3 = A.makeA();
    }    
}
