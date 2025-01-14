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
        boolean sameAs = category1.isSameAs(category2);
        assertThat(sameAs).isTrue();
    }
    @Test
    void doNotMatchItNameIsDifferent() {
        ItemCategory category1 = new ItemCategory("Game");
        ItemCategory category2 = new ItemCategory("Food");
        boolean sameAs = category1.isSameAs(category2);
        assertThat(sameAs).isFalse();
    }
}
