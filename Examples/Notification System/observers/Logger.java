package observers;

import context.INotificationContext;
import observables.NotificationObservable;

public class Logger implements IObserver {
    NotificationObservable notificationObservable;
    String notificationMsg;    

    public Logger(NotificationObservable notificationObservable) {
        this.notificationObservable = notificationObservable;
    }

    @Override
    public void update() {
        INotificationContext notificationContext = notificationObservable.getNotifactionContext();
        this.notificationMsg = notificationContext.getContext();

        System.out.println("CONSOLE: (New Notification) " + this.notificationMsg);
    }
    
}
