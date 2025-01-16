package com.softwareascraft.shopcrafter.money;

import com.softwareascraft.shopcrafter.goods.ItemCategory;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@Tag("Unit")
class TaxRateTests {
    @Test
    void shouldApplyToAll() {
        TaxRate taxRate = new TaxRate(10);
        ItemCategory goodsCategory = new ItemCategory("Goods");
        boolean applies = taxRate.appliesTo(goodsCategory);
        assertThat(applies).isTrue();
    }
}
