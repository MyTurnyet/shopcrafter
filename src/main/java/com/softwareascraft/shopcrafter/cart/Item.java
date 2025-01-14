package com.softwareascraft.shopcrafter.cart;

public class Item {
    private final int sku;
    private final String name;

    public Item(int sku, String name) {
        this.sku = sku;
        this.name = name;
    }

    public boolean isSameAs(Item otherItem) {
            return true;
    }
}
