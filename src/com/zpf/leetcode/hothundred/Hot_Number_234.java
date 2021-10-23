package com.zpf.leetcode.hothundred;

import com.zpf.leetcode.util.Execute;

import java.util.ArrayList;
import java.util.List;

public class Hot_Number_234 implements Execute {
    @Override
    public void execute() {

    }

    public boolean isPalindrome(ListNode head) {
        List<ListNode> cache = new ArrayList<>();
        while (head != null) {
            cache.add(head);
            head = head.next;
        }
        int i = 0;
        int j = cache.size() - 1;
        while (i <= j) {
            if (cache.get(i).val == cache.get(j).val) {
                i++;
                j--;
            } else {
                return false;
            }
        }
        return true;
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
