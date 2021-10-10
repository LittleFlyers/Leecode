package com.zpf.leetcode;

import java.util.Scanner;

public class DeleteThePenultimateNthNodeOfTheLinkedList_19 {
      public static class ListNode {
          int val;
          ListNode next;
          ListNode(int x) { val = x; }
      }
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode first = dummy;
        ListNode second = dummy;
        // Advances first pointer so that the gap between first and second is n nodes apart
        for (int i = 1; i <= n + 1; i++) {
            first = first.next;
        }
        // Move first to the end, maintaining the gap
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        return dummy.next;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        do {
            String s = sc.nextLine();
            String[] strS = s.split(",");

        } while (true);

    }
}
