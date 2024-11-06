package patterns.behavioral;

public class EmailNotification extends CartObserver {
    public EmailNotification(String name) {
        super(name);
    }

    @Override
    public void update(Cart cart) {
        System.out.println(
                "Email Notification: Your cart with id= " + cart.getId() +
                " has changed. Its total is now $" + cart.getCartPrice());
    }
}
