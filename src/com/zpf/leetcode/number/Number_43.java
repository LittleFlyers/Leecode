package com.zpf.leetcode.number;

/**
 * 字符串相乘
 * 给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
 */
public class Number_43 {
    public static String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        int m = num1.length();
        int n = num2.length();
        int[] result = new int[m + n];
        for (int i = m - 1; i >= 0; i--) {
            int x = num1.charAt(i) - '0';
            for (int j = n - 1; j >= 0; j--) {
                int y = num2.charAt(j) - '0';
                result[i + j + 1] += x * y;
            }
        }
        for (int i = m+m-1;i>0;i--){
            result[i-1] +=result[i]/10;
            result[i] %=10;
        }

        int index = result[0] == 0 ? 1 : 0;
        StringBuffer ans = new StringBuffer();
        while (index<m+n){
            ans.append(result[index]);
            index++;
        }
        return ans.toString();
    }
}
