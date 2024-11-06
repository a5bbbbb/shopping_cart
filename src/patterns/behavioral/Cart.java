package patterns.behavioral;

import patterns.creational.Item;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Cart implements Iterable<Item>{
    private List<Item> itemList;
    private List<CartObserver> observers;
    private int id;
    private double cartPrice = 0;

    public Cart(int id) {
        itemList = new ArrayList<>();
        observers = new LinkedList<>();
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public double getCartPrice() {
        return cartPrice;
    }

    private void setCartPrice(double cartPrice){
        this.cartPrice = cartPrice;
    }

    public void addItem(Item item){
        itemList.add(item);
        setCartPrice(getCartPrice() + item.getPrice());
    }

    public void removeItem(Item item) throws Exception {
        if (itemList.remove(item))
            setCartPrice(getCartPrice() - item.getPrice());
        else
            throw new Exception("Item with id=" + id + " was not found in cart with id=" + id);
    }

    public void addObserver(CartObserver obs){
        observers.add(obs);
    }

    public void removeObserver(CartObserver obs){
        observers.remove(obs);
    }

    public void notifyObservers(){
        for (CartObserver obs : observers)
            obs.update(this);
    }

    public Iterator<Item> iterator(){
        return itemList.iterator();
    }
}