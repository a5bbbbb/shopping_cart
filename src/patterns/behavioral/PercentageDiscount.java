package patterns.behavioral;

public class PercentageDiscount implements DiscountStrategy {
    private final double discountPercentage;

    public PercentageDiscount(double discountPercentage) {
        this.discountPercentage = discountPercentage;
    }

    @Override
    public double applyDiscount(double amount) {
        return amount - (amount * discountPercentage / 100);
    }
}