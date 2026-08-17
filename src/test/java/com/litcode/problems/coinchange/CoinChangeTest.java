package com.litcode.problems.coinchange;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CoinChangeTest {

    private final Solution solution = new Solution();

    @Test
    void example1() {
        assertEquals(3, solution.coinChange(new int[]{1,2,5}, 11));
    }

    @Test
    void example2() {
        assertEquals(-1, solution.coinChange(new int[]{2}, 3));
    }

    @Test
    void example3() {
        assertEquals(0, solution.coinChange(new int[]{1}, 0));
    }

    @Test
    void singleCoin() {
        assertEquals(3, solution.coinChange(new int[]{3}, 9));
    }
}
