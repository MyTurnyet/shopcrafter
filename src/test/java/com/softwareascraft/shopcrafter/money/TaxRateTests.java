package com.softwareascraft.shopcrafter.money;

import com.softwareascraft.shopcrafter.goods.ItemCategory;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@Tag("Unit")
class TaxRateTests {
    ItemCategory goodsCategory = new ItemCategory("Goods");

    @Test
    void shouldApplyToGoodsCategory() {
        TaxRate taxRate = new TaxRate(10, List.of(goodsCategory));
        boolean applies = taxRate.appliesTo(goodsCategory);
        assertThat(applies).isTrue();
    }
}
