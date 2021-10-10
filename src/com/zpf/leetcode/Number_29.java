package com.zpf.leetcode;

public class Number_29 {
    public void get() {
        divide(2147483647, 2);
    }

    public int divide(int dividend, int divisor) {
        if (dividend == 0) return 0;
        if (divisor == 1) return dividend;
        if (divisor == -1) {
            if (dividend > Integer.MIN_VALUE) return -dividend;// 只要不是最小的那个整数，都是直接返回相反数就好啦
            return Integer.MAX_VALUE;// 是最小的那个，那就返回最大的整数啦
        }
        long a = dividend;
        long b = divisor;
        int sign = 1;
        if ((a > 0 && b < 0) || (a < 0 && b > 0)) {
            sign = -1;
        }
        a = a > 0 ? a : -a;
        b = b > 0 ? b : -b;
        long res = dfs(a, b);
        if (sign > 0) {
            return (int) res;
        }
        return (int) -res;
    }

    public int dfs(long dividend, long divisor) {
        if (dividend < divisor) return 0;
        int count = 1;
        long tb = divisor;
        while ((tb + tb) <= dividend) {
            count = count + count;
            tb = tb + tb;
        }
        return count + dfs(dividend - tb, divisor);
    }
}
