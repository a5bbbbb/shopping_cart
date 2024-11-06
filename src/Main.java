import patterns.creational.*;
import patterns.structural.*;
import patterns.behavioral.*;
import architecture.*;
import patterns.behavioral.EmailNotification;
import patterns.behavioral.SMSNotification;
import patterns.behavioral.PercentageDiscount;

public class Main {
    public static void main(String[] args) {
        // Initialize MVC components
        Model model = new Model();
        View view = new View();
        Controller controller = new Controller(model, view);

        // Singleton - Cart
        CartSingleton cart = CartSingleton.getInstance();

        // Factory Pattern - Create items
        Item book = ItemFactory.createItem("book");
        Item electronics = ItemFactory.createItem("electronics");

        // Decorator Pattern - Add gift wrap with customizations
        GiftWrapDecorator giftWrappedBook = new GiftWrapDecorator(book, "premium", "Happy Birthday!");
        giftWrappedBook.showGiftDetails(); // Display gift wrap details including style and message

        // Apply a seasonal discount on the wrapped item
        double discountedPrice = giftWrappedBook.applySeasonalDiscount(10); // Applying a 10% seasonal discount
        System.out.println("Discounted Price after seasonal discount: $" + discountedPrice);

        // Adapter Pattern - Convert and display price in multiple currencies
        PriceAdapter priceAdapter = new PriceAdapter(electronics);
        priceAdapter.displayConvertedPrice("EURO");
        priceAdapter.displayConvertedPrice("GBP");
        priceAdapter.displayConvertedPrice("YEN");

        // Observer Pattern - Set up observers for cart notifications
        Cart cartWithObservers = new Cart();
        CartObserver emailNotification = new EmailNotification();
        CartObserver smsNotification = new SMSNotification();
        cartWithObservers.addObserver(emailNotification);
        cartWithObservers.addObserver(smsNotification);

        // Add items to the cart and notify observers
        if (book != null) {
            cart.addToTotal(book.getPrice());
        }
        cartWithObservers.notifyObservers(cart.getTotal()); // Notify after adding book

        if (electronics != null) {
            cart.addToTotal(electronics.getPrice());
        }
        cartWithObservers.notifyObservers(cart.getTotal()); // Notify after adding electronics

        // Strategy Pattern - Use PayPalPayment with PercentageDiscount
        PaymentStrategy payment = new PayPalPayment();
        DiscountStrategy discount = new PercentageDiscount(15); // Applying a 15% discount for the payment
        payment.pay(cart.getTotal(), discount); // Pay using PayPal with discount

        // Update the MVC controller to reflect the final total
        controller.updateTotalPrice(cart.getTotal());
    }
}