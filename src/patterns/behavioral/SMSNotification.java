package patterns.behavioral;

public class SMSNotification implements CartObserver {
    @Override
    public void update(double total) {
        System.out.println("SMS Notification: Your cart total is now $" + total);
    }
}