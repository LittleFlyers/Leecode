package com.zpf.leetcode.hothundred;

import com.zpf.leetcode.util.Execute;
import com.zpf.leetcode.util.Log;

public class Hot_Number_494 implements Execute {
    /**
     * [0,38,42,31,13,10,11,12,44,16,38,17,22,28,9,27,20,35,34,39]
     * 2
     */
    @Override
    public void execute() {
        int[] nums = {0, 38, 42, 31, 13, 10, 11, 12, 44, 16, 38, 17, 22, 28, 9, 27, 20, 35, 34, 39};
        findTargetSumWays(nums, 2);
    }

    int result = 0;

    public int findTargetSumWays(int[] nums, int target) {
        if (nums.length == 0) {
            return 0;
        }
        dfs(nums, 0, 0, target);

        Log.i("结果", result);
        return result;
    }

    public void dfs(int[] nums, int index, int sum, int target) {
        if (index == nums.length) {
            if (target == sum) {
                result++;
            }
        } else {
            dfs(nums, index + 1, sum - nums[index], target);
            dfs(nums, index + 1, sum + nums[index], target);
        }
    }
}
