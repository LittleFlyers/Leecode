package com.zpf.leetcode.hothundred;

import com.zpf.leetcode.util.Log;

public class Hot_Number_152 {

    public void get() {
        int[] a = {2, -5, -2, -4, 3};
        Log.i("结果", maxProduct(a));
    }

    public int maxProduct(int[] nums) {
        int maxCa = nums[0];
        int minCa = nums[0];
        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int max = maxCa;
            int min = minCa;
            maxCa = Math.max(max * nums[i], Math.max(nums[i], nums[i] * min));
            minCa = Math.min(min * nums[i], Math.min(nums[i], nums[i] * max));
            res = Math.max(res, max);
        }
        return res;
    }
}
