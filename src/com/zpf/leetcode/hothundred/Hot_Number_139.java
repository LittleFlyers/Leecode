package com.zpf.leetcode.hothundred;

import com.zpf.leetcode.util.Log;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Hot_Number_139 {
    public void get() {
        List<String> a = new ArrayList<>();
        a.add("cats");
        a.add("dog");
        a.add("sand");
        a.add("and");
        a.add("cat");
        Log.i("结果：", wordBreak("catsandog", a));
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> word = new HashSet<>(wordDict);
        boolean[] cache = new boolean[s.length() + 1];
        cache[0] = true;
        for (int i = 1; i < s.length() + 1; i++) {
            for (int j = 0; j < i; j++) {
                if (cache[j] && word.contains(s.substring(j, i))) {
                    cache[i] = true;
                    break;
                }
            }
        }
        return cache[s.length()];
    }
}
