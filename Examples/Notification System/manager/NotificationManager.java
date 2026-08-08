package manager;

import java.util.*;

import context.INotificationContext;
import observables.NotificationObservable;

public class NotificationManager {
    private static NotificationManager instance;

    private List<INotificationContext> notifications;
    private NotificationObservable notificationObservable;

    private NotificationManager (NotificationObservable notificationObservable) {
        this.notificationObservable = notificationObservable;
        this.notifications = new ArrayList<>();
    }

    public static NotificationManager getManager (NotificationObservable notificationObservable) {
        if(instance == null) 
            instance = new NotificationManager(notificationObservable);
        return instance;
    }

    public void sendNotification (INotificationContext notification) {
        notificationObservable.setNotifactionContext(notification);
        notifications.add(notification);
    }

    public void listNotifications () {
        System.out.println("Notification History: ");
        for(INotificationContext n : notifications) {
            System.out.println(n.getContext());
        }
    }

}
