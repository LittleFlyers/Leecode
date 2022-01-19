package com.zpf.leetcode.number;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * link:https://leetcode-cn.com/problems/unique-length-3-palindromic-subsequences/
 * <p>
 * 给你一个字符串 s ，返回 s 中 长度为 3 的不同回文子序列 的个数。
 * <p>
 * 即便存在多种方法来构建相同的子序列，但相同的子序列只计数一次。
 * <p>
 * 回文 是正着读和反着读一样的字符串。
 * <p>
 * 子序列 是由原字符串删除其中部分字符（也可以不删除）且不改变剩余字符之间相对顺序形成的一个新字符串。
 * <p>
 * 例如，"ace" 是 "abcde" 的一个子序列。
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "aabca"
 * 输出：3
 * 解释：长度为 3 的 3 个回文子序列分别是：
 * - "aba" ("aabca" 的子序列)
 * - "aaa" ("aabca" 的子序列)
 * - "aca" ("aabca" 的子序列)
 * 示例 2：
 * <p>
 * 输入：s = "adc"
 * 输出：0
 * 解释："adc" 不存在长度为 3 的回文子序列。
 * 示例 3：
 * <p>
 * 输入：s = "bbcbaba"
 * 输出：4
 * 解释：长度为 3 的 4 个回文子序列分别是：
 * - "bbb" ("bbcbaba" 的子序列)
 * - "bcb" ("bbcbaba" 的子序列)
 * - "bab" ("bbcbaba" 的子序列)
 * - "aba" ("bbcbaba" 的子序列)
 *  
 * <p>
 * 提示：
 * <p>
 * 3 <= s.length <= 105
 * s 仅由小写英文字母组成
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/unique-length-3-palindromic-subsequences
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class Number_5809 {
    public static int countPalindromicSubsequence(String s) {
        int result = 0;
        Map<String, List<Integer>> lettersAppear = new LinkedHashMap<>();
        for (int i = 0; i < s.length(); i++) {
            String letter = String.valueOf(s.charAt(i));
            if (lettersAppear.containsKey(letter)) {
                lettersAppear.get(letter).add(i);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                lettersAppear.put(letter, list);
            }
        }

        for (Map.Entry side : lettersAppear.entrySet()) {
            List<Integer> sideList = (List<Integer>) side.getValue();
            //如果字符出现一次以下，不能做为两边
            if (sideList.size() <= 1) {
                continue;
            }
            //字母出现3次以上，回文结果+1
            if (sideList.size() >= 3) {
                result++;
            }
            for (Map.Entry mid : lettersAppear.entrySet()) {
                //key值相同跳过
                if (side.getKey().equals(mid.getKey())) {
                    continue;
                }
                //两边的字母的最初位置
                int sideStart = sideList.get(0);
                //两边的字母的末尾位置
                int sideEnd = sideList.get(sideList.size() - 1);

                //遍历中间字母出现位置
                List<Integer> midList = (List<Integer>) mid.getValue();
                for (Integer midOccur : midList) {
                    //中间字母在两边字母中间，结果+1，停止中间字母位置遍历
                    if (midOccur > sideStart && midOccur < sideEnd){
                        result++;
                        break;
                    }
                }
            }
        }
        return result;
    }
}
