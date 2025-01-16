package com.softwareascraft.shopcrafter.goods;

import com.softwareascraft.shopcrafter.money.TaxCalculator;
import com.softwareascraft.shopcrafter.money.TaxRate;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;


import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@Tag("Unit")
class ItemTests {

    private List<ItemCategory> oneCategory = List.of(ItemCategory.Beauty);


    private Item createImportedItem(int sku, String itemName, int price) {

        return createItem(sku, itemName, price, true);
    }

    private Item createItem(int sku, String itemName, int price) {

        return createItem(sku, itemName, price, false);
    }

    private Item createItem(int sku, String itemName, int price, boolean isImported) {
        Item item = new ItemBuilder().addCategories(oneCategory).isImported(isImported).create(sku, itemName, price);
        return item;
    }

    @Test
    void itemMatches() {
        Item item = createItem(1234, "Item Name", 0);
        Item other = createItem(1234, "Item Name", 0);
        assertThat(item).isEqualTo(other);
    }

    @Test
    void doesNotMatchWithDifferentPrice() {
        Item item = createItem(1234, "Item Name", 123);
        Item other = createItem(1234, "Item Name", 10);
        assertThat(item).isNotEqualTo(other);
    }

    @Test
    void doesNotMatchWithDifferentSKU() {
        Item item = createItem(1234, "Item Name", 0);
        Item other = createItem(2345, "Item Name", 0);
        assertThat(item).isNotEqualTo(other);
    }

    @Test
    void doesNotMatchWithDifferentNames() {
        Item item = createItem(1234, "Item Name", 0);
        Item other = createItem(1234, "Other Name", 0);
        assertThat(item).isNotEqualTo(other);
    }

    @Test
    void hasCategory() {
        Item item = createItem(1234, "Item Name", 0);
        boolean hasCategory = item.isInCategory(ItemCategory.Beauty);
        assertThat(hasCategory).isTrue();
    }

    @Test
    void doesNotHaveCategory() {
        Item item = createItem(1234, "Item Name", 0);
        ItemCategory food = new GeneralCategory("Food");
        boolean hasCategory = item.isInCategory(food);
        assertThat(hasCategory).isFalse();
    }

    @Test
    void isNotImported() {
        Item item = createItem(1234, "Item1", 0);
        boolean isImported = item.isImported();
        assertThat(isImported).isFalse();
    }

    @Test
    void isImported() {
        Item item = createImportedItem(1234, "Imported Stuff", 100);
        boolean isImported = item.isImported();
        assertThat(isImported).isTrue();
    }


    @Test
    void returnsTotalTaxof28Percent_2Taxes() {
        Item item = createItem(1234, "Imported Stuff", 100);
        TaxRate eightPercent = new TaxRate(8);
        TaxRate twentyPercent = new TaxRate(20);
        TaxCalculator taxCalculator = new TaxCalculator(List.of(eightPercent, twentyPercent));
        int taxes = item.calculateAllTaxes(taxCalculator);
        assertThat(taxes).isEqualTo(30);
    }

    @Test
    void returnsTotalTaxof24_8Percent_2Taxes() {
        Item item = createItem(1234, "Item", 100);
        TaxRate eightPercent = new TaxRate(10.8);
        TaxRate twentyPercent = new TaxRate(14);
        TaxCalculator taxCalculator = new TaxCalculator(List.of(eightPercent, twentyPercent));
        int taxes = item.calculateAllTaxes(taxCalculator);
        assertThat(taxes).isEqualTo(25);
    }

    @Test
    void returnsTotalTaxof15Percent_1Taxes() {
        Item item = createItem(1234, "Item", 100);
        TaxRate fifteenPercent = new TaxRate(15);
        TaxCalculator taxCalculator = new TaxCalculator(List.of(fifteenPercent));
        int taxes = item.calculateAllTaxes(taxCalculator);
        assertThat(taxes).isEqualTo(15);
    }

    @Test
    void returnsTotalTax_18_6Percent_1Taxes() {
         Item item = createItem(1234, "Item", 100);
        TaxRate fifteenPercent = new TaxRate(18.6);
        TaxCalculator taxCalculator = new TaxCalculator(List.of(fifteenPercent));
        int taxes = item.calculateAllTaxes(taxCalculator);
        assertThat(taxes).isEqualTo(20);
    }

    @Test
    void returnsTotalTax_MultiplePercentTaxes() {
        Item item = createItem(1234, "Item", 3200);
        TaxRate fourteenPointTwo = new TaxRate(14.2);
        TaxRate twoPoint5 = new TaxRate(2.5);
        TaxCalculator taxCalculator = new TaxCalculator(List.of(fourteenPointTwo, twoPoint5));
        int taxes = item.calculateAllTaxes(taxCalculator);
        assertThat(taxes).isEqualTo(535);
    }

    @Test
    void appliesOnlyTaxesForCategories() {
        Item item = createItem(1234, "Item", 3200);
        TaxRate fouteenPointTwo = new TaxRate(14.2, List.of(ItemCategory.Beauty));
        TaxRate twoPoint5 = new TaxRate(2.5, List.of(ItemCategory.Food));
        TaxCalculator taxCalculator = new TaxCalculator(List.of(fouteenPointTwo, twoPoint5));
        int taxes = item.calculateAllTaxes(taxCalculator);
        assertThat(taxes).isEqualTo(455);
    }
}
