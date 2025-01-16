package com.softwareascraft.shopcrafter.goods;

import com.softwareascraft.shopcrafter.money.TaxCalculator;

import java.util.List;
import java.util.Objects;

public class Item {
    private final int sku;
    private final String name;
    private final int price;
    private final List<ItemCategory> categories;

    public Item(int sku, String name, int price, ItemCategory category) {
        this(sku, name, price, List.of(category));

    }

    public Item(int sku, String name, int price, List<ItemCategory> categories) {
        this.sku = sku;
        this.name = name;
        this.price = price;
        this.categories = categories;

    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Item item)) return false;
        return sku == item.sku
               && price == item.price
               && Objects.equals(name, item.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sku, name, price);
    }

    public boolean isInCategory(ItemCategory expectedCategory) {
        return this.categories.stream().anyMatch(expectedCategory::equals);
    }

    public boolean isImported() {
        return isInCategory(ItemCategory.Imported);
    }

    public int calculateAllTaxes(TaxCalculator taxCalculator) {
        return taxCalculator.total(this.price, this.categories);
    }
}
