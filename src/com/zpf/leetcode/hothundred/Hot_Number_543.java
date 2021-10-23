package com.zpf.leetcode.hothundred;

import com.zpf.leetcode.util.Execute;

public class Hot_Number_543 implements Execute {
    @Override
    public void execute() {

    }

    int result = 1;

    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return result - 1;
    }

    private int dfs(TreeNode treeNode) {
        if (treeNode == null) {
            return 0;
        } else {
            int leftLen = dfs(treeNode.left);
            int rightLen = dfs(treeNode.right);
            result = Math.max(result, leftLen + rightLen + 1);
            return Math.max(leftLen, rightLen) + 1;
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
