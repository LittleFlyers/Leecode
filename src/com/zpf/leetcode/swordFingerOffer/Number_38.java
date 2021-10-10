package com.zpf.leetcode.swordFingerOffer;

import com.zpf.leetcode.util.Log;

import java.util.*;

public class Number_38 {
    public void get() {
        String[] a = permutation("aab");
        for (int i = 0; i < a.length; i++) {
            Log.i("结果数组", a[i]);
        }
    }

    public String[] permutation(String s) {
        HashSet<String> cache = new HashSet<>();
        Stack<String> stack = new Stack<>();
        dfs(cache, s, stack);
        String[] resultStr = new String[cache.size()];
        int i = 0;
        for (String ca : cache) {
            resultStr[i] = ca;
            i++;
        }

        return resultStr;
    }

    public void dfs(HashSet<String> cache, String input, Stack<String> stack) {
        if (input.length() == 0) {
            String re = stack.toString().replace(",", "").replace("[", "").replace("]", "");
            re = re.replace(" ", "");
            Log.i("结果", re);
            cache.add(re);

        } else {
            for (int i = 0; i < input.length(); i++) {
                stack.push(String.valueOf(input.charAt(i)));
                Log.i("入站", String.valueOf(input.charAt(i)));
                String temp = input.substring(0, i) + input.substring(i + 1);
                Log.i("剩余", temp);
                dfs(cache, temp, stack);
                stack.pop();
            }
        }
    }

    public int anInt(int input) {
        int result = 1;
        for (int i = 1; i <= input; i++) {
            result *= i;
        }
        return result;
    }

}
