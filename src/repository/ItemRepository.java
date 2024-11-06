package repository;

import patterns.creational.Item;

import java.util.List;

public class ItemRepository implements ItemRepositoryInterface{
    private List<Item> itemList;
    private int idCounter;

    @Override
    public Item getItemById(int id) throws Exception{
        for (Item item : itemList)
            if(item.getId() == id)
                return item;
        throw new Exception("Error: No item with id=" + id);
    }

    @Override
    public void addItemToRepo(Item newItem) {
        itemList.add(newItem);
    }

    @Override
    public int getNewId() {
        return ++idCounter;
    }
}
