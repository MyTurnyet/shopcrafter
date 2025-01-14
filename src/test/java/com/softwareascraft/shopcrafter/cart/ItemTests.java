package com.softwareascraft.shopcrafter.cart;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@Tag("Unit")
class ItemTests {
    @Test
    void itemMatchesNameAndSku() {
        Item item1 = new Item(1234, "Item Name");
        Item item2 = new Item(1234, "Item Name");
        boolean matches = item1.isSameAs(item2);
        assertThat(matches).isTrue();
    }

}
