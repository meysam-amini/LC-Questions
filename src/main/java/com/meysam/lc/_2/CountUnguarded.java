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

        // 0 = empty, 1 = guard, 2 = wall, 3 = guarded
        int[][] grid = new int[m][n];

        // Mark guards
        for (int[] guard : guards) {
            grid[guard[0]][guard[1]] = 1;
        }

        // Mark walls
        for (int[] wall : walls) {
            grid[wall[0]][wall[1]] = 2;
        }

        // Directions: up, right, down, left
        int[][] directions = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

        // For each guard, mark all visible cells
        for (int[] guard : guards) {
            int row = guard[0];
            int col = guard[1];

            // Check all four directions
            for (int[] dir : directions) {
                int r = row + dir[0];
                int c = col + dir[1];

                // Keep going in this direction until we hit boundary, wall, or guard
                while (r >= 0 && r < m && c >= 0 && c < n && grid[r][c] != 1 && grid[r][c] != 2) {
                    // Mark as guarded (3)
                    grid[r][c] = 3;

                    // Move to next cell in this direction
                    r += dir[0];
                    c += dir[1];
                }
            }
        }

        // Count unguarded cells (cells that are still 0)
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    count++;
                }
            }
        }

        return count;
    }
}


