package com.zpf.leetcode.number;

import com.zpf.leetcode.util.Log;

/**
 * 67. 二进制求和
 * <p>
 * 给你两个二进制字符串，返回它们的和（用二进制表示）。
 * <p>
 * 输入为 非空 字符串且只包含数字 1 和 0。
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: a = "11", b = "1"
 * 输出: "100"
 * 示例 2:
 * <p>
 * 输入: a = "1010", b = "1011"
 * 输出: "10101"
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-binary
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Number_67 {
    public static String addBinary(String a, String b) {
/*        int m = Integer.parseInt(a);
        int n = Integer.parseInt(b);*/
/*        String[] m = a.split("");
        String[] n = b.split("");*/
        StringBuffer result = new StringBuffer();
        int carry = 0;
        int maxLen = Math.max(a.length(), b.length());
        int difference = Math.abs((a.length() - b.length()));
        Log.i("长度差", difference);
        Log.i("最长", maxLen);
        for (int i = maxLen - 1; i >= 0; i--) {
            int temp = 0;
            Log.i("小", i - difference);
            if (i - difference >= 0) {
                temp = a.length() > b.length() ?
                        (Integer.parseInt(String.valueOf(a.charAt(i))) + Integer.parseInt(String.valueOf(b.charAt(i - difference)))) :
                        (Integer.parseInt(String.valueOf(a.charAt(i - difference))) + Integer.parseInt(String.valueOf(b.charAt(i))));
            } else {
                temp = a.length() > b.length() ?
                        Integer.parseInt(String.valueOf(a.charAt(i))) :
                        Integer.parseInt(String.valueOf(b.charAt(i)));
            }
            temp += carry;
            int teal = 0;
            if (temp == 3) {
                carry = 1;
                teal = 1;
            } else if (temp == 2) {
                carry = 1;
            } else {
                teal = temp;
                carry = 0;
            }
            result.insert(0, teal);
        }
        if (carry == 1) {
            result.insert(0, 1);
        }
        return String.valueOf(result);
    }
}
