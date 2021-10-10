package com.zpf.leetcode.hothundred;

import com.zpf.leetcode.util.Log;

public class Hot_Number_98 {
    public void get() {
        TreeNode root = new TreeNode(-2147483648);
        root.right = new TreeNode(2147483647);
        isValidBST(root);
    }

    public boolean isValidBST(TreeNode root) {
        boolean result = dfs(root, Long.MAX_VALUE, Long.MIN_VALUE);
        return result;
    }

    public boolean dfs(TreeNode node, long max, long min) {
        if (node.left == null && node.right == null) {
            return true;
        } else if (node.left == null) {
            if (node.val < node.right.val && node.right.val > min && node.right.val < max) {
                return dfs(node.right, max, node.val);
            } else {
                return false;
            }
        } else if (node.right == null) {
            if (node.val > node.left.val && node.left.val < max && node.left.val > min) {
                return dfs(node.left, node.val, min);
            } else {
                return false;
            }
        } else {
            if (node.val > node.left.val && node.left.val < max && node.left.val > min
                    && node.val < node.right.val && node.right.val > min && node.right.val < max) {
                return dfs(node.left, node.val, min) && dfs(node.right, max, node.val);
            } else {
                return false;
            }
        }
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
