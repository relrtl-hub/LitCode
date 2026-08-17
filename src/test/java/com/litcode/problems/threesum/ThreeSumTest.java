package com.litcode.problems.threesum;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

class ThreeSumTest {

    private final Solution solution = new Solution();

    @Test
    void example1() {
        List<List<Integer>> result = solution.threeSum(new int[]{-1,0,1,2,-1,-4});
        assertEquals(2, result.size());
        assertTrue(result.contains(List.of(-1,-1,2)));
        assertTrue(result.contains(List.of(-1,0,1)));
    }

    @Test
    void example2() {
        assertTrue(solution.threeSum(new int[]{0,1,1}).isEmpty());
    }

    @Test
    void example3() {
        List<List<Integer>> result = solution.threeSum(new int[]{0,0,0});
        assertEquals(1, result.size());
        assertTrue(result.contains(List.of(0,0,0)));
    }

    @Test
    void allZeros() {
        List<List<Integer>> result = solution.threeSum(new int[]{0,0,0,0});
        assertEquals(1, result.size());
    }
}
