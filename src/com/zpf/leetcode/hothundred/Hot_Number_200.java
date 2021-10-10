package com.zpf.leetcode.hothundred;

import com.zpf.leetcode.util.Log;

public class Hot_Number_200 {
    public void get() {
        char[][] a = {{'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}};
        Log.i("结果", numIslands(a));
    }

    public int numIslands(char[][] grid) {
        int result = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    result++;
                    dfs(grid, i, j);
                }
            }
        }
        return result;
    }

    public void dfs(char[][] grid, int i, int j) {
        Log.i("节选",i + " " +j);
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length) {
            return;
        } else {
            if (grid[i][j] == '1') {
                grid[i][j] = '0';
                dfs(grid, i - 1, j);
                dfs(grid, i + 1, j);
                dfs(grid, i, j - 1);
                dfs(grid, i, j + 1);
            }
        }
    }
}
