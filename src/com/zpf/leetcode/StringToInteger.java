package com.zpf.leetcode;

import java.util.Scanner;

public class StringToInteger {
    public static int myAtoi(String str) {
        int result = 0;
        boolean isStart = false;
        boolean isFu = false;
        StringBuffer temp = new StringBuffer();
        for (char c : str.toCharArray()) {
            if (Character.isDigit(c)) {
                isStart = true;
                temp.append(c);
            } else if (c == '-' && !isStart) {
                isFu = true;
                isStart = true;
            }else if (c == '+' && !isStart) {
                isStart = true;
            } else if (c == ' ' && !isStart) {
                continue;
            } else {
                break;
            }
        }
        String tempStr = String.valueOf(temp);
        if (tempStr.equals('-')||tempStr.length()==0) return result;
        if (isInt(tempStr)) {
            if (isFu) {
                result = -Integer.parseInt(tempStr);
            }else {
                result = Integer.parseInt(tempStr);
            }
        }else {
            if (isFu){
                return -2147483648;
            }else {
                return 2147483647;
            }
        }
        return result;
    }
    private static boolean isInt(String val) {
        try {
            Integer.parseInt(val);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        do{
            String input = sc.nextLine();
            System.out.println(myAtoi(input));
        }while (true);

    }
}
