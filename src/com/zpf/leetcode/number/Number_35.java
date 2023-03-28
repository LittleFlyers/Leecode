package com.zpf.leetcode.number;

import com.zpf.leetcode.util.Execute;
import com.zpf.leetcode.util.Log;

public class Number_35 implements Execute {
    @Override
    public void execute() {
        int[] nums = {1, 3, 5, 6};
        int target = 2;
        Log.i("Number_35", searchInsert(nums, target));
    }

    public int searchInsert(int[] nums, int target) {
        int right = nums.length;
        int left = 0;
        while (left < right) {
            int mid = (left + right) / 2;
            int midValue = nums[mid];
            if (midValue == target) {
                return mid;
            }

            if (midValue < target) {
                if (left == mid) {
                    return left + 1;
                }
                left = mid;
            } else {
                if (right == mid) {
                    return right -1;
                }
                right = mid;
            }
        }
        return left;
    }
}
