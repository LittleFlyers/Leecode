package com.zpf.leetcode.hothundred;

import com.zpf.leetcode.util.Log;

public class Hot_Number_96 {


    public void get() {
        Log.i("结果", numTrees(1));
    }


    public int numTrees(int n) {
        int[] cache = new int[n + 1];
        cache[0] = 1;
        cache[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                cache[i] += cache[j - 1] * cache[i - j];
            }
        }

        return cache[n];
    }


}
