package com.litcode.problems.combinationsum;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

class CombinationSumTest {

    private final Solution solution = new Solution();

    @Test
    void example1() {
        List<List<Integer>> result = solution.combinationSum(new int[]{2,3,6,7}, 7);
        assertEquals(2, result.size());
        assertTrue(result.contains(List.of(2,2,3)));
        assertTrue(result.contains(List.of(7)));
    }

    @Test
    void example2() {
        List<List<Integer>> result = solution.combinationSum(new int[]{2,3,5}, 8);
        assertEquals(3, result.size());
        assertTrue(result.contains(List.of(2,2,2,2)));
        assertTrue(result.contains(List.of(2,3,3)));
        assertTrue(result.contains(List.of(3,5)));
    }

    @Test
    void example3() {
        assertTrue(solution.combinationSum(new int[]{2}, 1).isEmpty());
    }

    @Test
    void singleCandidateMatchesTarget() {
        List<List<Integer>> result = solution.combinationSum(new int[]{3}, 9);
        assertEquals(1, result.size());
        assertTrue(result.contains(List.of(3,3,3)));
    }
}
