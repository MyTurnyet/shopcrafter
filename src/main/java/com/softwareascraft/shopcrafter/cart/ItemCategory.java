package com.softwareascraft.shopcrafter.cart;

import java.util.Objects;

public class ItemCategory {
    private final String name;

    public ItemCategory(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof ItemCategory that)) return false;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }
}
