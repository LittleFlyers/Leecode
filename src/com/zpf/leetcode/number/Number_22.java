package com.zpf.leetcode.number;

import com.zpf.leetcode.entry.TreeNode;
import com.zpf.leetcode.util.Execute;
import com.zpf.leetcode.util.Log;

public class Number_22 implements Execute {
    @Override
    public void execute() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        Number_22 number_22 = new Number_22();
        number_22.countNodes(root);
    }

    public int countNodes(TreeNode root) {
        return dfs(root);
    }

    public int dfs(TreeNode root) {
        int leftDeep = getDeep(root, true, 0);
        int rightDeep = getDeep(root, false, 0);
        Log.i("左深度 + 右深度", leftDeep + " " + rightDeep);
        if (leftDeep == rightDeep) {
            return (int) (Math.pow(2, leftDeep) - 1);
        } else {
            return dfs(root.left) + dfs(root.right) + 1;
        }
    }

    public int getDeep(TreeNode root, boolean isLeft, int count) {
        if (root == null) {
            return count;
        } else {
            if (isLeft) {
                return getDeep(root.left, true, count + 1);
            } else {
                return getDeep(root.right, false, count + 1);
            }
        }

    }
}
