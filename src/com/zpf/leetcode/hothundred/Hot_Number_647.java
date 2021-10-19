package com.zpf.leetcode.hothundred;

import com.zpf.leetcode.util.Execute;

public class Hot_Number_647 implements Execute {
    @Override
    public void execute() {
        countSubstrings("abc");
    }

    public int countSubstrings(String s) {
        int len = s.length();
        if (len == 0) {
            return 0;
        }
        int result = 0;
        boolean[][] cache = new boolean[len][len];
        for (int i = 0; i < len; i++) {
            cache[i][i] = true;
            result++;
        }
        for (int i = 0; i < len; i++) {
            char temp = s.charAt(i);
            for (int j = 0; j < i; j++) {
                char check = s.charAt(j);
                if (temp == check) {
                    if (i - j < 2 || cache[j + 1][i - 1]) {
                        cache[j][i] = true;
                        result++;
                    }
                }
            }
        }
        return result;
    }
}
