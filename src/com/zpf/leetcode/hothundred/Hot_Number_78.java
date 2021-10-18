package com.zpf.leetcode.hothundred;

import com.zpf.leetcode.util.Execute;
import com.zpf.leetcode.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * 78. 子集
 * <p>
 * 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
 * <p>
 * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,2,3]
 * 输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 * 示例 2：
 * <p>
 * 输入：nums = [0]
 * 输出：[[],[0]]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/subsets
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Hot_Number_78 implements Execute {
    @Override
    public void execute() {
        int[] a = {1, 2, 3};
        Log.i("结果", subsetsIteration(a).size());
    }

/*    List<List<Integer>> result = new ArrayList<>();
    List<Integer> resultTemp = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        dfs(0, nums);
        return result;
    }

    public void dfs(int index, int[] nums) {
        if (index == nums.length) {
            result.add(new ArrayList<>(resultTemp));
        } else {
            resultTemp.add(nums[index]);
            dfs(index + 1, nums);
            resultTemp.remove(resultTemp.size() - 1);
            dfs(index + 1, nums);
        }
    }*/

    public List<List<Integer>> subsetsIteration(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<Integer>());
        for (int i : nums) {
            List<List<Integer>> a = new ArrayList<>();
            Log.i("中间", result.size());
            for (List<Integer> temp : result) {
                List<Integer> cache = new ArrayList<>(temp);
                cache.add(i);
                a.add(cache);
            }
            result.addAll(a);
        }
        return result;
    }
}
