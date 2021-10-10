package com.zpf.leetcode.swordFingerOffer;

import com.zpf.leetcode.util.Log;

import java.util.*;

/**
 * 剑指 Offer 48. 最长不含重复字符的子字符串
 * <p>
 * 请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子字符串的长度。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 * <p>
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 * <p>
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/zui-chang-bu-han-zhong-fu-zi-fu-de-zi-zi-fu-chuan-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Number_48 {
    public static int lengthOfLongestSubstring(String s) {
        if (s.equals(" ")) {
            return 1;
        }
        if (s.length() == 1) {
            return 1;
        }
        int result = 0;
        Map<Character, Integer> cache = new LinkedHashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (cache.containsKey(s.charAt(i))) {
                int temp = cache.size();
                result = Math.max(temp, result);
                reduce(cache, s.charAt(i));
            }
            cache.put(s.charAt(i), i);
        }
        if (result <= cache.size()) {
            result = cache.size();
        }
        return result;
    }

    public static void reduce(Map<Character, Integer> cache, Character character) {
        Iterator it = cache.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            if (entry.getKey() != character) {
                it.remove();
            } else {
                it.remove();
                return;
            }
        }
    }
}
