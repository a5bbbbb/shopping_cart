package patterns.structural;
import patterns.creational.Item;

public class GiftWrapDecorator extends ItemDecorator {
    public GiftWrapDecorator(Item decoratedItem) {
        super(decoratedItem);
    }

    @Override
    public double getPrice() {
        return decoratedItem.getPrice() + 5.0; // Adds gift wrap cost
    }
}