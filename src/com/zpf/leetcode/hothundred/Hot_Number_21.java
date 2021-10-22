package com.zpf.leetcode.hothundred;

import com.zpf.leetcode.util.Execute;
import com.zpf.leetcode.util.Log;

public class Hot_Number_21 implements Execute {
    @Override
    public void execute() {
        ListNode a = new ListNode(1);
        a.next = new ListNode(2);
        a.next.next = new ListNode(4);
        ListNode b = new ListNode(1);
        b.next = new ListNode(3);
        b.next.next = new ListNode(4);
        mergeTwoLists(a, b);
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        ListNode head = new ListNode(0);
        result.next = head;
        while (l1 != null || l2 != null) {
            if (l1 == null) {
                Log.i("", " l2: " + l2.val);
                head.next = l2;
                head = head.next;
                l2 = l2.next;
            } else if (l2 == null) {
                Log.i("", "l1: " + l1.val);
                head.next = l1;
                head = head.next;
                l1 = l1.next;
            } else {
                Log.i("", "l1: " + l1.val + " l2: " + l2.val);
                if (l1.val >= l2.val) {
                    head.next = l2;
                    head = head.next;
                    l2 = l2.next;
                } else {
                    head.next = l1;
                    head = head.next;
                    l1 = l1.next;
                }
            }
            Log.i("", "head: " + head.val);
        }
        return result.next.next;
    }


    private static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
