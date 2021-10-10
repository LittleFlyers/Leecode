package com.zpf.leetcode.swordFingerOffer;

import com.zpf.leetcode.util.Log;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Number_35 {
    public static class Node {
        int val;
        public Node next;
        public Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public static Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        //原数据加一个头结点
        Node sourceHeadNode = new Node(0);
        sourceHeadNode.next = head;
        //结果数据头结点
        Node resultHeadNode = new Node(0);
        //第一个结点
        Node result = new Node(head.val);
        resultHeadNode.next = result;
        //记录结果节点位置
        Map<Node, Node> resultNodeLocation = new HashMap<>();
        //记录源数据节点所在位置
//        Map<Node, Integer> sourceNodeLocation = new HashMap<>();
        //节点位置
        int i = 0;
        resultNodeLocation.put(head, result);
//        sourceNodeLocation.put(head, i);
        while (head.next != null) {
            i++;
            head = head.next;
            result.next = new Node(head.val);
            result = result.next;
            resultNodeLocation.put(head, result);
//            sourceNodeLocation.put(head, i);
        }
        result = resultHeadNode.next;
        head = sourceHeadNode.next;
        while (head.next != null) {
            if (head.random != null) {
                result.random = resultNodeLocation.get(head.random);
            }
            result = result.next;
            head = head.next;
        }
        if (head.random != null) {
            result.random = resultNodeLocation.get(head.random);
        }
        Log.i("第1个节点", resultHeadNode.next.val + " " + resultHeadNode.next.random.val);
        Log.i("第2个节点", resultHeadNode.next.next.val);
        Log.i("第3个节点", resultHeadNode.next.next.next.val);
        Log.i("第4个节点", resultHeadNode.next.next.next.next.val);
        return resultHeadNode.next;
    }
}
