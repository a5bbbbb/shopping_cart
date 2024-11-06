package patterns.behavioral;

public class SMSNotification extends CartObserver {
    public SMSNotification(String name) {
        super(name);
    }

    @Override
    public void update(Cart cart) {
        System.out.println("SMS Notification to " + getName() + " : Your cart with id= " + cart.getId() +
                " has changed. Its total is now $" + cart.getCartPrice());
    }
}