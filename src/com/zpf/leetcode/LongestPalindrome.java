package com.zpf.leetcode;

import java.util.Scanner;

public class LongestPalindrome {
    public static String longestPalindrome(String s) {
        String result = "";
        int i = 0;
        int n = s.length();
        while (i < n) {
            String temp = "";
            for (int j = 0; i - j >= 0 && i + j < n; j++) {
                if (s.charAt(i - j) != s.charAt(i + j)) {
                    break;
                } else {
                    temp = s.substring(i - j, i + j + 1);
                    if (temp.length() > result.length()) {
                        result = temp;
                    }
                }
            }
            if (i < n - 1 && s.charAt(i) == s.charAt(i + 1)) {
                for (int j = 0; i - j >= 0 && i + j + 1 < n; j++) {
                    if (s.charAt(i - j) != s.charAt(i + j + 1)) {
                        break;
                    } else {
                        temp = s.substring(i - j, i + j + 2);
                        if (temp.length() > result.length()) {
                            result = temp;
                        }
                    }
                }
            }
            i++;
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        System.out.println(longestPalindrome(input));
    }
}
