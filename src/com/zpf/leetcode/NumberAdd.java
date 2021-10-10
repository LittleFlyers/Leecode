package com.zpf.leetcode;

import javax.sql.rowset.spi.SyncResolver;
import java.util.Scanner;

public class NumberAdd {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode resultH = null;
        ListNode resultN = null;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int data1 = 0;
            int data2 = 0;
            if (l1 != null) {
                data1 = l1.val;
                System.out.println(data1);
                l1 = l1.next;
            }
            if (l2 != null) {
                data2 = l2.val;
                System.out.println(data2);
                l2 = l2.next;
            }
            int result = data1 + data2 + carry;
            carry = result / 10;
            int remainder = result % 10;
            if (resultH == null) {
                resultH = new ListNode(remainder);
                resultN = resultH;
            } else {
                resultN.next = new ListNode(remainder);
                resultN = resultN.next;
            }
        }
        if (carry!=0){
            resultN.next = new ListNode(carry);
        }
        return resultH;
    }

    private static void logList(ListNode ls) {
        String result = "";
        do {
            result += ls.val + " -> ";
            ls = ls.next;
        } while (ls != null);
        System.out.println(result);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        input = input.replaceAll("\\(|\\)", "");
        String[] strings = input.split("[+]");
        String[] lStr1 = strings[0].split("->");
        String[] lStr2 = strings[1].split("->");
        ListNode l1h = null;
        ListNode l2h = null;
        ListNode l1n = null;
        ListNode l2n = null;
        for (String node : lStr1) {
            if (l1h == null) {
                l1h = new ListNode(Integer.valueOf(node));
                l1n = l1h;
            } else {
                l1n.next = new ListNode(Integer.valueOf(node));
                l1n = l1n.next;
            }
        }

        for (String node : lStr2) {
            if (l2h == null) {
                l2h = new ListNode(Integer.valueOf(node));
                l2n = l2h;
            } else {
                l2n.next = new ListNode(Integer.valueOf(node));
                l2n = l2n.next;
            }
        }
        logList(l1h);
        logList(l2h);
        logList(addTwoNumbers(l1h, l2h));
    }
}
