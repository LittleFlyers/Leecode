package com.zpf.leetcode.hothundred;

import com.zpf.leetcode.util.Execute;

public class Hot_Number_136 implements Execute {
    @Override
    public void execute() {

    }

    public int singleNumber(int[] nums) {
        int result = 0;
        for (int i : nums) {
            result ^= i;
        }
        return result;
    }
}
