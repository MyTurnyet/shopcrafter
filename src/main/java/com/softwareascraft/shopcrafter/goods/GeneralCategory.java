package com.softwareascraft.shopcrafter.goods;

import java.util.Objects;

public class GeneralCategory implements ItemCategory {

    private final String name;

    public GeneralCategory(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof GeneralCategory that)) return false;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }
}
