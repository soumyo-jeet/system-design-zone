// Additional reponsibilities are added to the objects dynamically. It provides an alternate way to inheritance for extending funcs

// Each decorator is a character has a character

interface ICharacter {
    public void getAttributes ();
}

interface  IDecorator extends ICharacter {}

// Characters
class Tom implements ICharacter {
    @Override
    public void getAttributes () {
        System.out.println("Tom is here.");
    }
}

class Dogo implements ICharacter {
    @Override
    public void getAttributes () {
        System.out.println("Dogo is here.");
    }
}

// Decorators
class CanTalk implements IDecorator {
    public ICharacter character;

    public CanTalk(ICharacter character) {
        this.character = character;
    }

    @Override
    public void getAttributes () {
        this.character.getAttributes();
        System.out.println("This can talk.");
    }
}

class CanFly implements IDecorator {
    public ICharacter character;

    public CanFly(ICharacter character) {
        this.character = character;
    }
    
    @Override
    public void getAttributes () {
        this.character.getAttributes();
        System.out.println("This can fly.");
    }
}

class CanWalk implements IDecorator {
    public ICharacter character;

    public CanWalk(ICharacter character) {
        this.character = character;
    }

    @Override
    public void getAttributes () {
        this.character.getAttributes();
        System.out.println("This can walk.");
    }
}

class CanSwim implements IDecorator {
    public ICharacter character;

    public CanSwim(ICharacter character) {
        this.character = character;
    }
    
    @Override
    public void getAttributes () {
        this.character.getAttributes();
        System.out.println("This can swim.");
    }
}


public class Decorator {
    public static void main(String[] args) {
        ICharacter myTom = new CanTalk(new CanWalk(new Tom()));
        ICharacter myDogo = new CanFly(new CanSwim(new CanTalk(new Dogo())));

        myTom.getAttributes();
        myDogo.getAttributes();
    }
}
