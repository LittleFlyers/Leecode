package com.zpf.leetcode.swordFingerOffer;

import com.zpf.leetcode.util.Log;

/**
 * 剑指 Offer 16. 数值的整数次方
 * <p>
 * 实现pow(x,n)，即计算 x 的 n 次幂函数（即，xn）。不得使用库函数，同时不需要考虑大数问题。
 * <p>
 * 示例 1：
 * <p>
 * 输入：x = 2.00000, n = 10
 * 输出：1024.00000
 * 示例 2：
 * <p>
 * 输入：x = 2.10000, n = 3
 * 输出：9.26100
 * 示例 3：
 * <p>
 * 输入：x = 2.00000, n = -2
 * 输出：0.25000
 * 解释：2-2 = 1/22 = 1/4 = 0.25
 */
public class Number_16 {
    public static double myPow(double x, int n) {
        return (n >= 0) ? get(x, n) : 1 / get(x, n);
    }

    public static double get(double x, long n) {
        if (n == 0) {
            return 1.0;
        }
        double y = get(x, n / 2);
        Log.i("每次迭代结果", y);
        return n % 2 == 0 ? y * y : y * y * x;
    }
}
