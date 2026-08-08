package context;


public class HTMLNotificationContext implements INotificationContext{
    String text;
    String file;


    public HTMLNotificationContext(String text, String file) {
        this.text = text;
        this.file = file;
    }


    @Override
    public String getContext() {
        String ctx = "Message: " + this.text + " \n File: " + this.file;
        return ctx;
    }


    public String getText() {
        return text;
    }


    public void setText(String text) {
        this.text = text;
    }


    public String getFile() {
        return file;
    }


    public void setFile(String file) {
        this.file = file;
    }
}
