package com.litcode.problems.addtwonumbers;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AddTwoNumbersTest {

    private final Solution solution = new Solution();

    @Test
    void example1() {
        ListNode l1 = ListNode.of(2, 4, 3);
        ListNode l2 = ListNode.of(5, 6, 4);
        ListNode result = solution.addTwoNumbers(l1, l2);
        assertArrayEquals(new int[]{7, 0, 8}, result.toArray());
    }

    @Test
    void example2() {
        ListNode l1 = ListNode.of(0);
        ListNode l2 = ListNode.of(0);
        ListNode result = solution.addTwoNumbers(l1, l2);
        assertArrayEquals(new int[]{0}, result.toArray());
    }

    @Test
    void example3() {
        ListNode l1 = ListNode.of(9, 9, 9, 9, 9, 9, 9);
        ListNode l2 = ListNode.of(9, 9, 9, 9);
        ListNode result = solution.addTwoNumbers(l1, l2);
        assertArrayEquals(new int[]{8, 9, 9, 9, 0, 0, 0, 1}, result.toArray());
    }
}
