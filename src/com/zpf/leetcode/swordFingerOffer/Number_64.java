package com.zpf.leetcode.swordFingerOffer;

/**
 * 剑指 Offer 64. 求1+2+…+n
 * <p>
 * 求 1+2+...+n ，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
 * <p>
 * 示例 1：
 * <p>
 * 输入: n = 3
 * 输出: 6
 * 示例 2：
 * <p>
 * 输入: n = 9
 * 输出: 45
 */
public class Number_64 {
    public int sumNums(int n) {
        return dfs(n, 0);
    }

    public int dfs(int n, int result) {
        result = n + result;

        return n == 0 ? result : dfs(n - 1, result);
    }
}
