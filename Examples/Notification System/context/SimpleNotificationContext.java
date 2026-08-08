package context;

public class SimpleNotificationContext implements INotificationContext{
    String text;

    public SimpleNotificationContext(String text) {
        this.text = text;
    }

    @Override
    public String getContext() {
        String ctx = "Message: " + this.text;
        return ctx;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
