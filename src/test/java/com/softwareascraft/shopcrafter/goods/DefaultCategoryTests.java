package com.softwareascraft.shopcrafter.goods;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@Tag("Unit")
class DefaultCategoryTests {
    @Test
    void matchesAnyOtherCategory() {
        ItemCategory category1 = new DefaultCategory("Default");
        ItemCategory category2 = new GeneralCategory("Default");
        boolean equals = category1.equals(category2);
        assertThat(equals).isTrue();
    }
}
