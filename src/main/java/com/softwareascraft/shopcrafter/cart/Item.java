package com.softwareascraft.shopcrafter.cart;

public class Item implements Equatable<Item> {
    private final int sku;
    private final String name;
    private final int price;

    public Item(int sku, String name, int price) {
        this.sku = sku;
        this.name = name;
        this.price = price;
    }

    public boolean isSameAs(Item otherItem) {
        return this.sku == otherItem.sku
               && this.name.equals(otherItem.name)
                && this.price == otherItem.price;
    }
}
