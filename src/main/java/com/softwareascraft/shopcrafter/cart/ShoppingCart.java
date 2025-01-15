package com.softwareascraft.shopcrafter.cart;

import ch.qos.logback.core.BasicStatusManager;
import com.softwareascraft.shopcrafter.goods.Item;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {

    private final List<Item> itemList = new ArrayList<>();

    public int itemCount() {
        return itemList.size();
    }

    public void addItem(Item addedItem) {
        this.itemList.add(addedItem);
    }

    public int subTotal() {
        return 100;
    }
}
