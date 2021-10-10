package com.zpf.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Number_6 {
    public String convert(String s, int numRows) {
        List<StringBuilder> cache = new ArrayList<>();
        for (int i = 0; i < Math.min(s.length(), numRows); i++) {
            cache.add(new StringBuilder());
        }

        int level = 0;
        boolean isGoDown = true;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            cache.get(level).append(c);
            if (isGoDown) {
                if (level + 1 < numRows) {
                    level++;
                } else {
                    level--;
                    isGoDown = false;
                }
            } else {
                if (level - 1 >= 0) {
                    level--;
                } else {
                    level++;
                    isGoDown = true;
                }
            }
        }
        StringBuilder result = new StringBuilder();
        for (StringBuilder builder : cache) {
            result.append(builder.toString());
        }
        return result.toString();
    }
}
