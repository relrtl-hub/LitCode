package com.litcode.problems.regularexpressionmatching;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class RegularExpressionMatchingTest {

    private final Solution solution = new Solution();

    @Test
    void example1() {
        assertFalse(solution.isMatch("aa", "a"));
    }

    @Test
    void example2() {
        assertTrue(solution.isMatch("aa", "a*"));
    }

    @Test
    void example3() {
        assertTrue(solution.isMatch("ab", ".*"));
    }

    @Test
    void example4() {
        assertTrue(solution.isMatch("aab", "c*a*b"));
    }

    @Test
    void emptyStringEmptyPattern() {
        assertTrue(solution.isMatch("", ""));
    }

    @Test
    void starOnEmpty() {
        assertTrue(solution.isMatch("", "a*"));
    }

    @Test
    void dotMatch() {
        assertTrue(solution.isMatch("a", "."));
    }

    @Test
    void complexPatternNoMatch() {
        assertFalse(solution.isMatch("mississippi", "mis*is*p*."));
    }

    @Test
    void complexPatternMatch() {
        assertTrue(solution.isMatch("mississippi", "mis*is*p*.*i"));
    }
}
