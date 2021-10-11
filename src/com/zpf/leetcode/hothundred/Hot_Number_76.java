package com.zpf.leetcode.hothundred;

import com.zpf.leetcode.util.Execute;
import com.zpf.leetcode.util.Log;

import java.util.HashMap;
import java.util.Map;

public class Hot_Number_76 implements Execute {
    @Override
    public void execute() {
        //"ADOBECODEBANC"
        //"ABC"
        Log.i("结果", minWindow("abc", "cba"));
    }

    Map<Character, Integer> cacheS = new HashMap<>();
    Map<Character, Integer> cacheT = new HashMap<>();

    public String minWindow(String s, String t) {
        int start = 0;
        int end = -1;
        int startCache = -1;
        int endCache = -1;
        int len = Integer.MAX_VALUE;
        for (int i = 0; i < t.length(); i++) {
            cacheT.put(t.charAt(i), cacheT.getOrDefault(t.charAt(i), 0) + 1);
        }
        while (end < s.length()) {
            end++;
            Log.i("中间end", start + " " + end);
            if (end < s.length()) {
                cacheS.put(s.charAt(end), cacheS.getOrDefault(s.charAt(end), 0) + 1);
            }
            while (check() && start <= end) {
                Log.i("中间", start + " " + end);
                if (end - start + 1 < len) {
                    len = end - start + 1;
                    startCache = start;
                    endCache = end + 1;
                }

                if (cacheT.containsKey(s.charAt(start))) {
                    cacheS.put(s.charAt(start), cacheS.getOrDefault(s.charAt(start), 0) - 1);
                }
                start++;
            }

        }
        return startCache == -1 ? "" : s.substring(startCache, endCache);
    }

    public boolean check() {
        for (Map.Entry<Character, Integer> entry : cacheT.entrySet()) {
            if (cacheS.getOrDefault(entry.getKey(), 0) < entry.getValue()) {
                return false;
            }
        }
        return true;
    }
}
