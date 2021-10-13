package com.zpf.leetcode.hothundred;

import com.zpf.leetcode.util.Execute;
import com.zpf.leetcode.util.Log;

import java.util.Stack;

public class Hot_Number_85 implements Execute {
    @Override
    public void execute() {

    }

    public int maximalRectangle(char[][] matrix) {
        int row = matrix.length;
        if (row == 0) {
            return 0;
        }
        int col = matrix[0].length;
        int[][] macheWidth = new int[row][col];
//
        for (int i = 0; i < row; i++) {
            macheWidth[i][0] = matrix[i][0] == '1' ? 1 : 0;
            for (int j = 1; j < col; j++) {
                macheWidth[i][j] = matrix[i][j] == '1' ? 1 + macheWidth[i][j - 1] : 0;
            }
        }
        Log.i("中间", macheWidth);
        Stack<Integer> monotonicStack = new Stack<>();
        int result = 0;
        for (int i = 0; i < col; i++) {
            int[] up = new int[row];
            int[] down = new int[row];
            for (int j = 0; j < row; j++) {
                int temp = macheWidth[j][i];
                while (!monotonicStack.isEmpty() && macheWidth[monotonicStack.peek()][i] >= temp) {
                    monotonicStack.pop();
                }
                up[j] = monotonicStack.isEmpty() ? -1 : monotonicStack.peek();
                monotonicStack.add(j);
            }
            monotonicStack.clear();
            for (int j = row - 1; j >= 0; j--) {
                int temp = macheWidth[j][i];
                while (!monotonicStack.isEmpty() && macheWidth[monotonicStack.peek()][i] >= temp) {
                    monotonicStack.pop();
                }
                down[j] = monotonicStack.isEmpty() ? row : monotonicStack.peek();
                monotonicStack.add(j);
            }
            monotonicStack.clear();
            Log.i("第" + i + "列上", up);
            Log.i("第" + i + "列下", down);
            for (int j = 0; j < row; j++) {
                int height = (down[j] - up[j] - 1);
                int temp = height * macheWidth[j][i];
                Log.i("面积" + j + " " + i, temp);
                result = Math.max(temp, result);
            }
        }
        return result;
    }
}
