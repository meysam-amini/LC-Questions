package com.meysam.lc._2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CountUnguarded {

    @Test
     void testExample1() {
        int m = 4, n = 6;
        int[][] guards = {{0, 0}, {1, 1}, {2, 3}};
        int[][] walls = {{0, 1}, {2, 2}, {1, 4}};

        int result = countUnguarded(m, n, guards, walls);
        assertEquals(7, result);
    }

    @Test
     void testExample2() {
        int m = 3, n = 3;
        int[][] guards = {{1, 1}};
        int[][] walls = {{0, 1}, {1, 0}, {2, 1}, {1, 2}};

        int result = countUnguarded(m, n, guards, walls);
        assertEquals(4, result);
    }


    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {

        return -1;
    }

}
