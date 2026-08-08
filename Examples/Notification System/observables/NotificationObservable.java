package observables;

import observers.IObserver;
import java.util.*;

import context.INotificationContext;

public class NotificationObservable implements IObservable {
    List<IObserver> observers = new ArrayList<>();
    INotificationContext notifactionContext;

    @Override
    public void notifyObserver() {
        for(IObserver o : observers) {
            o.update();
        }
    }

    @Override
    public void addObserver(IObserver o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(IObserver o) {
        observers.remove(o);
    }


    public INotificationContext getNotifactionContext() {
        return notifactionContext;
    }

    public void setNotifactionContext(INotificationContext notifactionContext) {
        this.notifactionContext = notifactionContext;
        notifyObserver();
    }
}
