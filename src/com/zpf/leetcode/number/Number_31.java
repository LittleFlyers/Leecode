package com.zpf.leetcode.number;

import com.zpf.leetcode.util.Log;

public class Number_31 {
    public void get() {
        int[] nums = {1, 3, 2};
        nextPermutation(nums);
        Log.i("结果", nums);
    }

    public void nextPermutation(int[] nums) {
        if (nums.length <= 1) {
            return;
        }
        int cacheI = nums.length - 1;
        int cacheJ = 0;
        boolean is = false;
        for (int i = nums.length - 1; i > 0; i--) {
            for (int j = 0; j <= i - 1; j++) {
                if (nums[i] > nums[j]) {
                    is = true;
                    if (j > cacheJ) {
                        cacheJ = j;
                        cacheI = i;
                    } else if (j == cacheJ) {
                        if (nums[cacheI] > nums[i]) {
                            cacheI = i;
                        }
                    }


                }
            }
        }
        if (is) {
            swap(nums, cacheI, cacheJ);
            return;
        }
        int len = nums.length;
        int mid = len / 2;
        for (int i = 0; i < mid; i++) {
            if (i != len - i - 1) {
                swap(nums, i, len - i - 1);
            } else {
                return;
            }
        }
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
