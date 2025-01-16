package com.softwareascraft.shopcrafter.money;

import com.softwareascraft.shopcrafter.goods.ItemCategory;

import java.util.Collections;
import java.util.List;

public class TaxRate {
    public static TaxRate DefaultTax = new TaxRate(10);
    private final double rate;
    private final List<ItemCategory> appliedCategories;

    public TaxRate(double rate) {
        this(rate, Collections.emptyList());
    }

    public TaxRate(double rate, List<ItemCategory> appliedCategories) {
        this.rate = rate;
        this.appliedCategories = appliedCategories;
    }

    public boolean appliesTo(ItemCategory itemCategory) {
        if (this.appliedCategories.isEmpty()) return true;
        return appliedCategories.stream().anyMatch(itemCategory::equals);
    }

    public int amount(int cost) {
        double percentage = rate / 100;
        float taxAmount = (float) (cost * percentage);
        return Math.round(taxAmount);
    }
}
