package com.softwareascraft.shopcrafter.money;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@Tag("Unit")
class TaxCalculatorTests {

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
    void roundsTaxmoreThan3UpTo5() {
        TaxCalculator taxCalculator = new TaxCalculator(10);
        int totalAmount =taxCalculator.total(25);
        assertThat(totalAmount).isEqualTo(5);
    }
}
