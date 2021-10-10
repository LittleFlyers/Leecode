package com.zpf.leetcode.hothundred;

import java.util.HashSet;

public class Hot_Number_142 {
    public ListNode detectCycle(ListNode head) {
        HashSet<ListNode> ca = new HashSet<>();
        ListNode ls = head;
        while (ls.next!=null){
            if (ca.contains(ls)){
                return ls;
            }else {
                ca.add(ls);
                ls = ls.next;
            }
        }
        return null;
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
