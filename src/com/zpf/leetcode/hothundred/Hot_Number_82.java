package com.zpf.leetcode.hothundred;

import com.zpf.leetcode.util.Execute;

import java.util.LinkedHashSet;

public class Hot_Number_82 implements Execute {
    @Override
    public void execute() {

    }

    public ListNode deleteDuplicates(ListNode head) {
        LinkedHashSet<Integer> linkedHashSet = new LinkedHashSet<>();
        ListNode check = null;
        while (head != null) {
            if (linkedHashSet.contains(head.val)) {
                check = head;
            } else {
                if (check != null) {
                    linkedHashSet.remove(check.val);
                    check = null;
                }
                linkedHashSet.add(head.val);
            }
            head = head.next;
        }
        if (check != null) {
            linkedHashSet.remove(check.val);
            check = null;
        }
        ListNode result = new ListNode();
        ListNode resultHead = new ListNode();
        result.next = resultHead;
        for (Integer i : linkedHashSet) {
            resultHead.next = new ListNode(i);
            resultHead = resultHead.next;
        }
        return result.next.next;
    }

    public class ListNode {
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
