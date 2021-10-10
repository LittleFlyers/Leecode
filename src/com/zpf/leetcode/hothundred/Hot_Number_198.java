package com.zpf.leetcode.hothundred;

public class Hot_Number_198 {
    public int rob(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        if (nums.length == 3) {
            nums[2] = nums[2] + nums[0];
            return Math.max(nums[2], nums[1]);
        }
        nums[2] = nums[2] + nums[0];
        for (int i = 3; i < nums.length; i++) {
            if (nums[i - 2] > nums[i - 3]) {
                nums[i] += nums[i - 2];
            } else {
                nums[i] += nums[i - 3];
            }
        }
        int max = 0;
        for (int i : nums) {
            if (i > max) {
                max = i;
            }
        }
        return max;
    }
}
