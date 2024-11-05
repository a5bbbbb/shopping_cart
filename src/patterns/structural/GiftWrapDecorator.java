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

    @Override
    public double getPrice() {
        // Additional cost based on wrap style
        double extraCost = switch (wrapStyle.toLowerCase()) {
            case "premium" -> 10.0; // Premium wrap is more expensive
            case "standard" -> 5.0; // Standard wrap
            default -> 2.0; // Basic wrap
        };
        return decoratedItem.getPrice() + extraCost;
    }

    public void showGiftDetails() {
        System.out.println("Gift Wrap Style: " + wrapStyle);
        System.out.println("Message: " + message);
        System.out.println("Total Price with Gift Wrap: $" + getPrice());
    }
}