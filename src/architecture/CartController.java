package architecture;

import model.CartModel;
import model.ItemModel;
import patterns.behavioral.Cart;
import patterns.creational.Item;

public class CartController {
    private final CartModel cartModel;
    private final ItemModel itemModel;
    private final View view;

    public CartController(CartModel cartModel, ItemModel itemModel, View view) {
        this.cartModel = cartModel;
        this.itemModel = itemModel;
        this.view = view;
    }

    public int createShoppingCart(){
        return cartModel.createShoppingCart().getId();
    }

    public void addItemToShoppingCart(int itemIds, int cartId){
        Cart cart = null;
        Item item = null;
        try {
            cart = cartModel.getCartById(cartId);
            item = itemModel.getItemById(itemIds);
            cart.addItem(item);
        } catch (Exception e){
            view.displayException(e);
        }
    }

    public void removeItemFromShoppingCart(int itemIds, int cartId){
        Cart cart = null;
        Item item = null;
        try {
            cart = cartModel.getCartById(cartId);
            item = itemModel.getItemById(itemIds);
            cart.removeItem(item);
        } catch (Exception e){
            view.displayException(e);
        }
    }
}