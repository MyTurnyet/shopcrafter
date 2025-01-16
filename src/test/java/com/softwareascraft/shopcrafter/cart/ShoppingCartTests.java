package com.softwareascraft.shopcrafter.cart;

import com.softwareascraft.shopcrafter.goods.Item;
import com.softwareascraft.shopcrafter.goods.ItemBuilder;
import com.softwareascraft.shopcrafter.goods.ItemCategory;
import com.softwareascraft.shopcrafter.goods.GeneralCategory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@Tag("Unit")
class ShoppingCartTests {
    ShoppingCart shoppingCart;
    Item bananaItem;
    private int bananaPrice;

    @BeforeEach
    void setup() {
        shoppingCart = new ShoppingCart();
        ItemCategory foodCategory = new GeneralCategory("Food");
        bananaPrice = 100;
        bananaItem = new ItemBuilder().addCategory(foodCategory).isImported(false).create(1234, "Banana", bananaPrice);
        shoppingCart.addItem(bananaItem);

    }

    @Test
    void shouldHaveNoItems() {
        ShoppingCart emptyCart = new ShoppingCart();
        int itemCount = emptyCart.itemCount();
        assertThat(itemCount).isZero();
    }

    @Test
    void canAddItems() {
        ShoppingCart emptyCart = new ShoppingCart();
        emptyCart.addItem(bananaItem);
        assertThat(emptyCart.itemCount()).isEqualTo(1);
    }

    @Test
    void returnsSubTotalOfOneItem() {
        int subTotal = shoppingCart.subTotal();
        assertThat(subTotal).isEqualTo(bananaPrice);
    }
}
