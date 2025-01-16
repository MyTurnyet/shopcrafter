package com.softwareascraft.shopcrafter.money;

import com.softwareascraft.shopcrafter.goods.Item;
import com.softwareascraft.shopcrafter.goods.ItemCategory;
import com.softwareascraft.shopcrafter.goods.GeneralCategory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@Tag("Unit")
class TaxCalculatorTests {

    private Item  bananaItem;

    @BeforeEach
    void setup(){
        int bananaPrice = 100;
        ItemCategory foodCategory = new GeneralCategory("Food");
        bananaItem = new Item(123, "Banana", bananaPrice, foodCategory, false);

    }
    @Test
    void returnsZeroByDefault() {
        TaxCalculator taxCalculator = new TaxCalculator(0);
        int totalAmount =taxCalculator.total(1);
        assertThat(totalAmount).isZero();
    }
    @Test
    void returns10PercentOf100() {
        TaxCalculator taxCalculator = new TaxCalculator(10);
        int totalAmount =taxCalculator.total(100);
        assertThat(totalAmount).isEqualTo(10);
    }
    @Test
    void returns5PercentOf50() {
        TaxCalculator taxCalculator = new TaxCalculator(10);
        int totalAmount =taxCalculator.total(50);
        assertThat(totalAmount).isEqualTo(5);
    }
    @Test
    void roundsTaxLessThan3DownTo0() {
        TaxCalculator taxCalculator = new TaxCalculator(10);
        int totalAmount =taxCalculator.total(24);
        assertThat(totalAmount).isEqualTo(0);
    }
    @Test
    void roundsTaxMoreThan3UpTo5() {
        TaxCalculator taxCalculator = new TaxCalculator(10);
        int totalAmount =taxCalculator.total(25);
        assertThat(totalAmount).isEqualTo(5);
    }

}
