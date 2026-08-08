package decorators;

import context.*;

public class SignDecorator implements IDecorator{
    INotificationContext notifactionContext;
    String sign;

    public SignDecorator(INotificationContext notifactionContext, String sign) {
        this.notifactionContext = notifactionContext;
        this.sign = sign;
    }

    @Override
    public String getContext() {
        String plainCtx = notifactionContext.getContext();
        String ctx = plainCtx + "\n Signature: " + this.sign;
        return ctx;
    }
}
