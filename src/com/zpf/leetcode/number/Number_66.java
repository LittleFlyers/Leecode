package com.zpf.leetcode.number;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Number_66 {
    public int[] plusOne(int[] digits) {
        List<Integer> result = new ArrayList<>();
        int length = digits.length;
        int start = digits[length - 1] + 1;
        int carry = start / 10;
        int end = start % 10;
        digits[length - 1] = end;
        if (carry == 0) {
            return digits;
        }
        result.add(end);
        for (int i = length - 2; i >= 0; i--) {
            start = digits[i] + carry;
            carry = start / 10;
            end = start % 10;
            digits[i] = end;
            if (carry == 0) {
                return digits;
            }
            result.add(end);
        }
        result.add(1);
        int[] results = new int[result.size()];
        for (int i = result.size() - 1; i >= 0; i--) {
            results[result.size() - i - 1] = result.get(i);
        }
        return results;
    }
}
