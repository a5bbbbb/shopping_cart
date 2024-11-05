package patterns.structural;
import patterns.creational.Item;

public class PriceAdapter {
    private Item item;

    public PriceAdapter(Item item) {
        this.item = item;
    }

    public double getPriceInEuros() {
        return item.getPrice() * 0.85; // Converts price to euros
    }
}