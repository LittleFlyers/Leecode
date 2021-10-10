package com.zpf.leetcode;

import java.util.Scanner;

public class ContainerWithTheMostWater {

    public static int maxArea(int[] height) {
        int result = 0;
        int i = 0, j = height.length - 1;
        while (i < j) {
            int temp = Math.min(height[i], height[j]) * (j - i);
            result = Math.max(temp, result);
            if (height[i] < height[j]) {
                i++;
            } else {
                j--;
            }

        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        do {
            String s = sc.nextLine();
            String[] strS = s.split(",");
            int[] height = new int[strS.length];
            for (int i = 0; i < strS.length; i++) {
                height[i] = Integer.parseInt(strS[i]);
            }
            System.out.println(maxArea(height));
        } while (true);

    }
}