package com.litcode.problems.nextpermutation;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class NextPermutationTest {

    private final Solution solution = new Solution();

    @Test
    void example1() {
        int[] nums = {1,2,3};
        solution.nextPermutation(nums);
        assertArrayEquals(new int[]{1,3,2}, nums);
    }

    @Test
    void example2() {
        int[] nums = {3,2,1};
        solution.nextPermutation(nums);
        assertArrayEquals(new int[]{1,2,3}, nums);
    }

    @Test
    void example3() {
        int[] nums = {1,1,5};
        solution.nextPermutation(nums);
        assertArrayEquals(new int[]{1,5,1}, nums);
    }

    @Test
    void singleElement() {
        int[] nums = {1};
        solution.nextPermutation(nums);
        assertArrayEquals(new int[]{1}, nums);
    }
}
