package com.zpf.leetcode.swordFingerOffer;

import com.zpf.leetcode.util.Log;
/**
 *
 * 使用递归分治的方式解题。
 * 二叉搜索树的特点是节点的左子树的节点值都小于节点值，节点的右子树节点值都大于节点值。
 * 二叉树后续遍历的特点是最后遍历根节点。
 * 根据这两个属性可以知道，数组中最后一个值则是根节点。左子树是小于根节点的值，遍历数组，直到有值大于根节点。说明该节点的左侧都是小于根节点的左子树，该节点及右侧都是大于根节点的右子树，判断一下右子树的值是否大于根节点，如果有小于的，返回false。
 * 再递归的判断左子树和右子数。
 * */
public class Number_33 {
    public boolean verifyPostorder(int[] postorder) {
        return aBoolean(postorder, 0, postorder.length - 1);
    }

    public boolean aBoolean(int[] postOrder, int start, int end) {
        if (end - start <= 1) {
            return true;
        }
        int root = postOrder[end];
        Log.i("节点值：", root);
        int divide = start;
        for (int i = start; i < end; i++) {
            if (postOrder[i] < root) {
                divide++;
            } else {
                break;
            }
        }
        Log.i("分割值：", divide);
/*        if (!isItLessThan(postOrder, start, divide - 1, root)) {
            Log.i("左子树：", false);
            return false;
        }*/
        if (!isItGreaterThan(postOrder, divide, end - 1, root)) {
            Log.i("右子树：", false);
            return false;
        }
        boolean left = aBoolean(postOrder, start, divide - 1);
        boolean right = aBoolean(postOrder, divide, end - 1);
        return left && right;
    }

    public boolean isItGreaterThan(int[] postOrder, int start, int end, int key) {
        Log.i("右子树比较：", start + " " + end + " " + key);
        if (end - start < 1) {
            return true;
        }
        for (int i = start; i <= end; i++) {
            Log.i("右子树节点比较：", postOrder[i] + " " + key);
            if (postOrder[i] < key) {
                Log.i("右子树比较：", false);
                return false;
            }
        }
        return true;
    }

    public boolean isItLessThan(int[] postOrder, int start, int end, int key) {
        if (end - start < 1) {
            return true;
        }
        for (int i = start; i <= end; i++) {
            if (postOrder[i] > key) {
                return false;
            }
        }
        return true;
    }
}
