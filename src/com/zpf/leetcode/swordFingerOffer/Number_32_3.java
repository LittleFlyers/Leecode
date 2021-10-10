package com.zpf.leetcode.swordFingerOffer;

import com.zpf.leetcode.util.Log;

import java.util.*;

/**
 * 剑指 Offer 32 - III. 从上到下打印二叉树 III
 * <p>
 * 请实现一个函数按照之字形顺序打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右到左的顺序打印，第三行再按照从左到右的顺序打印，其他行以此类推。
 * <p>
 * <p>
 * <p>
 * 例如:
 * 给定二叉树:[3,9,20,null,null,15,7],
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回其层次遍历结果：
 * <p>
 * [
 * [3],
 * [20,9],
 * [15,7]
 * ]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-iii-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Number_32_3 {
    public static List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        int level = 1;
        int levelCount = 1;
        List<List<Integer>> result = new ArrayList<>();
        Stack<TreeNode> oddStackLevelCache = new Stack<>();
        Stack<TreeNode> evenStackLevelCache = new Stack<>();
        oddStackLevelCache.add(root);
        List<Integer> a = new ArrayList<>();
        a.add(root.val);
        result.add(a);
        while (levelCount > 0) {
            List<Integer> levelData = new ArrayList<>();
            int nextLevelCount = 0;
            Log.i("本层节点数", levelCount);
            for (int i = 0; i < levelCount; i++) {
                TreeNode node;
                if (level % 2 == 1) {
                    node = oddStackLevelCache.pop();
                }else {
                    node = evenStackLevelCache.pop();
                }

                Log.i("节点遍历", level + "层 " + node.val);
                if (level % 2 == 1) {
                    if (node.right != null) {
                        Log.i("进栈节点", node.right.val);
                        evenStackLevelCache.add(node.right);
                        levelData.add(node.right.val);
                        nextLevelCount++;
                    }
                    if (node.left != null) {
                        Log.i("进栈节点", node.left.val);
                        evenStackLevelCache.add(node.left);
                        levelData.add(node.left.val);
                        nextLevelCount++;
                    }

                } else {
                    if (node.left != null) {
                        Log.i("进栈节点", node.left.val);
                        oddStackLevelCache.add(node.left);
                        levelData.add(node.left.val);
                        nextLevelCount++;
                    }
                    if (node.right != null) {
                        Log.i("进栈节点", node.right.val);
                        oddStackLevelCache.add(node.right);
                        levelData.add(node.right.val);
                        nextLevelCount++;
                    }
                }
            }
            if (levelData.size() != 0) {
                result.add(levelData);
            }
            levelCount = nextLevelCount;
            level++;
        }

        return result;
    }

    public static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int x) {
            val = x;
        }
    }


}
