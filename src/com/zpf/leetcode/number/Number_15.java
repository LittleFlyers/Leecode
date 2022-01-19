package com.zpf.leetcode.number;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Number_15 {
    public List<List<Integer>> threeSum(int[] nums) {
        int len = nums.length;
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < len; i++) {
            if (nums[i] > 0) break;
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int L = i + 1;
            int R = len - 1;
            while (R > L) {
                int num = nums[i] + nums[R] + nums[L];
                if (num == 0) {
                    while (R > L && nums[L] == nums[L + 1]) L++;
                    while (R > L && nums[R] == nums[R - 1]) R--;
                    result.add(Arrays.asList(nums[i], nums[L], nums[R]));
                    R--;
                    L++;
                } else if (num < 0) {
                    L++;
                } else {
                    R--;
                }
            }

        }
        return result;
    }
}
