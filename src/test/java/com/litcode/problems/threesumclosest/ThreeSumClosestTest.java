package com.litcode.problems.threesumclosest;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ThreeSumClosestTest {

    private final Solution solution = new Solution();

    @Test
    void example1() {
        assertEquals(2, solution.threeSumClosest(new int[]{-1,2,1,-4}, 1));
    }

    @Test
    void example2() {
        assertEquals(3, solution.threeSumClosest(new int[]{0,1,2}, 3));
    }

    @Test
    void exactMatch() {
        assertEquals(0, solution.threeSumClosest(new int[]{-1,0,1}, 0));
    }

    @Test
    void allNegative() {
        assertEquals(-6, solution.threeSumClosest(new int[]{-3,-2,-1}, 0));
    }
}
