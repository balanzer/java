package com.mtvhere.java.problems;

import java.util.Arrays;

public class NumberOfIslands {
    public static void main(String[] args) {
        NumberOfIslands solution = new NumberOfIslands();

        char[][] grid = {
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}
        };

        int output = solution.numIslands(grid);

        System.out.println("Total island : " + output + " input :" + Arrays.deepToString(grid));

    }

    public int numIslands(char[][] grid) {


        if (grid == null || grid.length == 0) {
            return 0;
        }

        int totalIsland = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    totalIsland++;
                    this.dfs(grid, i, j);
                }
            }
        }

        return totalIsland;
    }

    private void dfs(char[][] grid, int r, int c) {

        int nr = grid.length;
        int nc = grid[0].length;

        if (r < 0 || c < 0 || r >= nr || c >= nc || grid[r][c] == '0') {
            return;
        }
        grid[r][c] = '0';

        this.dfs(grid, r - 1, c);
        this.dfs(grid, r + 1, c);
        this.dfs(grid, r, c - 1);
        this.dfs(grid, r, c + 1);
    }
}
