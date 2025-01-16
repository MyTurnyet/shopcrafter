package com.softwareascraft.shopcrafter.money;

import com.softwareascraft.shopcrafter.goods.Item;
import com.softwareascraft.shopcrafter.goods.ItemCategory;
import com.softwareascraft.shopcrafter.goods.GeneralCategory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.awt.event.ItemEvent;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@Tag("Unit")
class TaxCalculatorTests {

    private Item bananaItem;
    ArrayList<TaxRate> taxRateList = new ArrayList<>();

    @BeforeEach
    void setup() {
        int bananaPrice = 100;
        ItemCategory foodCategory = new GeneralCategory("Food");
        bananaItem = new Item(123, "Banana", bananaPrice, foodCategory, false);
        taxRateList.add(TaxRate.DefaultTax);
    }

    @Test
    void returns10PercentOf100() {
        TaxCalculator taxCalculator = new TaxCalculator(taxRateList);
        int totalAmount = taxCalculator.total(100);
        assertThat(totalAmount).isEqualTo(10);
    }

    @Test
    void returns5PercentOf50() {
        TaxCalculator taxCalculator = new TaxCalculator(taxRateList);
        int totalAmount = taxCalculator.total(50);
        assertThat(totalAmount).isEqualTo(5);
    }

    @Test
    void roundsTaxLessThan3DownTo0() {
        TaxCalculator taxCalculator = new TaxCalculator(taxRateList);
        int totalAmount = taxCalculator.total(24);
        assertThat(totalAmount).isEqualTo(0);
    }

    @Test
    void roundsTaxMoreThan3UpTo5() {
        TaxCalculator taxCalculator = new TaxCalculator(taxRateList);
        int totalAmount = taxCalculator.total(25);
        assertThat(totalAmount).isEqualTo(5);
    }

    @Test
    void calculatorAppliesMultipleTaxRates() {
        TaxRate fouteenPointTwo = new TaxRate(14.2);
        TaxRate twoPoint5 = new TaxRate(2.5);
        List<TaxRate> rateList = List.of(fouteenPointTwo, twoPoint5);
        TaxCalculator taxCalculator = new TaxCalculator(rateList);
        int totalAmount = taxCalculator.total(3200);
        assertThat(totalAmount).isEqualTo(535);
    }

}
