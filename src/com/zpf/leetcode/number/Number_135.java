package com.zpf.leetcode.number;

import com.zpf.leetcode.util.Execute;

public class Number_135 implements Execute {
    @Override
    public void execute() {

    }

    public int candy(int[] ratings) {
        int len = ratings.length;
        int[] left = new int[len];
        left[0] = 1;
        for (int i = 1; i < len; i++) {
            if (ratings[i - 1] < ratings[i]) {
                left[i] = left[i - 1] + 1;
            } else {
                left[i] = 1;
            }
        }

        int res = 0;
        int before = 0;
        for (int i = len - 1; i >= 0; i--) {
            if ((i != len - 1) && ratings[i] > ratings[i + 1]) {
                before++;
            } else {
                before = 1;
            }
            res += Math.max(before, left[i]);
        }
        return res;
    }
}
