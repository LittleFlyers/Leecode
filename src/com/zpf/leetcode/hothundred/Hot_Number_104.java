package com.zpf.leetcode.hothundred;

import com.zpf.leetcode.util.Execute;

public class Hot_Number_104 implements Execute {
    @Override
    public void execute() {

    }

    int result = 0;

    public int maxDepth(TreeNode root) {
        preOrder(root, 0);
        return result;
    }

    public void preOrder(TreeNode root, int len) {
        if (root == null) {
            result = Math.max(result, len);
        } else {
            preOrder(root.left, len + 1);
            preOrder(root.right, len + 1);
        }
    }

    private static class TreeNode {
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
