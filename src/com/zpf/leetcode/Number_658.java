package com.zpf.leetcode;

import com.zpf.leetcode.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * 658. 找到 K 个最接近的元素
 * <p>
 * 给定一个排序好的数组 arr ，两个整数 k 和 x ，从数组中找到最靠近 x（两数之差最小）的 k 个数。返回的结果必须要是按升序排好的。
 * <p>
 * 整数 a 比整数 b 更接近 x 需要满足：
 * <p>
 * |a - x| < |b - x| 或者
 * |a - x| == |b - x| 且 a < b
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-k-closest-elements
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Number_658 {
    public static List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> result = new ArrayList<>();
        List<Integer> polytechnic = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            Log.i("差值", Math.abs((x - arr[i])));
            polytechnic.add(Math.abs((x - arr[i])));
        }
        //最接近值得位置
        int minLocation = 0;
        int min = Integer.MAX_VALUE;
        //找出差最小的值
        for (int i = 0; i < polytechnic.size(); i++) {
            if (polytechnic.get(i) < min) {
                minLocation = i;
                min = polytechnic.get(i);
            }
        }
        Log.i("最接近值边界", minLocation);
        int left = minLocation;
        int right = minLocation;
        int difference = right - left;
        while (difference < k-1) {
            int leftData = Integer.MIN_VALUE;
            if (left - 1 >= 0) {
                leftData = polytechnic.get(left - 1);
            }
            Log.i("左值", leftData);
            int rightData = Integer.MIN_VALUE;
            if (right + 1 < polytechnic.size()) {
                rightData = polytechnic.get(right + 1);
            }
            Log.i("右值", rightData);
            if (leftData == Integer.MIN_VALUE) {
                right++;
                difference = right - left;
                continue;
            }
            if (rightData == Integer.MIN_VALUE) {
                left--;
                difference = right - left;
                continue;
            }
            if (leftData <= rightData) {
                left--;

            } else {
                right++;
            }

            Log.i("更新左指针", left);
            Log.i("更新右指针", right);
            difference = right - left;
            Log.i("差值", difference);
        }
        Log.i("左边界", left);
        Log.i("右边界", right);
        for (int i = left; i <= right; i++) {
            result.add(arr[i]);
        }
        return result;
    }
}
