package com.softwareascraft.shopcrafter.cart;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@Tag("Unit")
class ItemTests {
    @Test
    void itemMatchesSkuAndName() {
        Item item1 = new Item(1234, "Item Name", 0);
        Item item2 = new Item(1234, "Item Name", 0);
        assertThat(item1).isEqualTo(item2);
    }
    @Test
    void doesNotMatchWithDifferentPrice() {
        Item item1 = new Item(1234, "Item Name", 123);
        Item item2 = new Item(1234, "Item Name",10);
        assertThat(item1).isNotEqualTo(item2);
    }

    @Test
    void doesNotMatchWithDifferentSKU() {
        Item item1 = new Item(1234, "Item Name", 0);
        Item item2 = new Item(2345, "Item Name", 0);
        assertThat(item1).isNotEqualTo(item2);
    }

    @Test
    void doesNotMatchWithDifferentNames() {
        Item item1 = new Item(1234, "Item Name", 0);
        Item item2 = new Item(1234, "Other Name", 0);
        assertThat(item1).isNotEqualTo(item2);
    }

}
