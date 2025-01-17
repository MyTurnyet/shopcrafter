package com.softwareascraft.shopcrafter.money;

import com.softwareascraft.shopcrafter.goods.ItemCategory;

import java.util.List;

public interface TaxCalculator {
    int calculate(int cost, List<ItemCategory> categories);
}
