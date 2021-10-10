package com.zpf.leetcode.swordFingerOffer;

import com.zpf.leetcode.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * 剑指 Offer 36. 二叉搜索树与双向链表
 */
public class Number_36 {

    public void get() {
        Node root = new Node(4);
        root.left = new Node(2);
        root.left.left = new Node(1);
        root.left.right = new Node(3);
        root.right = new Node(5);
        treeToDoublyList(root);
    }

    public Node treeToDoublyList(Node root) {
        List<Node> list = new ArrayList<>();
        dfs(root, list);
        
        for (Node node : list) {
            Log.i("值", node.val);
        }
        return null;
    }

    public void dfs(Node node, List<Node> list) {
        if (node == null) {
            return;
        }
        dfs(node.left, list);
        list.add(node);
        dfs(node.right, list);
    }

    class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    }

    ;
}
