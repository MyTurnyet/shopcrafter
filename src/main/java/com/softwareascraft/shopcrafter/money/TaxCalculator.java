package com.softwareascraft.shopcrafter.money;

public class TaxCalculator {
    private final int cost;

    public TaxCalculator(int cost) {
        this.cost = cost;
    }

    public int total() {
        return (int) (cost * 0.1);
    }
}
