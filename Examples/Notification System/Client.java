import context.HTMLNotificationContext;
import context.INotificationContext;
import context.SimpleNotificationContext;
import decorators.SignDecorator;
import decorators.TimestampDecorator;
import manager.NotificationManager;
import observables.NotificationObservable;
import observers.Logger;
import observers.Sender;
import strategies.Email;
import strategies.Whatsapp;

public class Client {
    public static void main(String[] args) {
        // Observable configuration
        NotificationObservable notificationObservable = new NotificationObservable();

        Sender sender = new Sender(notificationObservable);
        Logger logger = new Logger(notificationObservable);

        sender.addStrategy(new Whatsapp("9477450112"));
        sender.addStrategy(new Email("samajdar@gmail.com"));

        notificationObservable.addObserver(logger);
        notificationObservable.addObserver(sender);


        // manager instance
        NotificationManager manager = NotificationManager.getManager(notificationObservable);

        // sending notifications
        INotificationContext notification1 = new SignDecorator(
            new SimpleNotificationContext("Hello World"), 
            "Mr. jeet."
        );

        INotificationContext notification2 = new TimestampDecorator(
            new HTMLNotificationContext("Class routine.", "Routine File.")
        );

        INotificationContext notification3 = new SignDecorator(
            new TimestampDecorator(
                new HTMLNotificationContext("Your Result", "Result Document")
            ), 
            "Dr. Soumyo"
        );

        manager.sendNotification(notification1);
        manager.sendNotification(notification2);
        manager.sendNotification(notification3);
    }
}
