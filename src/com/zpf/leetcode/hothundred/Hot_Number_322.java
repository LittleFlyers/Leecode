package com.zpf.leetcode.hothundred;

import com.zpf.leetcode.util.Execute;
import com.zpf.leetcode.util.Log;

import java.util.Arrays;

public class Hot_Number_322 implements Execute {
    //[284,260,393,494]
    //7066
    @Override
    public void execute() {
        int[] a = {284, 260, 393, 494};
        int count = 7066;
        Log.i("结果", coinChange(a, count));
    }


    public int coinChange(int[] coins, int amount) {
        int min = amount + 1;
        int[] cache = new int[amount + 1];
        Arrays.fill(cache, min);
        cache[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (i >= coin) {
                    cache[i] = Math.min(cache[i], cache[i - coin] + 1);
                }
            }
        }

        return cache[amount] > amount ? -1 : cache[amount];
    }
}
