package com.zpf.leetcode.number;

import com.zpf.leetcode.util.Execute;
import com.zpf.leetcode.util.Log;

import java.util.Arrays;

public class Number_611 implements Execute {
    @Override
    public void execute() {
        int[] a = {2, 2, 3, 4};
        Number_611 number_611 = new Number_611();
        Log.i("结果", triangleNumber(a));
    }

    public int triangleNumber(int[] nums) {
        int result = 0;
        Arrays.sort(nums);
        for (int i = 2; i < nums.length; i++) {
            int j = 0;
            for (; j <= i - 1; j++) {
                if (isTriangle(nums[j], nums[j + 1], nums[i])) {
                    break;
                }
            }
            if (j <= i - 1) {
                int temp = factorial(i - j) / (2 * factorial(i - j - 2));
                result += temp;
            }
        }
        return result;
    }

    public boolean isTriangle(int a, int b, int c) {
        return (a + b > c) && (a + c > b) && (b + c > a);
    }

    public int factorial(int a) {
        int result = 1;
        for (int i = 1; i <= a; i++) {
            result *= i;
        }
        return result;
    }
}
