package com.zpf.leetcode.hothundred;

import com.zpf.leetcode.util.Execute;
import com.zpf.leetcode.util.Log;

import java.util.HashMap;
import java.util.Map;

public class Hot_Number_169 implements Execute {
    @Override
    public void execute() {
        int[] a = {6, 5, 5};
        majorityElement(a);
    }

    public int majorityElement(int[] nums) {
        Map<Integer, Integer> cache = new HashMap<>();
        int result = nums[0];
        cache.put(nums[0], 1);
        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];
            int temp = cache.getOrDefault(num, 0) + 1;
            cache.put(num, temp);
            Log.i("result", result);
            Log.i("temp", temp);
            result = temp > cache.get(result) ? num : result;
        }

        return result;
    }
}
