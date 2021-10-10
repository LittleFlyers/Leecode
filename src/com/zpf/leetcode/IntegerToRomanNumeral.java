package com.zpf.leetcode;

import java.util.Scanner;

public class IntegerToRomanNumeral {

    public static String intToRoman(int num) {
        String result = "";
        while (num != 0) {
            if (num >= 1000) {
                num -= 1000;
                result += "M";
                continue;
            } else if (num >= 900) {
                num -= 900;
                result += "CM";
                continue;
            } else if (num >= 500) {
                num -= 500;
                result += "D";
                continue;
            } else if (num >= 400) {
                num -= 400;
                result += "CD";
                continue;
            } else if (num >= 100) {
                num -= 100;
                result += "C";
                continue;
            } else if (num >= 90) {
                num -= 90;
                result += "XC";
                continue;
            } else if (num >= 50) {
                num -= 50;
                result += "L";
                continue;
            } else if (num >= 40) {
                num -= 40;
                result += "XL";
                continue;
            } else if (num >= 10) {
                num -= 10;
                result += "X";
                continue;
            } else if (num >= 9) {
                num -= 9;
                result += "IX";
                continue;
            } else if (num >= 5) {
                num -= 5;
                result += "V";
                continue;
            } else if (num >= 4) {
                num -= 4;
                result += "IV";
                continue;
            } else {
                num--;
                result += "I";
            }
        }
        return result;
    }

    //贪心算法
    public String intToRoman1(int num) {
        // 把阿拉伯数字与罗马数字可能出现的所有情况和对应关系，放在两个数组中
        // 并且按照阿拉伯数字的大小降序排列，这是贪心选择思想
        int[] nums = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] romans = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        StringBuilder stringBuilder = new StringBuilder();
        int index = 0;
        while (index < 13) {
            // 特别注意：这里是等号
            while (num >= nums[index]) {
                // 注意：这里是等于号，表示尽量使用大的"面值"
                stringBuilder.append(romans[index]);
                num -= nums[index];
            }
            index++;
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        do {
            String s = sc.nextLine();
            System.out.println(intToRoman(Integer.parseInt(s)));
        } while (true);

    }
}
