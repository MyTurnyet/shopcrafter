package com.softwareascraft.shopcrafter.money;

import com.softwareascraft.shopcrafter.goods.ItemCategory;

import java.util.List;

public class TaxRate {
    public TaxRate(int rate) {

    }

    public TaxRate(int rate, List<ItemCategory> appliedCategories) {

    }

    public boolean appliesTo(ItemCategory itemCategory) {
        return true;
    }
}
