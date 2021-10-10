package com.zpf.leetcode;

import com.zpf.leetcode.util.Log;

/**
 * 给你一个未排序的整数数组 nums ，请你找出其中没有出现的最小的正整数。
 */
public class Number_41 {
    public static int firstMissingPositive(int[] nums) {
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            int temp = nums[i];
            Log.i("Number_41 a", temp);
            if (temp > length || temp <= 0) {
                Log.i("Number_41 a", nums[i]);
                nums[i] = -1;
            } else {
                nums[i] = nums[temp - 1];
                nums[temp - 1] = temp;
                Log.i("Number_41", nums[temp - 1] +" " + (temp-1));
            }
        }

        for (int i = 0; i < length; i++) {
            if (nums[i] != i + 1) {
                Log.i("e", nums[i]);
                return i + 1;
            }
        }
        return length + 1;

    }
}
