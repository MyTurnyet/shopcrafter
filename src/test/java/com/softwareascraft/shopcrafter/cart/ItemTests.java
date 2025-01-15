package com.softwareascraft.shopcrafter.cart;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@Tag("Unit")
class ItemTests {
        ItemCategory goodsCategory = new ItemCategory("Goods");

    @Test
    void itemMatchesSkuAndName() {
        Item item = new Item(1234, "Item Name", 0, goodsCategory);
        Item other = new Item(1234, "Item Name", 0, goodsCategory);
        assertThat(item).isEqualTo(other);
    }
    @Test
    void doesNotMatchWithDifferentPrice() {
        Item item = new Item(1234, "Item Name", 123,goodsCategory );
        Item other = new Item(1234, "Item Name",10, goodsCategory);
        assertThat(item).isNotEqualTo(other);
    }

    @Test
    void doesNotMatchWithDifferentSKU() {
        Item item = new Item(1234, "Item Name", 0, goodsCategory);
        Item other = new Item(2345, "Item Name", 0, goodsCategory);
        assertThat(item).isNotEqualTo(other);
    }

    @Test
    void doesNotMatchWithDifferentNames() {
        Item item = new Item(1234, "Item Name", 0,goodsCategory );
        Item other = new Item(1234, "Other Name", 0,goodsCategory );
        assertThat(item).isNotEqualTo(other);
    }

    @Test
    void hasCategory() {
        Item item = new Item(1234, "Item Name", 0,goodsCategory );
        boolean hasCategory = item.isInCategory(goodsCategory);
        assertThat(hasCategory).isTrue();
    }
    @Test
    void doesNotHaveCategory() {
        Item item = new Item(1234, "Item Name", 0,goodsCategory );
        ItemCategory food = new ItemCategory("Food");
        boolean hasCategory = item.isInCategory(food);
        assertThat(hasCategory).isFalse();
    }

    @Test
    void isNotImported() {
        Item item = new Item(1234, "Item1", 0, goodsCategory);
        boolean isImported = item.isImported();
        assertThat(isImported).isFalse();
    }
}
