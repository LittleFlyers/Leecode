package com.zpf.leetcode.swordFingerOffer;

import com.zpf.leetcode.util.Log;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 剑指 Offer 45. 把数组排成最小的数
 * <p>
 * 输入一个非负整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [10,2]
 * 输出: "102"
 * 示例 2:
 * <p>
 * 输入: [3,30,34,5,9]
 * 输出: "3033459"
 *
 * 这道题不是很理解呀 ！！！！！！！！！！！！！！！！！！！！！！
 */
public class Number_45 {
    public void get() {
        int[] input = {121, 12};
        minNumber(input);
    }


    public String minNumber(int[] nums) {
        Queue<String> queue = new PriorityQueue<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                //字典序列小的放在堆顶
                return (o1 + o2).compareTo(o2 + o1);
            }
        });
        for (int num : nums) {
            queue.add("" + num);
        }
        StringBuilder res = new StringBuilder();
        while (! queue.isEmpty()){
            res.append(queue.poll());
        }
        return res.toString();
    }

    private int getNumLength(int num) {
        if (num < 10) {
            return 1;
        }
        return (int) Math.log10(num) + 1;
    }

    private int getMin(double[] dataProcessing, int[] markBit) {
        double cache = Double.MAX_VALUE;
        int check = 0;
        int bit = 0;
        for (int i = 0; i < dataProcessing.length; i++) {
            if (dataProcessing[i] < 0) {
                continue;
            }
            if (dataProcessing[i] < cache) {
                check = i;
                bit = markBit[i];
                cache = dataProcessing[i];
            }
            if (dataProcessing[i] == cache && bit < markBit[i]) {
                check = i;
                bit = markBit[i];
            }
        }
        return check;
    }
}
