package com.zpf.leetcode.hothundred;

import com.zpf.leetcode.util.Execute;

import java.util.ArrayDeque;
import java.util.Deque;

public class Hot_Number_20 implements Execute {
    @Override
    public void execute() {

    }

    public boolean isValid(String s) {
        Deque<Character> cache = new ArrayDeque<>();
        int len = s.length();
        for (int i = 0; i < len; i++) {
            char temp = s.charAt(i);
            if (temp == '{' || temp == '(' || temp == '[') {
                cache.push(temp);
            } else {
                if (cache.isEmpty()) {
                    return false;
                } else {
                    if ((temp == '}' && cache.peek() == '{') ||
                            (temp == ')' && cache.peek() == '(') ||
                            (temp == ']' && cache.peek() == '[')) {
                        cache.pop();
                    } else {
                        return false;
                    }
                }
            }
        }
        return cache.isEmpty();
    }
}
