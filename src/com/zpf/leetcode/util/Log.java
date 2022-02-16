package com.zpf.leetcode.util;

import java.util.List;

public class Log {
    public static void i(String s) {
        System.out.println(s);
    }

    public static void i(String TAG, String s) {
        System.out.println(TAG + ":" + s);
    }

    public static void i(String TAG, double s) {
        System.out.println(TAG + ":" + s);
    }

    public static void i(String TAG, int s) {
        System.out.println(TAG + ":" + s);
    }

    public static void i(String TAG, long s) {
        System.out.println(TAG + ":" + s);
    }

    public static void i(String TAG, boolean s) {
        System.out.println(TAG + ":" + s);
    }

    public static void i(String TAG, int[] s) {
        System.out.print(TAG + ":");
        for (int a : s) {
            System.out.print(" " + a);
        }
        System.out.println("");
    }

    public static void i(String TAG, int[][] s) {
        System.out.println(TAG + ":");
        for (int i = 0; i < s.length; i++) {
            for (int j = 0; j < s[0].length; j++) {
                System.out.print(s[i][j] + " ");
            }
            System.out.println("");
        }
        System.out.println("");
    }

    public static void i(String TAG, List<List<Integer>> list) {
        System.out.println(TAG + ": ");
        for (List<Integer> root : list) {
            for (Integer data : root) {
                System.out.print(data + " ");
            }
            System.out.println("");
        }
    }
}
