package patterns.behavioral;

public class EmailNotification implements CartObserver {
    @Override
    public void update(double total) {
        System.out.println("Email Notification: Your cart total is now $" + total);
    }
}
