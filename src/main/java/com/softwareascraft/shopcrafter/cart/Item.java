package com.softwareascraft.shopcrafter.cart;

import java.util.Objects;

public class Item {
    private final int sku;
    private final String name;
    private final int price;

    public Item(int sku, String name, int price, ItemCategory category) {
        this.sku = sku;
        this.name = name;
        this.price = price;
    }
    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Item item)) return false;
        return sku == item.sku && price == item.price && Objects.equals(name, item.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sku, name, price);
    }

    public boolean isInCategory(ItemCategory expectedCategory) {
        return true;
    }
}
