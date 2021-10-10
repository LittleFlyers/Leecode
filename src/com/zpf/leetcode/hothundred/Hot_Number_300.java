package com.zpf.leetcode.hothundred;

import com.zpf.leetcode.util.Log;

public class Hot_Number_300 {
    public void get() {
        int[] a = {10, 9, 2, 5, 3, 7, 101, 18};
        Log.i("结果", lengthOfLIS(a));
    }

    public int lengthOfLIS(int[] nums) {
        int[] cache = new int[nums.length];
        int max = 1;
        cache[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            int temp = 1;
            boolean has = false;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    has = true;
                    temp = Math.max(temp, cache[j]);
                }
            }
            if (has) temp++;
            cache[i] = temp;
            max = Math.max(temp, max);
        }
        Log.i("缓存", cache);
        return max;
    }
}
