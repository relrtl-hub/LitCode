package com.litcode.problems.spiralmatrix;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

class SpiralMatrixTest {

    private final Solution solution = new Solution();

    @Test
    void example1() {
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        assertEquals(List.of(1,2,3,6,9,8,7,4,5), solution.spiralOrder(matrix));
    }

    @Test
    void example2() {
        int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        assertEquals(List.of(1,2,3,4,8,12,11,10,9,5,6,7), solution.spiralOrder(matrix));
    }

    @Test
    void singleRow() {
        int[][] matrix = {{1,2,3}};
        assertEquals(List.of(1,2,3), solution.spiralOrder(matrix));
    }

    @Test
    void singleColumn() {
        int[][] matrix = {{1},{2},{3}};
        assertEquals(List.of(1,2,3), solution.spiralOrder(matrix));
    }
}
