package com.litcode.problems.containerwithmostwater;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ContainerWithMostWaterTest {

    private final Solution solution = new Solution();

    @Test
    void example1() {
        assertEquals(49, solution.maxArea(new int[]{1,8,6,2,5,4,8,3,7}));
    }

    @Test
    void example2() {
        assertEquals(1, solution.maxArea(new int[]{1,1}));
    }

    @Test
    void allSameHeight() {
        assertEquals(9, solution.maxArea(new int[]{3,3,3,3}));
    }

    @Test
    void descending() {
        assertEquals(6, solution.maxArea(new int[]{5,4,3,2,1}));
    }
}
