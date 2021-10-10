package com.zpf.leetcode.swordFingerOffer;

/**
 * 剑指 Offer 66. 构建乘积数组
 * <p>
 * 给定一个数组 A[0,1,…,n-1]，请构建一个数组 B[0,1,…,n-1]，其中 B[i] 的值是数组 A 中除了下标 i 以外的元素的积, 即 B[i]=A[0]×A[1]×…×A[i-1]×A[i+1]×…×A[n-1]。不能使用除法。
 * <p>
 * 示例:
 * <p>
 * 输入: [1,2,3,4,5]
 * 输出: [120,60,40,30,24]
 */
public class Number_66 {
    public void get() {
        int[] a = {1, 2, 3, 4, 5};
        constructArr(a);
    }

    public int[] constructArr(int[] a) {
        if (a.length == 0) {
            return a;
        }
        int[] b = new int[a.length];
        b[0] = 1;
        for (int i = 1; i < a.length; i++) {
            b[i] = b[i - 1] * a[i - 1];
        }
        for (int i = a.length - 2; i >= 0; i--) {
            if (i < a.length - 2) {
                a[i + 1] = a[i + 2] * a[i + 1];
            }
            b[i] = b[i] * a[i + 1];
        }
        return b;
    }
}
