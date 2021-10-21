package com.zpf.leetcode.hothundred;

import com.zpf.leetcode.util.Execute;

public class Hot_Number_53 implements Execute {

    @Override
    public void execute() {

    }

    public int maxSubArray(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return 0;
        }
        int[] dp = new int[len];
        int result = Integer.MIN_VALUE;
        dp[0] = nums[0];
        result = Math.max(result, dp[0]);
        for (int i = 1; i < len; i++) {
            if (dp[i - 1] > 0) {
                dp[i] = dp[i - 1] + nums[i];
            } else {
                dp[i] = nums[i];
            }
            result = Math.max(result, dp[i]);
        }
        return result;
    }
}
