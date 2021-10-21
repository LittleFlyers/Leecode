package com.zpf.leetcode.hothundred;

import com.zpf.leetcode.util.Execute;

import java.util.ArrayList;
import java.util.List;

public class Hot_Number_448 implements Execute {
    @Override
    public void execute() {
        int[] a = {4, 3, 2, 7, 7, 2, 3, 1};
        findDisappearedNumbers(a);
    }

    public List<Integer> findDisappearedNumbers(int[] nums) {
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            int x = (nums[i] - 1) % len;
            nums[x] += len;
        }
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            if (nums[i] <= len) {
                result.add(i + 1);
            }
        }
        return result;
    }
}
