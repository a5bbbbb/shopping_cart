import model.CartModel;
import model.ItemModel;
import patterns.creational.*;
import patterns.structural.*;
import patterns.behavioral.*;
import architecture.*;
import patterns.behavioral.EmailNotification;
import patterns.behavioral.SMSNotification;
import repository.CartRepository;
import repository.CartRepositoryInterface;
import repository.ItemRepository;
import repository.ItemRepositoryInterface;

public class Main {
    public static void main(String[] args) throws Exception {
        // Initialize MVC components

        ItemRepositoryInterface itemRepo = new ItemRepository();
        CartRepositoryInterface cartRepo = new CartRepository();
        CartModel cartModel = new CartModel(cartRepo);
        ItemModel itemModel = new ItemModel(itemRepo);

        View view = new View(cartModel, itemModel);
        CartController cartController = new CartController(cartModel, itemModel, view);
        ItemController ItemController = new ItemController(itemModel, view);

        // Factory Pattern - Create items
        int bookId = ItemController.createItem("book");
        int electronicsId = ItemController.createItem("electronics");

        // Decorator Pattern - Add gift wrap with customizations
        GiftWrapDecorator giftWrappedBook = new GiftWrapDecorator(itemModel.getItemById(bookId), "premium", "Happy Birthday!");
        giftWrappedBook.showGiftDetails();

        // Adapter Pattern - Convert and display price in multiple currencies
        PriceAdapter priceAdapter = new PriceAdapter(itemModel.getItemById(electronicsId));
        priceAdapter.displayConvertedPrice("EURO");
        priceAdapter.displayConvertedPrice("GBP");
        priceAdapter.displayConvertedPrice("YEN");

        // Observer Pattern - Set up observers for cart notifications
        int cartId = cartController.createShoppingCart();
        CartObserver emailNotification = new EmailNotification("Zhannur");
        CartObserver smsNotification = new SMSNotification("Alan");
        cartModel.getCartById(cartId).addObserver(emailNotification);
        cartModel.getCartById(cartId).addObserver(smsNotification);

        // Add items to the cart and notify observers
        cartModel.getCartById(cartId).addItem(giftWrappedBook);
        cartModel.getCartById(cartId).notifyObservers();
        view.displayItemsInCart(cartModel.getCartById(cartId).getId());

        cartModel.getCartById(cartId).addItem(itemModel.getItemById(electronicsId));
        cartModel.getCartById(cartId).notifyObservers();
        view.displayItemsInCart(cartModel.getCartById(cartId).getId());

        // Strategy Pattern - Use PayPalPayment with PercentageDiscount
        PaymentStrategy payment = new PayPalPayment();
        payment.pay(cartModel.getCartById(cartId).getCartPrice());

    }
}