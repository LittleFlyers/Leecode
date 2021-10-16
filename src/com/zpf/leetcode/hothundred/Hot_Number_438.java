package com.zpf.leetcode.hothundred;

import com.zpf.leetcode.util.Execute;
import com.zpf.leetcode.util.Log;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Hot_Number_438 implements Execute {
    @Override
    public void execute() {
        String s = "cbaebabacd", p = "abc";
        List<Integer> re = findAnagrams(s, p);
        for (int i : re) {
            Log.i("结果", i);
        }
    }

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        int lenS = s.length();
        int lenP = p.length();
        if (lenS < lenP) {
            return result;
        }
        int[] sCon = new int[26];
        int[] pCon = new int[26];
        for (int i = 0; i < lenP; i++) {
            sCon[s.charAt(i) - 'a']++;
            pCon[p.charAt(i) - 'a']++;
        }
        if (Arrays.equals(sCon, pCon)) {
            result.add(0);
        }
        for (int i = lenP; i < lenS; i++) {
            sCon[s.charAt(i - lenP) - 'a']--;
            sCon[s.charAt(i) - 'a']++;
            if (Arrays.equals(sCon, pCon)) {
                result.add(i - lenP + 1);
            }
        }
        return result;
    }
}
