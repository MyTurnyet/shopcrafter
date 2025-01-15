package com.softwareascraft.shopcrafter.goods;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@Tag("Unit")
class ItemTests {
        ItemCategory goodsCategory = new ItemCategory("Goods");

    @Test
    void itemMatchesSkuAndName() {
        Item item = new Item(1234, "Item Name", 0, goodsCategory, false);
        Item other = new Item(1234, "Item Name", 0, goodsCategory, false);
        assertThat(item).isEqualTo(other);
    }
    @Test
    void doesNotMatchWithDifferentPrice() {
        Item item = new Item(1234, "Item Name", 123,goodsCategory, false);
        Item other = new Item(1234, "Item Name",10, goodsCategory, false);
        assertThat(item).isNotEqualTo(other);
    }

    @Test
    void doesNotMatchWithDifferentSKU() {
        Item item = new Item(1234, "Item Name", 0, goodsCategory, false);
        Item other = new Item(2345, "Item Name", 0, goodsCategory, false);
        assertThat(item).isNotEqualTo(other);
    }

    @Test
    void doesNotMatchWithDifferentNames() {
        Item item = new Item(1234, "Item Name", 0,goodsCategory, false);
        Item other = new Item(1234, "Other Name", 0,goodsCategory, false);
        assertThat(item).isNotEqualTo(other);
    }

    @Test
    void hasCategory() {
        Item item = new Item(1234, "Item Name", 0,goodsCategory, false);
        boolean hasCategory = item.isInCategory(goodsCategory);
        assertThat(hasCategory).isTrue();
    }
    @Test
    void doesNotHaveCategory() {
        Item item = new Item(1234, "Item Name", 0,goodsCategory, false);
        ItemCategory food = new ItemCategory("Food");
        boolean hasCategory = item.isInCategory(food);
        assertThat(hasCategory).isFalse();
    }

    @Test
    void isNotImported() {
        Item item = new Item(1234, "Item1", 0, goodsCategory, false);
        boolean isImported = item.isImported();
        assertThat(isImported).isFalse();
    }
    @Test
    void isImported() {
        Item item = new Item(1234, "Item1", 0, goodsCategory, true);
        boolean isImported = item.isImported();
        assertThat(isImported).isTrue();
    }
}
