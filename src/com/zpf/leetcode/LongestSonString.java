package com.zpf.leetcode;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class LongestSonString {
    public static int lengthOfLongestSubstring(String s) {
        int result = 0;
        int n = s.length();
        int i = 0;
        int j = 0;
        Set<Character> sets = new HashSet<>();
        while (i < n && j < n) {
            if (!sets.contains(s.charAt(j))){
                sets.add(s.charAt(j++));
                result = Math.max(result,j-i);
            }else {
                sets.remove(s.charAt(i++));
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        System.out.println(lengthOfLongestSubstring(input));
    }

}
