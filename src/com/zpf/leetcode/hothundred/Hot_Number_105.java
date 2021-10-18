package com.zpf.leetcode.hothundred;

import com.zpf.leetcode.util.Execute;
import com.zpf.leetcode.util.Log;

import java.util.HashMap;
import java.util.Map;

public class Hot_Number_105 implements Execute {
    @Override
    public void execute() {
        int[] pre = {3,9,20,15,7};
        int[] ind = {9,3,15,20,7};
        buildTree(pre,ind);
    }

    Map<Integer, Integer> cache;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int len = preorder.length;
        cache = new HashMap<>();
        for (int i = 0; i < len; i++) {
            cache.put(inorder[i], i);
        }
        return dfsBuild(preorder, inorder, 0, len - 1, 0, len - 1);
    }

    public TreeNode dfsBuild(int[] preorder, int[] inorder, int preStart, int preEnd, int inStart, int inEnd) {
        if (inStart > inEnd) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[preStart]);
        int index = cache.get(preorder[preStart]);
        int leftLen = index - inStart;
        Log.i("定位",index);
        Log.i("左边长",leftLen);

        root.left = dfsBuild(preorder, inorder, preStart + 1, preStart + leftLen, inStart, index - 1);
        root.right = dfsBuild(preorder, inorder, preStart + leftLen + 1, preEnd, index + 1, inEnd);
        return root;
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
