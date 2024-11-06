package patterns.structural;
import patterns.creational.Item;

public abstract class ItemDecorator extends Item {
    protected Item decoratedItem;

    public ItemDecorator(Item decoratedItem) {
        super(decoratedItem.getId());
        this.decoratedItem = decoratedItem;
    }

    public double getPrice(){
        return decoratedItem.getPrice();
    }

    public void customizeAppearance(String color, String theme) {
        System.out.println("Customizing appearance with color: " + color + " and theme: " + theme);
    }
}