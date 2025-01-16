package com.softwareascraft.shopcrafter.money;

import com.softwareascraft.shopcrafter.goods.Item;
import com.softwareascraft.shopcrafter.goods.ItemCategory;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class TaxCalculator {

    private final List<TaxRate> taxRateList;

    public TaxCalculator(List<TaxRate> appliedTaxes) {
        this.taxRateList = appliedTaxes;
    }

    public int total(int cost, List<ItemCategory> categories) {
        if (categories.isEmpty()) {
            return calculateTotalForAppliedRates(cost, this.taxRateList);
        }
        List<TaxRate> taxRatesToApply = getRatesToApply(categories);
        return calculateTotalForAppliedRates(cost, taxRatesToApply);
    }

    private List<TaxRate> getRatesToApply(List<ItemCategory> categories) {
        List<TaxRate> taxRatesToApply = categories.stream()
                .flatMap(category -> taxRateList.stream()
                        .filter(taxRate -> taxRate.appliesTo(category)))
                .collect(Collectors.toList());
        return taxRatesToApply;
    }

    private int calculateTotalForAppliedRates(int cost, List<TaxRate> taxRatesToApply) {
        double sum = taxRatesToApply.stream().mapToInt(rate -> rate.amount(cost)).sum();
        return (int) (5 * (Math.round(sum / 5)));
    }

    public int total(int cost) {
        return total(cost, Collections.emptyList());
    }

    public int calculateFor(Item item) {
        return 0;
    }
}
