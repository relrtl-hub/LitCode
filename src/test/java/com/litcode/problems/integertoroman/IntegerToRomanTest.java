package com.litcode.problems.integertoroman;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class IntegerToRomanTest {

    private final Solution solution = new Solution();

    @Test
    void example1() {
        assertEquals("MMMDCCXLIX", solution.intToRoman(3749));
    }

    @Test
    void example2() {
        assertEquals("LVIII", solution.intToRoman(58));
    }

    @Test
    void example3() {
        assertEquals("MCMXCIV", solution.intToRoman(1994));
    }

    @Test
    void one() {
        assertEquals("I", solution.intToRoman(1));
    }

    @Test
    void max() {
        assertEquals("MMMCMXCIX", solution.intToRoman(3999));
    }
}
