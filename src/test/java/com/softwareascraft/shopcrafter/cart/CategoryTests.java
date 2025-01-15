package com.softwareascraft.shopcrafter.cart;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@Tag("Unit")
class CategoryTests {
    @Test
    void matchIfNameIsSame() {
        ItemCategory category1 = new ItemCategory("Game");
        ItemCategory category2 = new ItemCategory("Game");
        assertThat(category1).isEqualTo(category2);
    }
    @Test
    void doNotMatchItNameIsDifferent() {
        ItemCategory category1 = new ItemCategory("Game");
        ItemCategory category2 = new ItemCategory("Food");
        assertThat(category1).isNotEqualTo(category2);
    }
}
