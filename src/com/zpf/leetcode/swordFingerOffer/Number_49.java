package com.zpf.leetcode.swordFingerOffer;

import java.util.HashMap;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * 剑指 Offer 49. 丑数
 * <p>
 * 我们把只包含质因子 2、3 和 5 的数称作丑数（Ugly Number）。求按从小到大的顺序的第 n 个丑数。
 * <p>
 * 示例:
 * <p>
 * 输入: n = 10
 * 输出: 12
 * 解释: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 是前 10 个丑数。
 */
public class Number_49 {
    public void get() {
        nthUglyNumber(506);
    }

    public int nthUglyNumber(int n) {
        int[] factor = {2, 3, 5};
        Set<Long> check = new HashSet<>();
        PriorityQueue<Long> min = new PriorityQueue<>();
        check.add(1L);
        min.offer(1L);
        int result = 0;
        for (int i = 0; i < n; i++) {
            long cache = min.poll();
            result = (int) cache;
            for (int a : factor) {
                if (check.add(a * cache)) {
                    min.offer(a * cache);
                }
            }

        }
        return result;
    }
}
