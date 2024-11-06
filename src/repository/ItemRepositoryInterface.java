package repository;

import patterns.creational.Item;

public interface ItemRepositoryInterface {
    Item getItemById(int id) throws Exception;
    void addItemToRepo(Item newItem);
    int getNewId();
}
