package com.zpf.leetcode.swordFingerOffer;

/**
 * 12. 矩阵中的路径
 * <p>
 * 给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。
 * <p>
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 * <p>
 * 示例 1：
 * <p>
 * 输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
 * 输出：true
 * 示例 2：
 * <p>
 * 输入：board = [["a","b"],["c","d"]], word = "abcd"
 * 输出：false
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/ju-zhen-zhong-de-lu-jing-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Number_12 {
    public boolean exist(char[][] board, String word) {
        boolean re = false;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    re = explore(board, word, 0, i, j);
                    if (re) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean explore(char[][] board, String word, int hasChose, int currentRow, int currentCol) {
        if (currentRow >= board.length || currentRow < 0 ||
                currentCol >= board[0].length || currentCol < 0 ||
                board[currentRow][currentCol] != word.charAt(hasChose)) {
            return false;
        }
        if (hasChose == word.length() - 1) {
            return true;
        }
        board[currentRow][currentCol] = '\0';
        boolean re = explore(board, word, hasChose + 1, currentRow + 1, currentCol) ||
                explore(board, word, hasChose + 1, currentRow, currentCol + 1) ||
                explore(board, word, hasChose + 1, currentRow - 1, currentCol) ||
                explore(board, word, hasChose + 1, currentRow, currentCol - 1);
        board[currentRow][currentCol] = word.charAt(hasChose);
        return re;
    }
}
