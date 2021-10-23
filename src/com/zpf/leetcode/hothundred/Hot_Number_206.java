package com.zpf.leetcode.hothundred;

import com.zpf.leetcode.util.Execute;

import java.util.ArrayList;
import java.util.List;

public class Hot_Number_206 implements Execute {
    @Override
    public void execute() {

    }

    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        List<ListNode> cache = new ArrayList<>();
        while (head != null) {
            cache.add(head);
            head = head.next;
        }
        for (int i = cache.size() - 1; i > 0; i--) {
            cache.get(i).next = cache.get(i - 1);
        }
        cache.get(0).next = null;
        return cache.get(cache.size() - 1);
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
