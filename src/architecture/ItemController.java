package architecture;

import model.CartModel;
import model.ItemModel;
import patterns.creational.Item;
import patterns.creational.ItemFactory;

public class ItemController {
    private final ItemModel itemModel;
    private final View view;

    public ItemController(ItemModel itemModel, View view) {
        this.itemModel = itemModel;
        this.view = view;
    }

    public int createItem(String itemType){
        Item newItem = ItemFactory.createItem(itemType, itemModel.getNewId());
        itemModel.addNewItem(newItem);
        return newItem.getId();
    }
}
