package com.zpf.leetcode.swordFingerOffer;

import javax.print.attribute.HashAttributeSet;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

/**
 * 剑指 Offer 60. n个骰子的点数
 *
 * 把n个骰子扔在地上，所有骰子朝上一面的点数之和为s。输入n，打印出s的所有可能的值出现的概率。
 *
 *
 *
 * 你需要用一个浮点数数组返回答案，其中第 i 个元素代表这 n 个骰子所能掷出的点数集合中第 i 小的那个的概率。
 *
 * 示例 1:
 *
 * 输入: 1
 * 输出: [0.16667,0.16667,0.16667,0.16667,0.16667,0.16667]
 * 示例 2:
 *
 * 输入: 2
 * 输出: [0.02778,0.05556,0.08333,0.11111,0.13889,0.16667,0.13889,0.11111,0.08333,0.05556,0.02778]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/nge-tou-zi-de-dian-shu-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * */
public class Number_60 {

    public void get(){
        dicesProbability(2);
    }

    private double[] dicesProbability(int n) {
        Map<Integer, Integer> result = new HashMap<>();
        for (int i = 1; i <= 6; i++) {
            result.put(i, 1);
        }
        int total = 0;
        for (int i = 1; i < n; i++) {
            Map<Integer, Integer> cache = new HashMap<>();
            for (Map.Entry<Integer, Integer> entry : result.entrySet()) {
                for (int j = 1; j <= 6; j++) {
                    int key = entry.getKey();
                    int temp = key + j;
                    if (cache.containsKey(temp)) {
                        cache.replace(temp, cache.get(temp) + entry.getValue());
                    } else {
                        cache.put(temp, entry.getValue());
                    }
                }
            }
            result = cache;
        }
        for (Map.Entry<Integer, Integer> entry : result.entrySet()) {
            total += entry.getValue();
        }
        double[] resultData = new double[result.size()];
        int index = 0;
        DecimalFormat decimalFormat = new DecimalFormat("0.00000");
        for (Map.Entry<Integer, Integer> entry : result.entrySet()) {
            String str = decimalFormat.format((float) entry.getValue() / (float) total);
            resultData[index] = Double.parseDouble(str);
            index++;
        }
        return resultData;
    }
}
