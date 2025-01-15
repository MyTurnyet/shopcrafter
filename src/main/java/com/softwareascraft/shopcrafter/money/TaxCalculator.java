package com.softwareascraft.shopcrafter.money;

public class TaxCalculator {
    private final int cost;

    public TaxCalculator(int cost) {
        this.cost = cost;
    }

    public int total() {
        double tenPercentTax = cost * 0.1;
        long roundedTaxAmount = Math.round(tenPercentTax / 10) * 5;
        return (int) roundedTaxAmount;
    }
}
