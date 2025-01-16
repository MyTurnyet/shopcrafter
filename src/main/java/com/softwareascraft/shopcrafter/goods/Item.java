package com.softwareascraft.shopcrafter.goods;

import com.softwareascraft.shopcrafter.money.TaxCalculator;

import java.util.List;
import java.util.Objects;

public class Item {
    private final int sku;
    private final String name;
    private final int price;
    private List<ItemCategory> categories;
    private final boolean isImported;

    public Item(int sku, String name, int price, ItemCategory category, boolean isImported) {
        this(sku, name, price, List.of(category), isImported);

    }

    public Item(int sku, String name, int price, List<ItemCategory> categories, boolean isImported) {
        this.sku = sku;
        this.name = name;
        this.price = price;
        this.categories = categories;
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
        return this.categories.stream().anyMatch(expectedCategory::equals);
    }

    public boolean isImported() {
        return this.isImported;
    }

    public int calculateAllTaxes(TaxCalculator taxCalculator) {

        return taxCalculator.total(this.price, this.categories);
    }
}
