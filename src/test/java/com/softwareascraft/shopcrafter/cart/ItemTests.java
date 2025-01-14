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
        boolean matches = item1.isSameAs(item2);
        assertThat(matches).isTrue();
    }
    @Test
    void doesNotMatchWithDifferentPrice() {
        Item item1 = new Item(1234, "Item Name", 123);
        Item item2 = new Item(1234, "Item Name",10);
        boolean matches = item1.isSameAs(item2);
        assertThat(matches).isFalse();
    }

    @Test
    void doesNotMatchWithDifferentSKU() {
        Item item1 = new Item(1234, "Item Name", 0);
        Item item2 = new Item(2345, "Item Name", 0);
        boolean matches = item1.isSameAs(item2);
        assertThat(matches).isFalse();
    }

    @Test
    void doesNotMatchWithDifferentNames() {
        Item item1 = new Item(1234, "Item Name", 0);
        Item item2 = new Item(1234, "Other Name", 0);
        boolean matches = item1.isSameAs(item2);
        assertThat(matches).isFalse();
    }

}
