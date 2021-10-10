package com.zpf.leetcode.swordFingerOffer;

import com.zpf.leetcode.util.Log;

public class Number_44 {
    public void get() {
        Log.i("结果", findNthDigit(1000000000));
    }

    public int findNthDigit(int n) {
        if (n < 10) {
            return n;
        }
        dfs(n, 1);
        return dfs(n, 1);
    }

    public int dfs(int n, int bit) {
        long bitCount = 0;
        if (bit == 1) {
            bitCount = 10;
        } else {
            bitCount = (int) (Math.pow(10, bit) - Math.pow(10, bit - 1));
        }
        if (n < bitCount * bit) {
            Log.i("n", n);
            Log.i("位数", bit);
            int digitalIndex = n / bit;
            int bitIndex = n % bit;
            int digital = (int) Math.pow(10, bit - 1) + digitalIndex;
            String cache = String.valueOf(digital);
            return Integer.parseInt(String.valueOf(cache.charAt(bitIndex)));
        } else {
            Log.i("位数 位数个数", bit + " " + bitCount);
            if (n - bitCount * bit < 0) {
                int digitalIndex = n / bit;
                int bitIndex = n % bit;
                int digital = (int) Math.pow(10, bit - 1) + digitalIndex;
                String cache = String.valueOf(digital);
                return Integer.parseInt(String.valueOf(cache.charAt(bitIndex)));
            } else {
                n -= bitCount * bit;
                return dfs(n, bit + 1);
            }

        }
    }
}
