package com.softwareascraft.shopcrafter.goods;

import java.util.Objects;

public class DefaultCategory implements ItemCategory {
    private final String name;

    public DefaultCategory(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(ItemCategory other) {
        return true;
    }

    @Override
    public String name() {
        return name;
    }
}
