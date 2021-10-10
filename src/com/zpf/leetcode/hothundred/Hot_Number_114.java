package com.zpf.leetcode.hothundred;

import java.util.ArrayList;
import java.util.List;

public class Hot_Number_114 {
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        List<TreeNode> cache = new ArrayList<>();
        dfs(root, cache);
        for (int i = 0; i < cache.size() - 1; i++) {
            cache.get(i).left = null;
            cache.get(i).right = cache.get(i + 1);
        }
        cache.get(cache.size() - 1).right = null;
        cache.get(cache.size() - 1).left = null;
        root = cache.get(0);
    }

    public void dfs(TreeNode node, List<TreeNode> cache) {
        cache.add(node);
        if (node.left != null) {
            dfs(node.left, cache);
        }
        if (node.right != null) {
            dfs(node.right, cache);
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
