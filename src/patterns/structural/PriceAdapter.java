package patterns.structural;
import patterns.creational.Item;

public class PriceAdapter {
    private final Item item;
    private static final double USD_TO_EURO = 0.85;
    private static final double USD_TO_GBP = 0.75;
    private static final double USD_TO_YEN = 110.0;

    public PriceAdapter(Item item) {
        this.item = item;
    }

    public double getPriceInCurrency(String currency) {
        return switch (currency.toUpperCase()) {
            case "EURO" -> item.getPrice() * USD_TO_EURO;
            case "GBP" -> item.getPrice() * USD_TO_GBP;
            case "YEN" -> item.getPrice() * USD_TO_YEN;
            default -> -1;
        };
    }

    public void displayConvertedPrice(String currency) {
        System.out.printf("Price in %s: %.2f%n", currency, getPriceInCurrency(currency));
    }
}