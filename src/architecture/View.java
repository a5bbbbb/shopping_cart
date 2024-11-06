package architecture;

import model.CartModel;
import model.ItemModel;
import patterns.behavioral.Cart;
import patterns.creational.Item;

public class View {
    private final CartModel cartModel;
    private final ItemModel itemModel;

    public View(CartModel cartModel, ItemModel itemModel) {
        this.cartModel = cartModel;
        this.itemModel = itemModel;
    }

    public void displayItemsInCart(int cartId){
        try {
            Cart cart = cartModel.getCartById(cartId);
            System.out.println("Items of a cart with id=" + cart.getId() + ": ");
            for(Item item : cart)
                System.out.println("\t" + item.getClass() + " for " + item.getPrice());
        } catch (Exception e){
            displayException(e);
        }
    }

    public void displayException(Exception e){
        System.out.println(e.getMessage());
    }
}
