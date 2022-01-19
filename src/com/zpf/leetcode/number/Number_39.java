package com.zpf.leetcode.number;

/*给定一个无重复元素的数组candidates和一个目标数target，找出candidates中所有可以使数字和为target的组合。

        candidates中的数字可以无限制重复被选取。

        说明：

        所有数字（包括target）都是正整数。
        解集不能包含重复的组合。

        来源：力扣（LeetCode）
        链接：https://leetcode-cn.com/problems/combination-sum
        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。*/

import java.util.ArrayList;
import java.util.List;

public class Number_39 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> combine = new ArrayList<>();
        dfs(candidates, target, ans, combine, 0);
        return ans;
    }

    public void dfs(int[] candidates, int target, List<List<Integer>> ans, List<Integer> combine, int idx) {
        if (idx == candidates.length) {
            return;
        }
        if (target == 0) {
            ans.add(new ArrayList<>(combine));
            return;
        }
        dfs(candidates, target, ans, combine, idx + 1);
        if (target - candidates[idx] >= 0) {
            combine.add(candidates[idx]);
            dfs(candidates, target - candidates[idx], ans, combine, idx);
            combine.remove(combine.size() - 1);
        }
    }
}
