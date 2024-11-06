package model;

import patterns.behavioral.Cart;
import patterns.creational.Item;
import repository.CartRepositoryInterface;
import repository.ItemRepositoryInterface;

import java.util.List;

public class ItemModel {
    private final ItemRepositoryInterface repo;

    public ItemModel(ItemRepositoryInterface repo) {
        this.repo = repo;
    }

    public Item getItemById(int id) throws Exception {
        return repo.getItemById(id);
    }

    public int getNewId(){
        return repo.getNewId();
    }

    public void addNewItem(Item item){
        repo.addItemToRepo(item);
    }
}
