package com.softwareascraft.shopcrafter.cart;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@Tag("Unit")
class CategoryTests {
    @Test
    void categoriesMatch() {
        ItemCategory category1 = new ItemCategory("Game");
        ItemCategory category2 = new ItemCategory("Game");
        boolean sameAs = category1.isSameAs(category2);
        assertThat(sameAs).isTrue();
    }
}
