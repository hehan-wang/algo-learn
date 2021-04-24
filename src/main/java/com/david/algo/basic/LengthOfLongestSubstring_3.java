package com.david.algo.basic;

import java.util.HashMap;
import java.util.Map;

/**
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 */
public class LengthOfLongestSubstring_3 {
    /**
     * 滑动窗口法
     * max存最大长度
     * 遇到重复字符左边界left滑动到重复字符下一个位置 abc (left=0) -->abca (left=1)滑动掉a 变成bca
     */
    class Solution {
        public int lengthOfLongestSubstring(String s) {
            int max = 0, left = 0;
            HashMap<Character, Integer> map = new HashMap<>();//用map存储字符到下标映射
            char[] chars = s.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                if (map.containsKey(chars[i])) {
                    left = Math.max(left, map.get(chars[i]) + 1);
                }
                map.put(chars[i], i);//更新当前字符的下标
                max = Math.max(max, i - left + 1);
            }
            return max;
        }
    }
}
