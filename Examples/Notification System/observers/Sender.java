package observers;

import context.INotificationContext;

import java.util.ArrayList;
import java.util.List;
import observables.NotificationObservable;
import strategies.IStrategy;

public class Sender implements IObserver {
    NotificationObservable notificationObservable;
    String notificationMsg;
    List<IStrategy> strategies;

    public Sender(NotificationObservable notificationObservable) {
        this.notificationObservable = notificationObservable;
        this.strategies = new ArrayList<>();
    }

    public void addStrategy (IStrategy strategy) {
        strategies.add(strategy);
    }

    public void removeStrategy (IStrategy strategy) {
        strategies.remove(strategy);
    }


    @Override
    public void update() {
        INotificationContext notificationContext = notificationObservable.getNotifactionContext();
        this.notificationMsg = notificationContext.getContext();

        for(IStrategy s: strategies) {
            s.send(notificationMsg);
        }
    }
    
}
