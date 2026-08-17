package com.litcode.problems.permutations;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

class PermutationsTest {

    private final Solution solution = new Solution();

    @Test
    void example1() {
        List<List<Integer>> result = solution.permute(new int[]{1,2,3});
        assertEquals(6, result.size());
        assertTrue(result.contains(List.of(1,2,3)));
        assertTrue(result.contains(List.of(1,3,2)));
        assertTrue(result.contains(List.of(2,1,3)));
        assertTrue(result.contains(List.of(2,3,1)));
        assertTrue(result.contains(List.of(3,1,2)));
        assertTrue(result.contains(List.of(3,2,1)));
    }

    @Test
    void example2() {
        List<List<Integer>> result = solution.permute(new int[]{0,1});
        assertEquals(2, result.size());
        assertTrue(result.contains(List.of(0,1)));
        assertTrue(result.contains(List.of(1,0)));
    }

    @Test
    void example3() {
        List<List<Integer>> result = solution.permute(new int[]{1});
        assertEquals(1, result.size());
        assertTrue(result.contains(List.of(1)));
    }
}
