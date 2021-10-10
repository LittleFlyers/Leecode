package com.zpf.leetcode;

public class Number_34 {


    public int getLeft(int[] nums,int target,boolean left){
        int le = 0;
        int ri = nums.length;
        while (le<ri){
            int mid = (le+ri)/2;
            if (nums[mid]>target||(left&&nums[mid]==target)){
                ri=mid;
            }else {
                le = mid+1;
            }
        }

        return le;
    }

    public int[] searchRange(int[] nums, int target) {
        int[] result = {-1, -1};
        int left = getLeft(nums,target,true);
        if (left == nums.length||nums[left] != target)return result;
        result[0] = left;
        result[1] = getLeft(nums,target,false)-1;
        return result;
    }
}
