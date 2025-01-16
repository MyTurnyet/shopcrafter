package com.softwareascraft.shopcrafter.goods;

public record GeneralCategory(String name) implements ItemCategory {

    @Override
    public boolean equals(ItemCategory other) {
        if (!(other instanceof GeneralCategory that)) return false;
        return name.equals(that.name());
    }
}
