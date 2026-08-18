package com.litcode.problems.invertbinarytree;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class InvertBinaryTreeTest {

    private final Solution solution = new Solution();

    @Test
    void example1() {
        TreeNode root = TreeNode.of(4,2,7,1,3,6,9);
        TreeNode result = solution.invertTree(root);
        assertArrayEquals(new Integer[]{4,7,2,9,6,3,1}, result.toArray());
    }

    @Test
    void example2() {
        TreeNode root = TreeNode.of(2,1,3);
        TreeNode result = solution.invertTree(root);
        assertArrayEquals(new Integer[]{2,3,1}, result.toArray());
    }

    @Test
    void example3() {
        assertNull(solution.invertTree(null));
    }

    @Test
    void singleNode() {
        TreeNode root = TreeNode.of(1);
        TreeNode result = solution.invertTree(root);
        assertArrayEquals(new Integer[]{1}, result.toArray());
    }
}
