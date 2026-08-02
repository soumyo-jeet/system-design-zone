package services;

public class NotificationService {
    public void sendMsg(String email) {
        System.out.println("Order confirmed. (Notification sent to " + email + ")");
    }
}
