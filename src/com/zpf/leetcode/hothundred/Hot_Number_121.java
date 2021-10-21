package com.zpf.leetcode.hothundred;

import com.zpf.leetcode.util.Execute;

public class Hot_Number_121 implements Execute {
    @Override
    public void execute() {

    }

    public int maxProfit(int[] prices) {
        int result = 0;
        int min = Integer.MAX_VALUE;
        for (int price : prices) {
            if (price < min) {
                min = price;
            } else if (price - min > result) {
                result = price - min;
            }
        }
        return result;
    }
}
