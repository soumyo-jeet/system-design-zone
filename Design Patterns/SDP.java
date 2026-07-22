// BEHAVIOURS THAT VARY --> MAKE SEPARATE INTERFACES FOR THEM

interface flyable {
    // strategy 1
    void fly();
}
interface  walkable {
    // strategy 2
    void walk();
}
interface talkable {
    // strategy 3
    void talk();
}

// concrete classes of strategy 1
class flyMthd1 implements flyable{
    @Override 
    public void fly () {
        System.out.println("Flies in method 1");
    }
}
class flyMthd2 implements flyable{
    @Override 
    public void fly () {
        System.out.println("Flies in method 2");
    }
}
/* ... more classes can be added */


// concrete classes of strategy 2
class walkMthd1 implements walkable{
    @Override 
    public void walk () {
        System.out.println("Walkes in method 1");
    }
}
class walkMthd2 implements walkable{
    @Override 
    public void walk () {
        System.out.println("Walkes in method 2");
    }
}
/* ... more classes can be added */



// concrete classes of strategy 3
class talkMthd1 implements talkable{
    @Override 
    public void talk () {
        System.out.println("Talks in method 1");
    }
}
class talkMthd2 implements talkable{
    @Override 
    public void talk () {
        System.out.println("Talks in method 2");
    }
}
/* ... more classes can be added */



class Robot {
    flyable f;
    walkable w;
    talkable t;

    public Robot (flyable f, walkable w, talkable t) {
        this.f = f;
        this.w = w;
        this.t = t;
    }

    public void presentRobot () {
        this.f.fly();
        this.t.talk();
        this.w.walk();
    }
}



class SDP {
    public static void main(String[] args) {
        Robot r1 = new Robot(
            new flyMthd2(),
            new walkMthd2(),
            new talkMthd1()
        );

        r1.presentRobot();
    }

}