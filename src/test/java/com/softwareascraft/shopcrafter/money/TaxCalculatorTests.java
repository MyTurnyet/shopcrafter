package com.softwareascraft.shopcrafter.money;

import com.softwareascraft.shopcrafter.goods.ItemCategory;
import com.softwareascraft.shopcrafter.goods.GeneralCategory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@Tag("Unit")
class TaxCalculatorTests {

    ArrayList<TaxRate> taxRateList = new ArrayList<>();
    private TaxCalculator taxCalculator;
    private List<ItemCategory> categoryList;

    @BeforeEach
    void setup() {
        int bananaPrice = 100;
        ItemCategory foodCategory = new GeneralCategory("Food");
        taxRateList.add(TaxRate.DefaultTax);
        taxCalculator = new TaxCalculationService(taxRateList);
        categoryList = List.of(ItemCategory.Default);
    }

    @Test
    void returns10PercentOf100() {
        int totalAmount = taxCalculator.calculate(100, categoryList);
        assertThat(totalAmount).isEqualTo(10);
    }

    @Test
    void returns5PercentOf50() {
        int totalAmount = taxCalculator.calculate(50, categoryList);
        assertThat(totalAmount).isEqualTo(5);
    }

    @Test
    void roundsTaxLessThan3DownTo0() {
        int totalAmount = taxCalculator.calculate(24, categoryList);
        assertThat(totalAmount).isEqualTo(0);
    }

    @Test
    void roundsTaxMoreThan3UpTo5() {
        int totalAmount = taxCalculator.calculate(25, categoryList);
        assertThat(totalAmount).isEqualTo(5);
    }

    @Test
    void calculatorAppliesMultipleTaxRates() {
        TaxRate fouteenPointTwo = new TaxRate(14.2);
        TaxRate twoPoint5 = new TaxRate(2.5);
        List<TaxRate> rateList = List.of(fouteenPointTwo, twoPoint5);
        TaxCalculator taxCalculator = new TaxCalculationService(rateList);
        int totalAmount = taxCalculator.calculate(3200, categoryList);
        assertThat(totalAmount).isEqualTo(535);
    }

    @Test
    void appliesOnlyTaxesForCategories() {
        TaxRate fouteenPointTwo = new TaxRate(14.2, List.of(ItemCategory.Beauty));
        TaxRate twoPoint5 = new TaxRate(2.5, List.of(ItemCategory.Food));
        TaxCalculator taxCalculator = new TaxCalculationService(List.of(fouteenPointTwo, twoPoint5));
        int total = taxCalculator.calculate(3200, List.of(ItemCategory.Beauty));
        assertThat(total).isEqualTo(455);
    }
}
