package com.softwareascraft.shopcrafter.cart;

import com.softwareascraft.shopcrafter.goods.Item;
import com.softwareascraft.shopcrafter.goods.ItemCategory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@Tag("Unit")
class ShoppingCartTests {
    ShoppingCart shoppingCart;
    Item bananaItem;
    private ItemCategory foodCategory;
    private int bananaPrice;

    @BeforeEach
    void setup() {
        shoppingCart = new ShoppingCart();
        foodCategory = new ItemCategory("Food");
        bananaPrice = 100;
        bananaItem = new Item(123, "Banana", bananaPrice, foodCategory, false);
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
