package com.zpf.leetcode.hothundred;

import com.zpf.leetcode.util.Execute;
import com.zpf.leetcode.util.Log;

public class Hot_Number_72 implements Execute {
    @Override
    public void execute() {
        Log.i("结果", minDistance("horse", "ros"));
    }

    public int minDistance(String word1, String word2) {
        int word1Len = word1.length();
        int word2Len = word2.length();
        if (word1Len * word2Len == 0) {
            return Math.max(word1Len, word2Len);
        }
        int[][] cache = new int[word1Len + 1][word2Len + 1];
        for (int i = 0; i < word1Len + 1; i++) {
            cache[i][0] = i;
        }
        for (int i = 0; i < word2Len + 1; i++) {
            cache[0][i] = i;
        }

        for (int i = 1; i < word1Len + 1; i++) {
            for (int j = 1; j < word2Len + 1; j++) {
                int add = cache[i - 1][j] + 1;
                int delete = cache[i][j - 1] + 1;
                int replace = cache[i - 1][j - 1];
                if (word1.charAt(i - 1) != word2.charAt(j - 1)) {
                    replace++;
                }
                cache[i][j] = Math.min(add, Math.min(delete, replace));
            }
        }
        return cache[word1Len][word2Len];
    }
}
