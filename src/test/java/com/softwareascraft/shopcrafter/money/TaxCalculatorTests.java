package com.softwareascraft.shopcrafter.money;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@Tag("Unit")
class TaxCalculatorTests {

    @Test
    void returnsZeroByDefault() {
        TaxCalculator taxCalculator = new TaxCalculator(10);
        int totalAmount =taxCalculator.total();
        assertThat(totalAmount).isZero();
    }
}
