package com.softwareascraft.shopcrafter.goods;

public interface ItemCategory {
    public ItemCategory Default = new DefaultCategory("EveryThing");
    public ItemCategory Imported = new GeneralCategory("Imported");
    public ItemCategory Food = new GeneralCategory("Food");
    public ItemCategory Beauty = new GeneralCategory("Beauty");

    boolean equals(ItemCategory other);

    String name();


}
