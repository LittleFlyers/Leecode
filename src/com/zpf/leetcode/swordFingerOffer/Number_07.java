package com.zpf.leetcode.swordFingerOffer;

import com.zpf.leetcode.util.Log;

public class Number_07 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        TreeNode root = new TreeNode(preorder[0]);
        dfs(root, preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
        return root;

    }

    public static void dfs(TreeNode root, int[] preorder, int[] inorder, int preLeft, int preRight, int inLeft, int inRight) {
        Log.i("preLeft", preLeft);
        Log.i("preRight", preRight);
        Log.i("inLeft", inLeft);
        Log.i("inRight", inRight);
        if (preLeft < 0 || preRight >= preorder.length || inLeft < 0 || inRight >= inorder.length) {
            return;
        }
        int inRoot = get(inorder, inLeft, inRight, preorder[preLeft]);

        if (inRoot < 0) {
            return;
        }
        Log.i("中序根节点", inRoot + " 值：" + root.val);
        if (inRoot - 1 >= inLeft) {
            TreeNode leftChild = new TreeNode(preorder[preLeft + 1]);
            root.left = leftChild;
            Log.i("左节点", preLeft + " 值：" + leftChild.val);
            dfs(leftChild, preorder, inorder, preLeft + 1, preLeft + inRoot - inLeft, inLeft, inRoot - 1);
        }
        Log.i("中序根节点", inRoot + " 值：" + root.val);
        if (inRoot + 1 <= inRight) {
            int a = inRoot - inLeft + preLeft + 1;
            TreeNode rightChild = new TreeNode(preorder[a]);
            root.right = rightChild;
            int rightA = get(preorder, preLeft, preRight, rightChild.val);
            Log.i("右节点", a + " 值：" + rightChild.val);
            dfs(rightChild, preorder, inorder, rightA, preRight, inRoot + 1, inRight);
        }
    }

    public static int get(int[] root, int start, int end, int value) {
        for (int i = start; i <= end; i++) {
            if (root[i] == value) {
                return i;
            }
        }
        return -1;
    }
}
