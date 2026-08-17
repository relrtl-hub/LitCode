package com.litcode.problems.lowestcommonancestorofabst;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class LowestCommonAncestorOfABSTTest {

    private final Solution solution = new Solution();

    @Test
    void example1() {
        TreeNode root = TreeNode.of(6,2,8,0,4,7,9,null,null,null,3,5);
        TreeNode p = root.find(2);
        TreeNode q = root.find(8);
        assertEquals(6, solution.lowestCommonAncestor(root, p, q).val);
    }

    @Test
    void example2() {
        TreeNode root = TreeNode.of(6,2,8,0,4,7,9,null,null,null,3,5);
        TreeNode p = root.find(2);
        TreeNode q = root.find(4);
        assertEquals(2, solution.lowestCommonAncestor(root, p, q).val);
    }

    @Test
    void rootIsLCA() {
        TreeNode root = TreeNode.of(2,1);
        TreeNode p = root.find(1);
        TreeNode q = root.find(2);
        assertEquals(2, solution.lowestCommonAncestor(root, p, q).val);
    }
}
