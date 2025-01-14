package com.softwareascraft.shopcrafter.cart;

public class ItemCategory {
    private final String name;

    public ItemCategory(String name) {
        this.name = name;
    }

    public boolean isSameAs(ItemCategory other) {
        return true;
    }
}
