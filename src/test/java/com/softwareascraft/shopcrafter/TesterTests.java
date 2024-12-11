package com.softwareascraft.shopcrafter;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@Tag("Unit")
class TesterTests {
    @Test
    void testTester() {
        assertThat(true).isFalse();
    }
}
