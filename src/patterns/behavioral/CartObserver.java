import java.util.ArrayList;
import java.util.List;

public interface CartObserver {
    void update(double total);
}

public class Cart implements CartObserver {
    private List<CartObserver> observers = new ArrayList<>();

    public void addObserver(CartObserver observer) {
        observers.add(observer);
    }

    public void notifyObservers(double total) {
        for (CartObserver observer : observers) {
            observer.update(total);
        }
    }

    @Override
    public void update(double total) {
        System.out.println("Updated cart total: $" + total);
    }
}