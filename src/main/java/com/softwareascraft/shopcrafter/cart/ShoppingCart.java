package com.softwareascraft.shopcrafter.cart;

import com.softwareascraft.shopcrafter.goods.Item;
import com.softwareascraft.shopcrafter.money.TaxCalculator;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {

    private final List<Item> itemList = new ArrayList<>();
    private final TaxCalculator taxCalculator;

    public ShoppingCart(TaxCalculator taxCalculator) {
        this.taxCalculator = taxCalculator;
    }

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
