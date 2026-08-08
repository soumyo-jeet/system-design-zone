package decorators;

import context.INotificationContext;
import java.time.LocalDateTime;

public class TimestampDecorator implements IDecorator{
    INotificationContext notifactionContext;

    
    public TimestampDecorator(INotificationContext notifactionContext) {
        this.notifactionContext = notifactionContext;
    }


    @Override
    public String getContext() {
        String plainCtx = notifactionContext.getContext();
        String ctx = plainCtx + "\n Time: " + LocalDateTime.now();
        return ctx;
    }
    
}
