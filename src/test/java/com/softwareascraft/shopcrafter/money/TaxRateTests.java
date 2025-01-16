package com.softwareascraft.shopcrafter.money;

import com.softwareascraft.shopcrafter.goods.ItemCategory;
import com.softwareascraft.shopcrafter.goods.GeneralCategory;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.util.Collections;
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
    @Test
    void applyToAllIfListIsEmpty() {
        TaxRate taxRate = new TaxRate(10, Collections.emptyList());
        boolean applies = taxRate.appliesTo(foodCategory);
        assertThat(applies).isTrue();
    }

    @Test
    void returnsTenPercentTax() {
        TaxRate taxRate = new TaxRate(10, Collections.emptyList());
        int amount = taxRate.amount(100);
        assertThat(amount).isEqualTo(10);
    }
    @Test
    void returns12_5PercentageTax() {
        TaxRate taxRate = new TaxRate(12.5, Collections.emptyList());
        int amount = taxRate.amount(100);
        assertThat(amount).isEqualTo(13);
    }
    @Test
    void returns12_5PercentageTaxOf300() {
        TaxRate taxRate = new TaxRate(12.2, Collections.emptyList());
        int amount = taxRate.amount(300);
        assertThat(amount).isEqualTo(37);
    }
}
