package patterns.behavioral;

public abstract class CartObserver {
    private final String name;

    public CartObserver(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract void update(Cart cart);
}