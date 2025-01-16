package com.softwareascraft.shopcrafter.goods;

import com.softwareascraft.shopcrafter.money.TaxCalculator;
import com.softwareascraft.shopcrafter.money.TaxRate;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;


import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@Tag("Unit")
class ItemTests {

    @Test
    void itemMatches() {
        Item item = new Item(1234, "Item Name", 0, ItemCategory.Beauty, false);
        Item other = new Item(1234, "Item Name", 0, ItemCategory.Beauty, false);
        assertThat(item).isEqualTo(other);
    }

    @Test
    void doesNotMatchWithDifferentPrice() {
        Item item = new Item(1234, "Item Name", 123, ItemCategory.Beauty, false);
        Item other = new Item(1234, "Item Name", 10, ItemCategory.Beauty, false);
        assertThat(item).isNotEqualTo(other);
    }

    @Test
    void doesNotMatchWithDifferentSKU() {
        Item item = new Item(1234, "Item Name", 0, ItemCategory.Beauty, false);
        Item other = new Item(2345, "Item Name", 0, ItemCategory.Beauty, false);
        assertThat(item).isNotEqualTo(other);
    }

    @Test
    void doesNotMatchWithDifferentNames() {
        Item item = new Item(1234, "Item Name", 0, ItemCategory.Beauty, false);
        Item other = new Item(1234, "Other Name", 0, ItemCategory.Beauty, false);
        assertThat(item).isNotEqualTo(other);
    }

    @Test
    void hasCategory() {
        Item item = new Item(1234, "Item Name", 0, ItemCategory.Beauty, false);
        boolean hasCategory = item.isInCategory(ItemCategory.Beauty);
        assertThat(hasCategory).isTrue();
    }

    @Test
    void doesNotHaveCategory() {
        Item item = new Item(1234, "Item Name", 0, ItemCategory.Beauty, false);
        ItemCategory food = new GeneralCategory("Food");
        boolean hasCategory = item.isInCategory(food);
        assertThat(hasCategory).isFalse();
    }

    @Test
    void isNotImported() {
        Item item = new Item(1234, "Item1", 0, ItemCategory.Beauty, false);
        boolean isImported = item.isImported();
        assertThat(isImported).isFalse();
    }

    @Test
    void isImported() {
        Item item = new Item(1234, "Item1", 0, ItemCategory.Beauty, true);
        boolean isImported = item.isImported();
        assertThat(isImported).isTrue();
    }


    @Test
    void returnsTotalTaxof28Percent_2Taxes() {
        Item item = new Item(1234, "Item1", 100, ItemCategory.Beauty, true);
        TaxRate eightPercent = new TaxRate(8);
        TaxRate twentyPercent = new TaxRate(20);
        TaxCalculator taxCalculator = new TaxCalculator(List.of(eightPercent, twentyPercent));
        int taxes = item.calculateAllTaxes(taxCalculator);
        assertThat(taxes).isEqualTo(30);
    }

    @Test
    void returnsTotalTaxof24_8Percent_2Taxes() {
        Item item = new Item(1234, "Item1", 100, ItemCategory.Beauty, true);
        TaxRate eightPercent = new TaxRate(10.8);
        TaxRate twentyPercent = new TaxRate(14);
        TaxCalculator taxCalculator = new TaxCalculator(List.of(eightPercent, twentyPercent));
        int taxes = item.calculateAllTaxes(taxCalculator);
        assertThat(taxes).isEqualTo(25);
    }

    @Test
    void returnsTotalTaxof15Percent_1Taxes() {
        Item item = new Item(1234, "Item1", 100, ItemCategory.Beauty, true);
        TaxRate fifteenPercent = new TaxRate(15);
        TaxCalculator taxCalculator = new TaxCalculator(List.of(fifteenPercent));
        int taxes = item.calculateAllTaxes(taxCalculator);
        assertThat(taxes).isEqualTo(15);
    }
    @Test
    void returnsTotalTaxof18_6Percent_1Taxes() {
        Item item = new Item(1234, "Item1", 100, ItemCategory.Beauty, true);
        TaxRate fifteenPercent = new TaxRate(18.6);
        TaxCalculator taxCalculator = new TaxCalculator(List.of(fifteenPercent));
        int taxes = item.calculateAllTaxes(taxCalculator);
        assertThat(taxes).isEqualTo(20);
    }
}
