package com.zpf.leetcode.hothundred;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Hot_Number_102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> cache = new LinkedList<>();
        cache.add(root);
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        while (cache.size() != 0) {
            int count = cache.size();
            List<Integer> levelResult = new ArrayList<>();
            for (int i = 0; i < count; i++) {
                TreeNode temp = cache.poll();
                levelResult.add(temp.val);
                if (temp.left != null) {
                    cache.add(temp.left);
                }
                if (temp.right != null) {
                    cache.add(temp.right);
                }
            }
            result.add(levelResult);
        }
        return result;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
