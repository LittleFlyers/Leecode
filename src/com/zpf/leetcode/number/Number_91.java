package com.zpf.leetcode.number;

import com.zpf.leetcode.util.Execute;
import com.zpf.leetcode.util.Log;

public class Number_91 implements Execute {
    @Override
    public void execute() {
        Number_91 number_91 = new Number_91();
        Log.i("結果", number_91.numDecodings("226"));
    }


    public int numDecodings(String s) {
        if (s.length() == 0) {
            return 0;
        }

        if (s.charAt(0) == '0') {
            return 0;
        }
        int[] cache = new int[s.length()];
        cache[0] = 1;
        if (s.length() == 1) {
            return 1;
        }
        int second = Integer.parseInt(s.substring(0, 2));
        if (second <= 26 && second != 20 && second != 10) {
            cache[1] = 2;
        } else {
            if (s.charAt(1) == '0' && second > 26) {
                return 0;
            }
            cache[1] = 1;
        }
        for (int i = 2; i < s.length(); i++) {
            int temp = Integer.parseInt(s.substring(i - 1, i + 1));
            if (s.charAt(i) != '0') {
                cache[i] = cache[i] + cache[i - 1];
                if (s.charAt(i - 1) != '0') {
                    if (temp <= 26) {
                        cache[i] = cache[i] + cache[i - 2];
                    }
                }
            } else {
                if (s.charAt(i - 1) != '0') {
                    if (temp <= 26) {
                        cache[i] = cache[i] + cache[i - 2];
                    } else {
                        return 0;
                    }
                } else {
                    return 0;
                }
            }

        }

        return cache[s.length() - 1];
    }


}
