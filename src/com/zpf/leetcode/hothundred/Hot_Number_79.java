package com.zpf.leetcode.hothundred;

import com.zpf.leetcode.util.Log;

/**
 * 79. 单词搜索
 * <p>
 * 给定一个m x n 二维字符网格board 和一个字符串单词word 。如果word 存在于网格中，返回 true ；否则，返回 false 。
 * <p>
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 * <p>
 * <p>
 * 示例 1：
 * 输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
 * 输出：true
 * <p>
 * 示例 2：
 * 输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "SEE"
 * 输出：true
 * <p>
 * 示例 3：
 * 输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCB"
 * 输出：false
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/word-search
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Hot_Number_79 {

    public void get() {
/*        char[][] a = {{"A".charAt(0), "B".charAt(0), "C".charAt(0), "E".charAt(0)},
                {"S".charAt(0), "F".charAt(0), "C".charAt(0), "S".charAt(0)},
                {"A".charAt(0), "D".charAt(0), "E".charAt(0), "E".charAt(0)}};0*/
        char[][] a = {{"C".charAt(0), "A".charAt(0), "A".charAt(0)},
                {"A".charAt(0), "A".charAt(0), "A".charAt(0)},
                {"B".charAt(0), "C".charAt(0), "D".charAt(0)}};
        Log.i("结果", exist(a, "AAB"));
    }

    public boolean exist(char[][] board, String word) {
        Log.i("单词长度", word.length());
        if (board.length == board[0].length && board.length == 1) {
            if (word.length() == 1) {
                return board[0][0] == word.charAt(0);
            } else {
                return false;
            }
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    boolean a = dfs(board, word, 0, i, j);
                    Log.i("回溯结果", a);
                    if (a) {
                        return true;
                    }
                }

            }
        }
        return false;
    }

    public boolean dfs(char[][] board, String word, int index, int row, int col) {
        if (index >= word.length()) {
            return true;
        } else {
            int m = board.length;
            int n = board[0].length;
            if (row >= m || col >= n || row < 0 || col < 0) {
                return false;
            }
            if (board[row][col] != word.charAt(index)) {
                return false;
            }
            char cache = board[row][col];
            board[row][col] = "0".charAt(0);
            boolean a = dfs(board, word, index + 1, row + 1, col)
                    || dfs(board, word, index + 1, row - 1, col)
                    || dfs(board, word, index + 1, row, col + 1)
                    || dfs(board, word, index + 1, row, col - 1);
            board[row][col] = cache;
            return a;
        }
    }
}
