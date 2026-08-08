package strategies;

public class Whatsapp implements IStrategy{
    String wpno;

    public Whatsapp(String wpno) {
        this.wpno = wpno;
    }
    
    @Override
    public void send(String msg) {
        System.out.println("Whatsapp [" + wpno + "] : " + msg);
    }
}
