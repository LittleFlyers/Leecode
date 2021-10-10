package com.zpf.leetcode.swordFingerOffer;

import com.zpf.leetcode.util.Log;

/**
 * 剑指 Offer 13. 机器人的运动范围
 * <p>
 * 地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。一个机器人从坐标 [0, 0] 的格子开始移动，
 * 它每次可以向左、右、上、下移动一格（不能移动到方格外），也不能进入行坐标和列坐标的数位之和大于k的格子。
 * 例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。但它不能进入方格 [35, 38]，因为3+5+3+8=19。
 * 请问该机器人能够到达多少个格子？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/ji-qi-ren-de-yun-dong-fan-wei-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Number_13 {
    public static int movingCount(int m, int n, int k) {
        //初始化地图数组
        int[][] map = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (transform(i) + transform(j) > k) {
                    //不能进
                    map[i][j] = 0;
                } else {
                    //可以进
                    map[i][j] = 1;
                }
            }
        }
        Log.i("设定数组", map);
        int[][] resultMap = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                resultMap[i][j] = 0;
            }
        }
        resultMap[0][0] = 1;
        dfs(map, resultMap, 0, 0);
        int result = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                result += resultMap[i][j];
            }
        }
        Log.i("结果数组", resultMap);
        return result;
    }

    private static void dfs(int[][] map, int[][] resultMap, int row, int col) {
        if (row < 0 || col < 0 || row >= map.length || col >= map[0].length || map[row][col] == 0) {
            return;
        }
        resultMap[row][col] = 1;
        map[row][col] = 0;
        dfs(map, resultMap, row + 1, col);
        dfs(map, resultMap, row, col + 1);
    }

    private static int transform(int input) {
        int result = 0;
        while (input != 0) {
            result += input % 10;
            input = input / 10;
        }
        return result;
    }
}
