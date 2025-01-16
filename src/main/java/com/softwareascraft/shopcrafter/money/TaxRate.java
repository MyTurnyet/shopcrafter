package com.softwareascraft.shopcrafter.money;

import com.softwareascraft.shopcrafter.goods.ItemCategory;

public class TaxRate {
    public TaxRate(int rate) {

    }

    public boolean appliesTo(ItemCategory itemCategory) {
        return true;
    }
}
