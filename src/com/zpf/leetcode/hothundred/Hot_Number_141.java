package com.zpf.leetcode.hothundred;

import com.zpf.leetcode.util.Execute;

public class Hot_Number_141 implements Execute {
    @Override
    public void execute() {

    }

    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }
        if (head.next == null) {
            return false;
        }
        ListNode first = head.next.next;
        ListNode slow = head.next;
        while (first != null && slow != null) {
            if (first == slow) {
                return true;
            } else {
                first = first.next;
                if (first != null && first.next != null) {
                    first = first.next;
                } else {
                    return false;
                }
                slow = slow.next;
            }
        }
        return false;
    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
