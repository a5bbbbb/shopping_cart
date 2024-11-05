package patterns.structural;
import patterns.creational.Item;

public abstract class ItemDecorator extends Item {
    protected Item decoratedItem;

    public ItemDecorator(Item decoratedItem) {
        this.decoratedItem = decoratedItem;
    }

    public abstract double getPrice();
}