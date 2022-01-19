package com.zpf.leetcode.number;

import com.zpf.leetcode.util.Execute;
import com.zpf.leetcode.util.Log;

public class Number_650 implements Execute {

    private int result = Integer.MAX_VALUE;

    public int minSteps(int n) {
        if(n==1){
            return 0;
        }
        dfs(n, 0, 1, 0, true);
        Log.i("結果", result);
        return result;
    }

    public void dfs(int n, int count, int copyData, int path, boolean lastIsCopy) {
        if (count > n) {
            return;
        }
        if (n == count) {
            result = Math.min(result, path);
        } else {
            if (!lastIsCopy) {
                dfs(n, count, count, path + 1, true);
            }
            dfs(n, count + copyData, copyData, path + 1, false);
        }
    }

    @Override
    public void execute() {
        Number_650 number_650 = new Number_650();
        number_650.minSteps(11);
    }
}
