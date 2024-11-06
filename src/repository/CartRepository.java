package repository;

import patterns.behavioral.Cart;

import java.util.List;

public class CartRepository implements CartRepositoryInterface {
    private List<Cart> cartList;
    private int idCounter = 0;

    public Cart getCartById(int id) throws Exception {
        for (Cart cart : cartList) {
            if(cart.getId() == id)
                return cart;
        }
        throw new Exception("No cart with id=" + id);
    }

    public Cart createCart(){
        Cart newCart = new Cart(++idCounter);
        cartList.add(newCart);
        return newCart;
    }
}
