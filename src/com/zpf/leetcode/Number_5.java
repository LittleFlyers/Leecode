package com.zpf.leetcode;

public class Number_5 {
    public String longestPalindrome(String s) {
        if (s.length() < 2) {
            return s;
        }
        int maxlength = 1;
        int begin = 0;
        boolean[][] isPalindrome = new boolean[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
            isPalindrome[i][i] = true;
        }

        for (int l = 2; l <= s.length(); l++) {
            for (int i = 0; i < s.length(); i++) {
                int j = l + i - 1;
                if (j >= s.length()) {
                    break;
                }
                if (s.charAt(i) != s.charAt(j)) {
                    isPalindrome[i][j] = false;
                } else {
                    if (j - i < 3) {
                        isPalindrome[i][j] = true;
                    } else {
                        isPalindrome[i][j] = isPalindrome[i + 1][j - 1];
                    }
                }
                if (isPalindrome[i][j] && j - i + 1 > maxlength) {
                    maxlength = j - i + 1;
                    begin = i;
                }
            }
        }
        return s.substring(begin, begin + maxlength);
    }
}
