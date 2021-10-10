package com.zpf.leetcode.hothundred;

public class Hot_Number_215 {
    public int findKthLargest(int[] nums, int k) {
        return dfs(nums, 0, nums.length - 1, k);
    }

    public int dfs(int[] nums, int left, int right, int k) {
        int key = nums[left];
        int i = left;
        int j = right;
        while (i < j) {
            while (nums[j] >= key && i < j) {
                j--;
            }
            nums[i] = nums[j];
            while (nums[i] <= key && i < j) {
                i++;
            }
            nums[j] = nums[i];
        }
        nums[i] = key;
        if (i == nums.length - k) {
            return key;
        } else if (i > nums.length - k) {
            return dfs(nums, left, i - 1, k);
        } else {
            return dfs(nums, i + 1, right, k);
        }
    }
}
