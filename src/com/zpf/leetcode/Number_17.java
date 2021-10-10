package com.zpf.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Number_17 {
    Map<String, String[]> dictionary = new HashMap<>();

    public List<String> letterCombinations(String digits) {
        dictionary.put("2", new String[]{"a", "b", "c"});
        dictionary.put("3", new String[]{"d", "e", "f"});
        dictionary.put("4", new String[]{"g", "h", "i"});
        dictionary.put("5", new String[]{"j", "k", "l"});
        dictionary.put("6", new String[]{"m", "n", "o"});
        dictionary.put("7", new String[]{"p", "q", "r", "s"});
        dictionary.put("8", new String[]{"t", "u", "v"});
        dictionary.put("9", new String[]{"w", "x", "y", "z"});
        List<String> result = new ArrayList<>();
        if (digits.length()==0){
            return result;
        }
        dfs(digits, 0, result, "");
        return result;
    }

    public void dfs(String digits, int index, List<String> result, String cache) {
        if (index == digits.length()) {
            result.add(cache);
        } else {
            String digital = String.valueOf(digits.charAt(index));
            String[] arr = dictionary.get(digital);
            for (String s : arr) {
                cache += s;
                dfs(digits, index + 1, result, cache);
                cache = cache.substring(0, cache.length() - 1);
            }
        }
    }
}
