package com.zpf.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Number_54 {
    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        List<Integer> list = new ArrayList<>();

        return list;
    }

    public void ls(int[][] matrix, List<Integer> list, int startRow, int startCnl) {
        //总行
        int m = matrix.length;
        //总列
        int n = matrix[0].length;
        if (startRow >= m / 2 || startCnl >= n / 2) {

        }
        for (int i = startRow; i < m - startRow; i++) {
            list.add(matrix[startCnl][i]);
        }
        for (int i = startCnl - 1; i < m - startCnl; i++) {
            list.add(matrix[i][n - startRow]);
        }
        for (int i = n - startCnl - 1; i > startCnl; i--) {
            list.add(matrix[m - startRow][i]);
        }
        for (int i = m - startRow - 1; i > startRow + 1; i--) {
            list.add(matrix[i][startCnl]);
        }
        ls(matrix, list, startRow + 1, startCnl + 1);
    }
}
