package com.zpf.leetcode;

import java.util.Scanner;

public class RegularExpressionMatching {

    public static boolean isMatch(String s, String p) {
        if (p.isEmpty()) return  s.isEmpty();
        boolean first_match = (!s.isEmpty()&&(s.charAt(0)==p.charAt(0)||p.charAt(0)=='.'));
        if (p.length()>=2&&p.charAt(1)=='*'){
            return (isMatch(s,p.substring(2)))||(first_match&&isMatch(s.substring(1),p));
        }else {
            return first_match&&isMatch(s.substring(1),p.substring(1));
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        do {
            String s = sc.nextLine();
            String p = sc.nextLine();
            System.out.println(isMatch(s, p));
        } while (true);

    }
}
