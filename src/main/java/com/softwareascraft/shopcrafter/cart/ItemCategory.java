package com.softwareascraft.shopcrafter.cart;

public class ItemCategory implements Equatable<ItemCategory> {
    private final String name;

    public ItemCategory(String name) {
        this.name = name;
    }

    @Override
    public boolean isSameAs(ItemCategory other) {
        return this.name.equals(other.name);
    }
}
