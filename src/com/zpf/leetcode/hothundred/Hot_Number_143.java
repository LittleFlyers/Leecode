package com.zpf.leetcode.hothundred;

import com.zpf.leetcode.util.Execute;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.concurrent.locks.LockSupport;

public class Hot_Number_143 implements Execute {
    @Override
    public void execute() {
    }

    public void reorderList(ListNode head) {
        ArrayList<ListNode> cache = new ArrayList<>();
        while(head!=null){
            cache.add(head);
            head = head.next;
        }
        ArrayList<ListNode> result = new ArrayList<>();
        int len = cache.size()/2-1;
        int i = 0;
        int j= cache.size()-1;
        boolean font = true;
        while(result.size()<cache.size()){
            if(font){
                result.add(cache.get(i));
                i++;
                font=false;
            }else{
                result.add(cache.get(j));
                j--;
                font=true;
            }
        }
        for(int l =0;l<result.size();l++){
            if(l<result.size()-1){
                result.get(l).next = result.get(l+1);
            }
        }
        head= result.get(0);
    }

      public class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
      }
}
