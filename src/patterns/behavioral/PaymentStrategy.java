package patterns.behavioral;

public interface PaymentStrategy {
    void pay(double amount, DiscountStrategy discount);
}
