package com.softwareascraft.shopcrafter.cart;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@Tag("Unit")
class ShoppingCartTests {
    @Test
    void shouldHaveNoItems() {
        ShoppingCart shoppingCart = new ShoppingCart();
        int itemCount = shoppingCart.itemCount();
        assertThat(itemCount).isZero();
    }
}
