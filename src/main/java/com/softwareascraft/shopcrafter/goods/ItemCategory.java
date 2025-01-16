package com.softwareascraft.shopcrafter.goods;

public interface ItemCategory {
    public ItemCategory Food = new GeneralCategory("Food");
    public ItemCategory Beauty = new GeneralCategory("Beauty");
    boolean equals(ItemCategory other);
    String name();


}
