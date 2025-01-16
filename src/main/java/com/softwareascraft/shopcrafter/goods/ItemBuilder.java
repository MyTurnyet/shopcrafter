package com.softwareascraft.shopcrafter.goods;

import java.util.ArrayList;
import java.util.List;

public class ItemBuilder {
    private int sku;
    private String name;
    private int price;
    private boolean isImported;
    private ArrayList<ItemCategory> categories = new ArrayList<>();

    public Item create(int sku, String name, int price) {
        return new Item(sku, name, price, categories);
    }

    public ItemBuilder addCategories(List<ItemCategory> categoryList) {
        categories.addAll(categoryList);
        return this;
    }

    public ItemBuilder addCategory(ItemCategory category) {
        categories.add(category);
        return this;
    }

    public ItemBuilder isImported(boolean isImported) {
        if(isImported){
            return this.addCategory(ItemCategory.Imported);
        }
        return this;
    }
}
