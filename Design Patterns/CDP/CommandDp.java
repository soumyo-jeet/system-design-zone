
import java.util.ArrayList;
import java.util.List;

interface ICommand {
    void execute();
    void undo();
}

// Appliances
class AC {
    private double temp;

    public AC() {
        this.temp = 25;
    }

    public double getTemp() {
        return temp;
    }

    public void setTemp(double temp) {
        this.temp = temp;
    }

    public void on () {
        System.out.println("AC is turned on!");
    }

    public void off () {
        System.out.println("AC is turned off!");
    }
}

class Fan {
    public void on () {
        System.out.println("Fan is turned on!");
    }

    public void off () {
        System.out.println("Fan is turned off!");
    }
}


// Appliance -> Command
class FanOnCommand implements ICommand{
    Fan fan;

    public FanOnCommand(Fan fan) {
        this.fan = fan;
    }

    @Override
    public void execute() {
        fan.on();
    }

    @Override
    public void undo() {
        fan.off();
    }
}

class ACOnCommand implements ICommand {
    AC ac;

    public ACOnCommand(AC ac) {
        this.ac = ac;
    }

    @Override
    public void execute() {
        ac.on();
    }

    @Override
    public void undo() {
        ac.off();
    }
}

class ACTempIncrCommand implements  ICommand {
    AC ac;

    public ACTempIncrCommand(AC ac) {
        this.ac = ac;
    }

    @Override
    public void execute() {
        ac.setTemp(ac.getTemp() + 1);
        System.out.println("Temperature is set to " + ac.getTemp());
    }

    @Override
    public void undo() {
        ac.setTemp(ac.getTemp() - 1);
        System.out.println("Temperature is set to " + ac.getTemp());
    }
}


// Remote
class Remote {
    List<ICommand> commands;

    public Remote() {
        commands = new ArrayList <> ();
    }

    public void addCommands (ICommand command) {
        commands.add(command);
    }

    public void pressPBtn (int idx) {
        if(idx < 0 || idx >= commands.size()) { 
            System.out.println("Invalid request."); 
            return; 
        } 

        commands.get(idx).execute();
    }

    public void pressNBtn (int idx) {
        if(idx < 0 || idx >= commands.size()) { 
            System.out.println("Invalid request."); 
            return; 
        } 

        commands.get(idx).undo();
    }

    public void printBtnMap () {
        int idx = 0;
        for(ICommand c: commands) {
            System.out.println(idx++ + " : " + c.getClass().getName());
        }
    }
}

public class CommandDp {
    public static void main(String[] args) {
        Remote myRemote = new Remote();
        myRemote.addCommands(new FanOnCommand(new Fan()));
        myRemote.addCommands(new ACOnCommand(new AC()));
        myRemote.addCommands(new ACTempIncrCommand(new AC()));

        myRemote.printBtnMap();

        myRemote.pressPBtn(2);
        myRemote.pressNBtn(2);

        myRemote.pressPBtn(1);
        myRemote.pressNBtn(1);

        myRemote.pressNBtn(0);

    }
}