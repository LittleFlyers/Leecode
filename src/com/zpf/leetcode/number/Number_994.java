package com.zpf.leetcode.number;

import com.zpf.leetcode.util.Execute;
import com.zpf.leetcode.util.Log;

import java.util.ArrayDeque;
import java.util.Queue;

public class Number_994 implements Execute {
    @Override
    public void execute() {
        int[][] grid = {{1, 2}};
        Log.i("结果", orangesRotting(grid));
    }

    public int orangesRotting(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int[][] dp = new int[row][col];
        Queue<int[]> cache = new ArrayDeque<>();
        int freshOrangesCount = 0;
        int result = 1;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 1) {
                    freshOrangesCount++;
                }
                if (grid[i][j] == 2) {
                    cache.add(new int[]{i, j});
                    dp[i][j] = 1;
                }
            }
        }
        while (!cache.isEmpty()) {
            int[] index = cache.poll();
            int indexX = index[0];
            int indexY = index[1];
            Log.i("index", indexX + " " + indexY);
            //上方
            int topX = indexX - 1;
            if (topX >= 0) {
                if (grid[topX][indexY] == 1) {
                    freshOrangesCount--;
                    dp[topX][indexY] = dp[indexX][indexY] + 1;
                    cache.add(new int[]{topX, indexY});
                    grid[topX][indexY] = 2;
                    result = Math.max(result, dp[topX][indexY]);
                }
            }
            //下方
            int downX = indexX + 1;
            if (downX < row) {
                if (grid[downX][indexY] == 1) {
                    freshOrangesCount--;
                    dp[downX][indexY] = dp[indexX][indexY] + 1;
                    cache.add(new int[]{downX, indexY});
                    grid[downX][indexY] = 2;
                    result = Math.max(result, dp[downX][indexY]);
                }
            }
            //左方
            int leftY = indexY - 1;
            if (leftY >= 0) {
                if (grid[indexX][leftY] == 1) {
                    Log.i("左方");
                    freshOrangesCount--;
                    dp[indexX][leftY] = dp[indexX][indexY] + 1;
                    cache.add(new int[]{indexX, leftY});
                    grid[indexX][leftY] = 2;
                    result = Math.max(result, dp[indexX][leftY]);
                }
            }
            //右方
            int rightY = indexY + 1;
            if (rightY < col) {
                if (grid[indexX][rightY] == 1) {
                    freshOrangesCount--;
                    dp[indexX][rightY] = dp[indexX][indexY] + 1;
                    cache.add(new int[]{indexX, rightY});
                    grid[indexX][rightY] = 2;
                    result = Math.max(result, dp[indexX][rightY]);
                }
            }
        }
        if (freshOrangesCount > 0) {
            return -1;
        }

        return result - 1;
    }
}
