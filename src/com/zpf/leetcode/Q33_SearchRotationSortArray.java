package com.zpf.leetcode;

import com.zpf.leetcode.util.Log;

import java.util.Scanner;

public class Q33_SearchRotationSortArray {
    static final String TAG = "Q33_SearchRotationSortArray";

    public static int search(int[] nums, int target) {

        int result = -1;
        int l = 0;
        int r = nums.length - 1;
        while (l <= r) {
            int mid = (r + l) /2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[0] < nums[mid]) {
                if (nums[0] <= target && target <= nums[mid]) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            }else {
                if (nums[mid] <= target && target <= nums[nums.length-1]) {

                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
        }
        return result;
    }

    //二分法
    public static int search1(int[] nums, int target) {
        int lo = 0, hi = nums.length - 1, mid = 0;
        while (lo <= hi) {
            mid = lo + ((hi - lo) >> 1);
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] < target) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
            Log.i(TAG, lo + " " + hi);
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        do {
            String s = sc.nextLine();
            String[] t = s.split(",");
            int[] d = new int[t.length - 1];
            for (int i = 0; i < t.length - 1; i++) {
                d[i] = Integer.parseInt(t[i]);
            }
            Log.i(TAG, "result:" + search(d, Integer.parseInt(t[t.length - 1])));
        } while (true);

    }
}
