package com.zpf.leetcode.hothundred;

import com.zpf.leetcode.util.Execute;
import com.zpf.leetcode.util.Log;

import java.util.Stack;

public class Hot_Number_394 implements Execute {
    @Override
    public void execute() {
        Log.i("结果", decodeString("3[a]2[bc]"));
    }


    public String decodeString(String s) {
        Stack<Character> cache = new Stack<>();
        Stack<Integer> cacheCount = new Stack<>();
        StringBuilder builder = new StringBuilder();
        int cacheInteger = 0;
        for (int i = 0; i < s.length(); i++) {
            char temp = s.charAt(i);
            Log.i("temp", String.valueOf(temp));
            if (temp == ']') {
                StringBuilder cacheBuilder = new StringBuilder();
                while (cache.peek() != '[') {
                    cacheBuilder.insert(0, cache.pop());
                }
                cache.pop();
                int count = cacheCount.pop();
                for (int j = 0; j < count; j++) {
                    String cacheStr = cacheBuilder.toString();
                    for (int k = 0; k < cacheStr.length(); k++) {
                        cache.add(cacheStr.charAt(k));
                    }
                }
            } else if (isNumber(temp)) {
                Log.i("中间", Character.getNumericValue(temp));
                if (isNumber(s.charAt(i + 1))) {
                    cacheInteger = cacheInteger * 10 + Character.getNumericValue(temp);
                } else {
                    cacheInteger = cacheInteger * 10 + Character.getNumericValue(temp);
                    Log.i("进入", cacheInteger);
                    cacheCount.add(cacheInteger);
                    cacheInteger = 0;
                }
            } else {
                cache.add(temp);
            }
        }
        while (!cache.isEmpty()) {
            char temp = cache.pop();
            builder.insert(0, temp);
        }
        return builder.toString();
    }

    public boolean isNumber(char s) {
        return Character.isDigit(s);
    }
}
