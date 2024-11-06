package patterns.creational;

public class ItemFactory {
    public static Item createItem(String type, int id) {
        return switch (type.toLowerCase()) {
            case "book" -> new Book(id);
            case "electronics" -> new Electronics(id);
            default -> null;
        };
    }
}