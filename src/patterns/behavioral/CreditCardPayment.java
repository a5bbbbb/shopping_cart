package patterns.behavioral;

public class CreditCardPayment implements PaymentStrategy {
    @Override
    public void pay(double amount, DiscountStrategy discount) {
        double finalAmount = discount.applyDiscount(amount);
        System.out.println("Paid $" + finalAmount + " with Credit Card (Discount applied).");
    }
}