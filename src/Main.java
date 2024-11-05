import patterns.creational.*;
import patterns.structural.*;
import patterns.behavioral.*;
import architecture.*;

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

        // Decorator Pattern - Add gift wrap
        Item giftWrappedBook = new GiftWrapDecorator(book);

        // Adapter Pattern - Convert price to Euros
        PriceAdapter euroAdapter = new PriceAdapter(electronics);
        System.out.println("Price in Euros: €" + euroAdapter.getPriceInEuros());

        // Observer Pattern
        CartObserver observer = new Cart();
        cart.addToTotal(book.getPrice());
        cart.addToTotal(electronics.getPrice());
        observer.update(cart.getTotal());

        // Strategy Pattern - Select payment method
        PaymentStrategy payment = new CreditCardPayment();
        payment.pay(cart.getTotal());

        controller.updateTotalPrice(cart.getTotal());
    }
}