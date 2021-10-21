package com.zpf.leetcode.hothundred;

import com.zpf.leetcode.util.Execute;

public class Hot_Number_283 implements Execute {
    @Override
    public void execute() {

    }

    public void moveZeroes(int[] nums) {
        int countZero = 0;
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            if (nums[i] == 0) {
                countZero++;
            } else {
                swap(nums, i, i - countZero);
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
