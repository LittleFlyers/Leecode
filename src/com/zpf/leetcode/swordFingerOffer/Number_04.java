package com.zpf.leetcode.swordFingerOffer;

import com.zpf.leetcode.util.Log;

public class Number_04 {
    public static boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix.length == 0) {
            return false;
        }
        if (matrix.length == 1 && matrix[0].length == 1) {
            return target == matrix[0][0];
        }
        if (matrix.length == 1) {
            for (int i = 0; i < matrix[0].length; i++) {
                if (matrix[0][i] == target) {
                    return true;
                }
            }
            return false;
        }
        if (matrix[0].length == 1) {
            for (int i = 0; i < matrix.length; i++) {
                if (matrix[i][0] == target) {
                    return true;
                }
            }
            return false;
        }

        if (target < matrix[0][0]) {
            return false;
        }
        return reduceMatrix(matrix, 0, 0, matrix.length - 1, matrix[0].length - 1, target);
    }

    public static boolean reduceMatrix(int[][] matrix, int startRow, int startCol, int endRow, int endCol, int target) {
        for (int i = startCol; i <= endCol; i++) {
            Log.i("取值", matrix[endRow][i]);
            if (matrix[endRow][i] > target) {
                Log.i("缩减数组", matrix[endRow][i]);
                if (endRow == 0) {
                    return false;
                }
                return reduceMatrix(matrix, startRow, i, endRow - 1, endCol, target);
            } else if (matrix[endRow][i] == target) {
                Log.i("取到值", matrix[endRow][i]);
                return true;
            }
            Log.i("继续比较值", matrix[endRow][i]);
        }
        return false;
    }
}
