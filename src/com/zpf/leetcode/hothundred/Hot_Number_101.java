package com.zpf.leetcode.hothundred;

import com.zpf.leetcode.util.Execute;

public class Hot_Number_101 implements Execute {
    @Override
    public void execute() {

    }

    public boolean isSymmetric(TreeNode root) {
        if (root.left == null && root.right == null) {
            return true;
        }
        return check(root.left, root.right);
    }

    public boolean check(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }

        return p.val == q.val && check(p.left, q.right) && check(p.right, q.left);
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
