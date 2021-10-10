package com.zpf.leetcode.swordFingerOffer;

import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 剑指 Offer 34. 二叉树中和为某一值的路径
 * <p>
 * 输入一棵二叉树和一个整数，打印出二叉树中节点值的和为输入整数的所有路径。从树的根节点开始往下一直到叶节点所经过的节点形成一条路径。
 * <p>
 * <p>
 * 示例:
 * 给定如下二叉树，以及目标和target = 22，
 * <p>
 * 5
 * / \
 * 4   8
 * /   / \
 * 11  13  4
 * /  \    / \
 * 7    2  5   1
 * 返回:
 * <p>
 * [
 * [5,4,11,2],
 * [5,8,4,5]
 * ]
 */

public class Number_34 {
    public List<List<Integer>> pathSum(TreeNode root, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> cache = new ArrayList<>();
        dfs(root, 0, target, result, cache);
        return result;
    }

    public void dfs(TreeNode node, int pathData, int target, List<List<Integer>> result, List<Integer> cache) {
        if (node != null) {
            pathData += node.val;
            if (pathData == target && node.left == null && node.right == null) {
                cache.add(node.val);
                List<Integer> onePath = new ArrayList<>(cache);
                result.add(onePath);
                cache.remove(cache.size() - 1);
            }else {
                cache.add(node.val);
                dfs(node.left, pathData, target, result, cache);
                dfs(node.right, pathData, target, result, cache);
                cache.remove(cache.size() - 1);
            }
        }
    }

    class TreeNode {
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
