package patterns.structural;
import patterns.creational.Item;

public class GiftWrapDecorator extends ItemDecorator {
    private final String wrapStyle;
    private final String message;

    public GiftWrapDecorator(Item decoratedItem, String wrapStyle, String message) {
        super(decoratedItem);
        this.wrapStyle = wrapStyle;
        this.message = message;
    }

    public void showGiftDetails() {
        System.out.println("Gift Wrap Style: " + wrapStyle);
        System.out.println("Message: " + message);
        System.out.println("Total Price with Gift Wrap: $" + getPrice());
    }
}