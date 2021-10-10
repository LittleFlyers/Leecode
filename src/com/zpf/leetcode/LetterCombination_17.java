package com.zpf.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LetterCombination_17 {
    String[] digits2String = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    List<String> ans = new ArrayList<>();
    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) return ans;
        StringBuilder sb = new StringBuilder();
        char[] digitStr = digits.toCharArray();
        combineDigits(sb, digitStr, 0);
        return ans;
    }

    public void combineDigits(StringBuilder sb, char[] digitStr, int k) {
        // 当当前位置超出界限，则将sb加入ans中，并返回
        if (k == digitStr.length) {
            ans.add(sb.toString());
            return;
        }
        int digit = digitStr[k] - '0';
        char[] str = digits2String[digit].toCharArray();
        // 遍历当前位置数字对应的所有字符，并递归。
        // 此处即为回溯。
        // 回溯后需要删除当前位置添加的字符，并加入此位置对应的下一个字符继续递归
        for (char c : str) {
            sb.append(c);
            combineDigits(sb, digitStr, k + 1);
            sb.deleteCharAt(k);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        do {
            String s = sc.nextLine();
            System.out.println(new LetterCombination_17().letterCombinations(s));
        } while (true);

    }
}
