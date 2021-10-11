package com.zpf.leetcode.hothundred;

import com.zpf.leetcode.util.Execute;
import com.zpf.leetcode.util.Log;

public class Hot_Number_309 implements Execute {
    @Override
    public void execute() {
        int[] a = {1, 2, 3, 0, 2};
        Log.i("结果", maxProfit(a));
    }

    public int maxProfit(int[] prices) {
        if (prices.length==0){
            return 0;
        }
        int[][] cache = new int[3][prices.length];
        //持有
        cache[0][0] = -prices[0];
/*        //不持有
        cache[1][0] = 0;
        //不持有冷冻
        cache[2][0] = 0;*/

        for (int i = 1; i < prices.length; i++) {
            cache[0][i] = Math.max(cache[0][i - 1], cache[1][i - 1] - prices[i]);
            cache[1][i] = Math.max(cache[2][i - 1], cache[1][i - 1]);
            cache[2][i] = cache[0][i - 1] + prices[i];
        }
        for (int i = 0; i < 3; i++) {
            Log.i("中间" + i, cache[i]);
        }
        return Math.max(cache[1][prices.length-1],cache[2][prices.length-1]);
    }
}
