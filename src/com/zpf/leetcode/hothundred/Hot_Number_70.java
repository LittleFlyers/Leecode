package com.zpf.leetcode.hothundred;

import com.zpf.leetcode.util.Execute;

public class Hot_Number_70 implements Execute {
    @Override
    public void execute() {
        climbStairs(1);
    }

    public int climbStairs(int n) {
        int[] dp = new int[n + 1];
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}
