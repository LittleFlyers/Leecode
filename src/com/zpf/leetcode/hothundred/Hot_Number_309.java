package com.zpf.leetcode.hothundred;

import com.zpf.leetcode.util.Log;

public class Hot_Number_309 {
    public void get() {
        int[] a = {1, 2, 3, 0, 2};
        Log.i("结果", maxProfit(a));
    }

    public int maxProfit(int[] prices) {
        int[] get = new int[prices.length];
        get[0] = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                get[i] = get[i - 1] + prices[i] - prices[i - 1];
            }
        }
        Log.i("缓存", get);
        int max = 0;
        for (int i = 1; i < get.length; i++) {

        }
        return 0;
    }
}
