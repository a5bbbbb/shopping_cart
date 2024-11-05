package patterns.structural;
import patterns.creational.Item;

public abstract class ItemDecorator extends Item {
    protected Item decoratedItem;

    public ItemDecorator(Item decoratedItem) {
        this.decoratedItem = decoratedItem;
    }

    public abstract double getPrice();

    // Apply a seasonal discount (e.g., 10% off)
    public double applySeasonalDiscount(double discountPercentage) {
        return getPrice() * (1 - discountPercentage / 100);
    }

    // Customize appearance options (this could be useful for different decorators)
    public void customizeAppearance(String color, String theme) {
        System.out.println("Customizing appearance with color: " + color + " and theme: " + theme);
    }
}