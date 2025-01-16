package com.softwareascraft.shopcrafter.goods;

public interface ItemCategory {
    public static ItemCategory EVERYTHING = new GeneralCategory("EVERYTHING");
    public static ItemCategory FOOD = new GeneralCategory("Food");
    public static ItemCategory GAMES = new GeneralCategory("Games");
    @Override
    boolean equals(Object o);

    @Override
    int hashCode();
}
