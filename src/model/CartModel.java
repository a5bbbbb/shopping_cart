package model;

import patterns.behavioral.Cart;
import patterns.creational.Item;
import repository.CartRepositoryInterface;

public class CartModel {
    private final CartRepositoryInterface repo;

    public CartModel(CartRepositoryInterface repo) {
        this.repo = repo;
    }

    public Cart getCartById(int id) throws Exception {
        return repo.getCartById(id);
    }

    public Cart createShoppingCart(){
        return repo.createCart();
    }
}
