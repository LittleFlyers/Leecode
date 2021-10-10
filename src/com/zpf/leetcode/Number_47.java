package com.zpf.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/***
 * 给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
 * */
public class Number_47 {
    boolean[] vis;

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        List<Integer> perm = new ArrayList<Integer>();
        Arrays.sort(nums);
        vis = new boolean[nums.length];
        backtrack(ans,nums,0,perm);
        return ans;
    }

    public void backtrack(List<List<Integer>> ans, int[] nums, int idx, List<Integer> perm) {
        if (idx == nums.length) {
            ans.add(new ArrayList<>(perm));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (vis[i] || (i > 0 && nums[i] == nums[i - 1] && !vis[i - 1])) {
                continue;
            }
            perm.add(nums[i]);
            vis[i] = true;
            backtrack(ans, nums, idx + 1, perm);
            vis[i] = false;
            perm.remove(idx);
        }
    }
}
