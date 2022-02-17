package com.zpf.leetcode.number;

import com.zpf.leetcode.util.Execute;
import com.zpf.leetcode.util.Log;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Number_523 implements Execute {
    @Override
    public void execute() {
        int[] nums = {5, 0, 0, 0, 0};
        checkSubarraySum(nums, 7);
    }

    public boolean checkSubarraySum(int[] nums, int k) {
        int[] pre = new int[nums.length + 1];
        for (int i = 1; i < pre.length; i++) {
            pre[i] = nums[i - 1] + pre[i - 1];
        }

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int remainder = pre[i] % k;
            if (map.containsKey(remainder) && i > map.get(remainder) + 1) {
                return true;
            } else if (!map.containsKey(remainder)) {
                map.put(remainder, i);
            }
        }
        return false;
    }
}
