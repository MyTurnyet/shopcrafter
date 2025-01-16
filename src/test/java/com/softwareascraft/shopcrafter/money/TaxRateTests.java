package com.softwareascraft.shopcrafter.money;

import com.softwareascraft.shopcrafter.goods.ItemCategory;
import com.softwareascraft.shopcrafter.goods.GeneralCategory;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@Tag("Unit")
class TaxRateTests {
    ItemCategory goodsCategory = new GeneralCategory("Goods");
    ItemCategory foodCategory = new GeneralCategory("Food");

    @Test
    void shouldApplyToGoodsCategory() {
        TaxRate taxRate = new TaxRate(10, List.of(goodsCategory));
        boolean applies = taxRate.appliesTo(goodsCategory);
        assertThat(applies).isTrue();
    }
    @Test
    void shouldNotApplyToFoodCategory() {
        TaxRate taxRate = new TaxRate(10, List.of(goodsCategory));
        boolean applies = taxRate.appliesTo(foodCategory);
        assertThat(applies).isFalse();
    }
}
