package com.zpf.leetcode;

import com.zpf.leetcode.util.Log;

import java.util.Scanner;

public class NextArrangement_31 {

    public static int[] nextPermutation(int[] nums) {
        int i = nums.length - 2;
        while (i >= 0 && nums[i + 1] <= nums[i]) {
            i--;
        }
        if (i >= 0) {
            int j = nums.length - 1;
            while (j>=0&&nums[j]<=nums[i]){
                j--;
            }
            Log.i("NextArrangement_31",nums[j]);
            Log.i("NextArrangement_31",nums[i]);
            swap(nums,i,j);
            Log.i("NextArrangement_31",nums);
        }
        reverse(nums,i+1);
        return nums;
    }
    private static void reverse(int[] nums, int start) {
        int i = start, j = nums.length - 1;
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        do {
            String s = sc.nextLine();
            String[] t = s.split(" ");
            int[] d = new int[t.length];
            for (int i = 0; i < t.length; i++) {
                d[i] = Integer.parseInt(t[i]);
            }
            Log.i("NextArrangement_31",nextPermutation(d));
        } while (true);

    }
}
