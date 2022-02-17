package com.zpf.leetcode.number;

import com.zpf.leetcode.util.Execute;

import java.util.ArrayDeque;
import java.util.Deque;

public class Number_7 implements Execute {
    @Override
    public void execute() {

    }

    public int reverse(int x) {
        boolean isPositiveNumber = x >= 0;
        if (!isPositiveNumber) {
            x = x * -1;
        }
        Deque<Integer> deque = new ArrayDeque<>();
        while (x > 0) {
            int remainder = x % 10;
            x = x / 10;
            deque.addLast(remainder);
        }
        double result = 0;
        while (!deque.isEmpty()) {
            int temp = deque.pollFirst();
            result = temp + result * 10;
        }
        if (!isPositiveNumber) {
            result = result * -1;
        }
        if (result >= Integer.MIN_VALUE && result <= Integer.MAX_VALUE) {
            return (int) result;
        } else {
            return 0;
        }
    }
}
