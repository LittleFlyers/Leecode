package com.zpf.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ParenthesisGeneration_22 {
    
    public static List<String> generate(int n) {
        List<String> ans = new ArrayList<>();
        if (n == 0) {
            ans.add("");
        } else {
            for (int i = 0; i < n; ++i) {
                for (String left : generate(i)) {
                    for (String right : generate(n - i - 1)) {
                        ans.add("(" + left + ")" + right);
                    }
                }
            }
        }
        return ans;
    }

    public static List<String> generateParenthesis(int n) {
        return generate(n);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        do {
            String s = sc.nextLine();
            System.out.println(generateParenthesis(Integer.parseInt(s)));
        } while (true);

    }
}
