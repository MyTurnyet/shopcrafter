package com.softwareascraft.shopcrafter.money;

public class TaxCalculator {

    private final int taxRate;

    public TaxCalculator(int taxRate) {
        this.taxRate = taxRate;
    }

    public int total(int cost) {
        double percentage = (double) taxRate / 100;
        float tenPercentTax = (float) (cost * percentage);
        return 5 * (Math.round(tenPercentTax / 5));
    }
}
