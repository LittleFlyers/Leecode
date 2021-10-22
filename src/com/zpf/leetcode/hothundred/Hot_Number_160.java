package com.zpf.leetcode.hothundred;

import com.zpf.leetcode.util.Execute;

import java.util.HashSet;
import java.util.Set;

public class Hot_Number_160 implements Execute {
    @Override
    public void execute() {

    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> listNodeSet = new HashSet<>();
        while (headA != null) {
            listNodeSet.add(headA);
            headA = headA.next;
        }

        while (headB != null) {
            if (listNodeSet.contains(headB)) {
                return headB;
            } else {
                headB = headB.next;
            }
        }
        return null;
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
