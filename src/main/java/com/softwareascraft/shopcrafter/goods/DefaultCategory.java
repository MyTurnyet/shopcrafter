package com.softwareascraft.shopcrafter.goods;

public record DefaultCategory(String name) implements ItemCategory {

    @Override
    public boolean equals(ItemCategory other) {
        return true;
    }
}
