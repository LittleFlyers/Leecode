package com.zpf.leetcode.hothundred;

import com.zpf.leetcode.util.Execute;
import com.zpf.leetcode.util.Log;

public class Hot_Number_42 implements Execute {
    @Override
    public void execute() {
        int[] a = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        Log.i("结果", trap(a));
    }

    public int trap(int[] height) {
        int len = height.length;
        int result = 0;
        int[] cache = new int[height.length];
        cache[0] = height[0];

        for (int i = 1; i < len; i++) {
            cache[i] += cache[i - 1] + height[i];
            Log.i("缓存", cache[i]);
        }
        for (int left = 0; left < len - 1; ) {
            if (height[left] > 0) {
                Log.i("中间", "左:" + left);
                int right = left + 1;
                for (int j = left + 1; j < len; j++) {
                    if (height[j] >= height[left]) {
                        right = j;
                        break;
                    }
                    if (height[j] > height[right]) {
                        right = j;
                    }
                }
                Log.i("中间", "左:" + left + "右:" + right);
                result += Math.min(height[left], height[right]) * (right - left - 1) - (cache[right - 1] - cache[left]);
                left = right;
            } else {
                left++;
            }
        }
        return result;
    }
}
