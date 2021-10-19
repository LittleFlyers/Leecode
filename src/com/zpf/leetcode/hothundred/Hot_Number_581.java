package com.zpf.leetcode.hothundred;

import com.zpf.leetcode.util.Execute;
import com.zpf.leetcode.util.Log;

import java.util.Arrays;

public class Hot_Number_581 implements Execute {
    @Override
    public void execute() {

    }

    public int findUnsortedSubarray(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return 0;
        }
        if (len == 1) {
            return 0;
        }
        int[] root = new int[len];
        System.arraycopy(nums, 0, root, 0, len);
        Arrays.sort(nums);
        Log.i("中间", nums);
        Log.i("中间", root);
        int i = 0;
        int j = len - 1;
        while (i <= j) {
            if (nums[i] == root[i] && nums[j] == root[j]) {
                i++;
                j--;
            } else if (nums[i] == root[i]) {
                i++;
            } else if (nums[j] == root[j]) {
                j--;
            } else {
                break;
            }
        }
        Log.i("结果", i + " " + j);
        int result = j - i + 1;
        result = Math.max(result, 0);
        return result;
    }
}
