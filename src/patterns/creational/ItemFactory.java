package patterns.creational;

public class ItemFactory {
    public static Item createItem(String type) {
        return switch (type.toLowerCase()) {
            case "book" -> new Book();
            case "electronics" -> new Electronics();
            default -> null;
        };
    }
}