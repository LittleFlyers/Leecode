package com.zpf.leetcode.hothundred;

import com.zpf.leetcode.util.Execute;
import com.zpf.leetcode.util.Log;

public class Hot_Number_416 implements Execute {
    @Override
    public void execute() {
        int[] a = {100};
        Log.i("结果", canPartition(a));
    }

    public boolean canPartition(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return false;
        }
        int cache = 0;
        int max = 0;
        for (int i : nums) {
            cache += i;
            max = Math.max(i, max);
        }
        if (cache % 2 == 1 || cache / 2 < max) {
            return false;
        }
        cache = cache / 2;
        Log.i("cache", cache);
        boolean[][] dp = new boolean[len][cache + 1];
        for (int i = 0; i < len; i++) {
            dp[i][0] = true;
        }
        dp[0][nums[0]] = true;
        for (int i = 1; i < len; i++) {
            int temp = nums[i];
            for (int j = 1; j <= cache; j++) {
                if (j > temp) {
                    dp[i][j] = dp[i - 1][j] | dp[i - 1][j - temp];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[len - 1][cache];
    }
}
