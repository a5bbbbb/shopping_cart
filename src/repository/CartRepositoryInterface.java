package repository;

import patterns.behavioral.Cart;

public interface CartRepositoryInterface {
    Cart getCartById(int id) throws Exception;
    Cart createCart();
}
