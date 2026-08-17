package com.litcode.problems.reverselinkedlist;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ReverseLinkedListTest {

    private final Solution solution = new Solution();

    @Test
    void example1() {
        ListNode result = solution.reverseList(ListNode.of(1,2,3,4,5));
        assertArrayEquals(new int[]{5,4,3,2,1}, result.toArray());
    }

    @Test
    void example2() {
        ListNode result = solution.reverseList(ListNode.of(1,2));
        assertArrayEquals(new int[]{2,1}, result.toArray());
    }

    @Test
    void example3() {
        assertNull(solution.reverseList(null));
    }

    @Test
    void singleNode() {
        ListNode result = solution.reverseList(ListNode.of(1));
        assertArrayEquals(new int[]{1}, result.toArray());
    }
}
