package com.softwareascraft.shopcrafter.goods;

import com.softwareascraft.shopcrafter.money.TaxCalculator;

import java.util.List;
import java.util.Objects;

public class Item {
    private final int sku;
    private final String name;
    private final int price;
    private final ItemCategory category;
    private final boolean isImported;

    public Item(int sku, String name, int price, ItemCategory category, boolean isImported) {
        this.sku = sku;
        this.name = name;
        this.price = price;
        this.category = category;
        this.isImported = isImported;

    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Item item)) return false;
        return sku == item.sku
               && price == item.price
               && Objects.equals(name, item.name)
                && isImported == item.isImported;
    }

    @Override
    public int hashCode() {
        return Objects.hash(sku, name, price, isImported);
    }

    public boolean isInCategory(ItemCategory expectedCategory) {
        return this.category.equals(expectedCategory);
    }

    public boolean isImported() {
        return this.isImported;
    }

    public int calculateAllTaxes(TaxCalculator taxCalculator) {

        return taxCalculator.total(this.price, List.of(this.category));
    }
}
