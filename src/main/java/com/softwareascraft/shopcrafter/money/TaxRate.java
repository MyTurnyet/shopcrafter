package com.softwareascraft.shopcrafter.money;

import com.softwareascraft.shopcrafter.goods.ItemCategory;

import java.util.List;

public class TaxRate {
    private final List<ItemCategory> appliedCategories;

    public TaxRate(int rate, List<ItemCategory> appliedCategories) {
        this.appliedCategories = appliedCategories;
    }

    public boolean appliesTo(ItemCategory itemCategory) {
        return appliedCategories.stream().anyMatch(category -> itemCategory.equals(category));
    }
}
