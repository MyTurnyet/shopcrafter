package com.softwareascraft.shopcrafter.money;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@Tag("Unit")
class TaxCalculatorTests {

    @Test
    void returnsZeroByDefault() {
        TaxCalculator taxCalculator = new TaxCalculator(0);
        int totalAmount =taxCalculator.total();
        assertThat(totalAmount).isZero();
    }
    @Test
    void returns10PercentOf100() {
        TaxCalculator taxCalculator = new TaxCalculator(100);
        int totalAmount =taxCalculator.total();
        assertThat(totalAmount).isEqualTo(10);
    }
    @Test
    void returns5PercentOf50() {
        TaxCalculator taxCalculator = new TaxCalculator(50);
        int totalAmount =taxCalculator.total();
        assertThat(totalAmount).isEqualTo(5);
    }
    @Test
    void roundsTaxLessThan5DownTo0() {
        TaxCalculator taxCalculator = new TaxCalculator(20);
        int totalAmount =taxCalculator.total();
        assertThat(totalAmount).isEqualTo(0);
    }
}
