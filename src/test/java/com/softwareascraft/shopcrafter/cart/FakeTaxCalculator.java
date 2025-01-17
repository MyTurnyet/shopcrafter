package com.softwareascraft.shopcrafter.cart;

import com.softwareascraft.shopcrafter.goods.ItemCategory;
import com.softwareascraft.shopcrafter.money.TaxCalculator;

import java.util.List;

public class FakeTaxCalculator implements TaxCalculator {
    @Override
    public int calculate(int cost, List<ItemCategory> categories) {
        return 0;
    }
}
