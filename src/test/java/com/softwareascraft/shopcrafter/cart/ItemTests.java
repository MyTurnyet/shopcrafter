package com.softwareascraft.shopcrafter.cart;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@Tag("Unit")
class ItemTests {
        ItemCategory goodsCategory = new ItemCategory("Goods");

    @Test
    void itemMatchesSkuAndName() {
        Item item1 = new Item(1234, "Item Name", 0, goodsCategory);
        Item item2 = new Item(1234, "Item Name", 0, goodsCategory);
        assertThat(item1).isEqualTo(item2);
    }
    @Test
    void doesNotMatchWithDifferentPrice() {
        Item item1 = new Item(1234, "Item Name", 123,goodsCategory );
        Item item2 = new Item(1234, "Item Name",10, goodsCategory);
        assertThat(item1).isNotEqualTo(item2);
    }

    @Test
    void doesNotMatchWithDifferentSKU() {
        Item item1 = new Item(1234, "Item Name", 0, goodsCategory);
        Item item2 = new Item(2345, "Item Name", 0, goodsCategory);
        assertThat(item1).isNotEqualTo(item2);
    }

    @Test
    void doesNotMatchWithDifferentNames() {
        Item item1 = new Item(1234, "Item Name", 0,goodsCategory );
        Item item2 = new Item(1234, "Other Name", 0,goodsCategory );
        assertThat(item1).isNotEqualTo(item2);
    }

    @Test
    void hasCategory() {
        Item item1 = new Item(1234, "Item Name", 0,goodsCategory );
        boolean hasCategory = item1.isInCategory(goodsCategory);
        assertThat(hasCategory).isTrue();
    }

}
