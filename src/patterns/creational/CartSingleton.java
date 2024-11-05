package patterns.creational;

public class CartSingleton {
    private static CartSingleton instance;
    private double total;

    private CartSingleton() {}

    public static CartSingleton getInstance() {
        if (instance == null) {
            instance = new CartSingleton();
        }
        return instance;
    }

    public double getTotal() {
        return total;
    }

    public void addToTotal(double price) {
        total += price;
    }
}
