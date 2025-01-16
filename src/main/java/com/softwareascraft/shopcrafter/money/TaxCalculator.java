package com.softwareascraft.shopcrafter.money;

import java.util.List;

public class TaxCalculator {

    private final int taxRate = 0;
    private final List<TaxRate> appliedTaxes;

    public TaxCalculator(List<TaxRate> appliedTaxes) {
        this.appliedTaxes = appliedTaxes;
    }

    public int total(int cost) {
        double sum = this.appliedTaxes.stream().mapToInt(rate -> rate.amount(cost)).sum();
        return (int) (5 * (Math.round(sum / 5)));
    }
}
