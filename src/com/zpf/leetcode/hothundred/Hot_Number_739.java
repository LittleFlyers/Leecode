package com.zpf.leetcode.hothundred;

import com.zpf.leetcode.util.Execute;
import com.zpf.leetcode.util.Log;

import java.util.ArrayDeque;
import java.util.Deque;

public class Hot_Number_739 implements Execute {
    @Override
    public void execute() {

    }

    public int[] dailyTemperatures(int[] temperatures) {
        int len = temperatures.length;

        int[] result = new int[temperatures.length];
        if (len == 0) {
            return result;
        }
        if (len == 1) {
            result[0] = 0;
            return result;
        }

        result[0] = temperatures[1] > temperatures[0] ? 1 : 0;
        Deque<Integer> cache = new ArrayDeque<>();
        cache.push(0);
        for (int i = 1; i < len; i++) {
            while (!cache.isEmpty() && temperatures[cache.peek()] < temperatures[i]) {
                result[cache.peek()] = i - cache.peek();
                cache.pop();
            }
            cache.push(i);
        }
        Log.i("结果", result);
        return result;
    }
}
