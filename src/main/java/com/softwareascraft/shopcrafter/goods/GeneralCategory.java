package com.softwareascraft.shopcrafter.goods;

import java.util.Objects;

public class GeneralCategory implements ItemCategory {

    private final String name;

    public GeneralCategory(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(ItemCategory other) {
        if (!(other instanceof GeneralCategory that)) return false;
        return name.equals(that.name());
    }

    @Override
    public String name() {
        return this.name;
    }
}
