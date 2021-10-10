package com.zpf.leetcode.hothundred;

import java.util.ArrayList;
import java.util.List;

public class Hot_Number_148 {
    public ListNode sortList(ListNode head) {
        return dfs(head, null);
    }

    public ListNode dfs(ListNode head, ListNode tail) {
        if (head == null) {
            return head;
        }

        if (head.next == tail) {
            head.next = null;
            return head;
        }

        ListNode slow = head;
        ListNode fast = head;
        while (fast != tail) {
            slow = slow.next;
            fast = fast.next;
            if (fast != tail) {
                fast = fast.next;
            }
        }
        ListNode mid = slow;
        ListNode left = dfs(head, mid);
        ListNode right = dfs(mid, tail);
        return merge(left, right);
    }

    public ListNode merge(ListNode left, ListNode right) {
        ListNode resultHead = new ListNode(0);
        List<ListNode> list = new ArrayList<>();
        while (left != null || right != null) {
            if (left == null) {
                list.add(right);
                right = right.next;
            } else if (right == null) {
                list.add(left);
                left = left.next;
            } else {
                if (left.val < right.val) {
                    list.add(left);
                    left = left.next;
                } else {
                    list.add(right);
                    right = right.next;
                }
            }
        }

        resultHead.next = list.get(0);
        for (int i = 0; i < list.size() - 1; i++) {
            list.get(i).next = list.get(i + 1);
        }
        list.get(list.size() - 1).next = null;
        return resultHead.next;
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
