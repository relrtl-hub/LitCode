package com.litcode.problems.longestpalindromicsubstring;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class LongestPalindromicSubstringTest {

    private final Solution solution = new Solution();

    @Test
    void example1() {
        String result = solution.longestPalindrome("babad");
        assertTrue("bab".equals(result) || "aba".equals(result));
    }

    @Test
    void example2() {
        assertEquals("bb", solution.longestPalindrome("cbbd"));
    }

    @Test
    void singleChar() {
        assertEquals("a", solution.longestPalindrome("a"));
    }

    @Test
    void allSame() {
        assertEquals("aaaa", solution.longestPalindrome("aaaa"));
    }
}
