package com.zpf.leetcode.swordFingerOffer;

import com.zpf.leetcode.util.Log;

/**
 * 剑指 Offer 46. 把数字翻译成字符串
 * <p>
 * 给定一个数字，我们按照如下规则把它翻译为字符串：0 翻译成 “a” ，1 翻译成 “b”，……，11 翻译成 “l”，……，25 翻译成 “z”。一个数字可能有多个翻译。请编程实现一个函数，用来计算一个数字有多少种不同的翻译方法。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 12258
 * 输出: 5
 * 解释: 12258有5种不同的翻译，分别是"bccfi", "bwfi", "bczi", "mcfi"和"mzi"
 */
public class Number_46 {

    public void get() {
        translateNum(506);
    }

    private int result = 0;

    public int translateNum(int num) {
        dfs(String.valueOf(num), -1);
        Log.i("结果", result);
        return result;
    }

    private void dfs(String num, int index) {
        if (index == num.length()) {
            result++;
            Log.i("结果", result);
        } else {
            dfs(num, index + 1);

            if (index + 2 < num.length()) {
                int cache = Integer.parseInt(num.substring(index + 1, index + 3));
                if (cache <= 25 && cache >= 10) {
                    dfs(num, index + 2);
                }
            }
        }
    }

/*    private Map<String,String> init(){
        Map<String,String> mappingTable = new HashMap<>();
        mappingTable.put("0","a");
    }*/
}
