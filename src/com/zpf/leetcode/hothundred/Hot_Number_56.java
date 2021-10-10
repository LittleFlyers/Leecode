package com.zpf.leetcode.hothundred;

import com.zpf.leetcode.util.Log;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * 56. 合并区间
 * <p>
 * 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。请你合并所有重叠的区间，并返回一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间。
 * <p>
 * 示例 1：
 * <p>
 * 输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
 * 输出：[[1,6],[8,10],[15,18]]
 * 解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 * 示例 2：
 * <p>
 * 输入：intervals = [[1,4],[4,5]]
 * 输出：[[1,5]]
 * 解释：区间 [1,4] 和 [4,5] 可被视为重叠区间。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-intervals
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Hot_Number_56 {
    public void get() {
        int[][] a = {{0, 2}, {2, 3}, {4, 4}, {0, 1}, {5, 7}, {4, 5}, {0, 0}};
        int[][] b = merge(a);
        Log.i("结果", b);
    }

    public int[][] merge(int[][] intervals) {
        int[][] b = dfs(intervals);
        if (b.length == intervals.length) {
            return b;
        } else {
            return merge(b);
        }
    }

    public int[][] dfs(int[][] intervals) {
        List<int[]> resultList = new ArrayList<>();
        HashSet<String> resultCache = new HashSet<>();
        for (int i = 0; i < intervals.length; i++) {
            if (resultList.size() == 0) {
                resultList.add(intervals[i]);
            }
            boolean isMerged = false;
            for (int[] cache : resultList) {
                if (intervals[i][0] <= cache[0] && intervals[i][1] >= cache[0]) {
                    if (intervals[i][1] >= cache[1]) {
                        cache[1] = intervals[i][1];
                    }
                    cache[0] = intervals[i][0];
                    isMerged = true;
                } else if (intervals[i][0] <= cache[1] && intervals[i][1] >= cache[1]) {
                    if (intervals[i][0] <= cache[0]) {
                        cache[0] = intervals[i][0];
                    }
                    cache[1] = intervals[i][1];
                    isMerged = true;
                } else if (intervals[i][0] >= cache[0] && intervals[i][1] <= cache[1]) {
                    isMerged = true;
                }
            }
            if (!isMerged) {
                Log.i("加入数据", intervals[i]);
                resultList.add(intervals[i]);
            }
        }
        List<int[]> resultReduce = new ArrayList<>();
        for (int[] ints : resultList) {
            Log.i("初始数据", ints);
            if (!resultCache.contains(ints[0] + "," + ints[1])) {
                resultReduce.add(ints);
                resultCache.add(ints[0] + "," + ints[1]);
            }
        }
        int[][] result = new int[resultReduce.size()][2];
        for (int i = 0; i < resultReduce.size(); i++) {
            result[i] = resultReduce.get(i);
        }
        Log.i("中间结果", result);
        return result;
    }
}
