package com.zpf.leetcode;

import com.zpf.leetcode.util.Log;

import java.util.Scanner;
import java.util.Stack;

public class LongestValidBracket_32 {

    private static final String TAG = "LongestValidBracket_32";

    public static int longestValidParentheses(String s) {
        int result = 0;
        int temp = 0;
        int head = 0;
        boolean hasS = false;
        char[] a = s.toCharArray();
        Stack<Character> k = new Stack<>();
        for (int i = 0; i < a.length; i++) {
            if (a[i] == ')') {
                if (k.empty()) {
                    if (temp >= result) result = temp;
                    temp = 0;
                    head = 0;
                    k.clear();
                } else {
                    k.pop();
                    temp += 2;
                    head = temp;
                }
            } else {
                if (k.empty()) {
                    if (temp >= result) result = temp;
                }
                k.push('(');
            }
            Log.i(TAG,head + " " +temp);
            if (i==a.length-1&&!k.empty()){
                temp -= head;
            }
        }
        if (temp >= result) result = temp;
        return result;
    }
    public static int longestValidParentheses1(String s) {
        int maxans = 0;
        int dp[] = new int[s.length()];
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i - 1) == '(') {
                    dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
                    Log.i(TAG,"1:" + dp[i]);
                } else if (i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                    dp[i] = dp[i - 1] + ((i - dp[i - 1]) >= 2 ? dp[i - dp[i - 1] - 2] : 0) + 2;
                    Log.i(TAG,"2:" + dp[i]);
                }
                maxans = Math.max(maxans, dp[i]);
            }
        }
        return maxans;
    }

    public int longestValidParentheses_use_stack(String s) {
        int maxans = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.empty()) {
                    stack.push(i);
                } else {
                    maxans = Math.max(maxans, i - stack.peek());
                }
            }
        }
        return maxans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        do {
            String s = sc.nextLine();
            Log.i(TAG, longestValidParentheses1(s));
        } while (true);

    }
}
