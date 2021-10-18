package com.zpf.leetcode.hothundred;

import com.zpf.leetcode.util.Execute;
import com.zpf.leetcode.util.Log;

public class Hot_Number_560 implements Execute {
    @Override
    public void execute() {
        int[] a = {1, 2, 3};
        Log.i("结果", subarraySum(a, 5));
    }

    public int subarraySum(int[] nums, int k) {
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            int temp = nums[i];
            if (temp == k) {
                result++;
            }
            for (int j = i + 1; j < nums.length; j++) {
                temp += nums[j];
                if (temp == k) {
                    result++;
                }
            }
        }
        return result;
    }
}
