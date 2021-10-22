package com.zpf.leetcode.hothundred;

import com.zpf.leetcode.util.Execute;

import java.util.ArrayList;
import java.util.List;

public class Hot_Number_94 implements Execute {
    @Override
    public void execute() {
        TreeNode treeNode = new TreeNode(1);
        treeNode.right = new TreeNode(2);
        treeNode.right.left = new TreeNode(3);
        inorderTraversal(treeNode);
    }

    List<Integer> result = new ArrayList<>();

    public List<Integer> inorderTraversal(TreeNode root) {
        inOrder(root);
        return result;
    }

    public void inOrder(TreeNode root) {
        if (root != null) {
            inOrder(root.left);
            result.add(root.val);
            inOrder(root.right);
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
