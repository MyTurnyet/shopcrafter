package com.softwareascraft.shopcrafter.cart;

public class Item implements Equatable<Item> {
    private final int sku;
    private final String name;

    public Item(int sku, String name) {
        this.sku = sku;
        this.name = name;
    }

    public boolean isSameAs(Item otherItem) {
        return this.sku == otherItem.sku && this.name.equals(otherItem.name);
    }
}
