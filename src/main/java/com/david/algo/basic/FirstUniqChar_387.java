package com.david.algo.basic;

/**
 * s = "leetcode"
 * 返回 0
 * <p>
 * s = "loveleetcode"
 * 返回 2
 */
public class FirstUniqChar_387 {

    //两次遍历计数法 找到计数器为1的元素下标
    class Solution {
        public int firstUniqChar(String s) {
            char[] chars = s.toCharArray();
            int[] cache = new int[26];
            for (int c : chars) {
                cache[c - 'a']++;
            }
            for (int i = 0; i < chars.length; i++) {
                if (cache[chars[i] - 'a'] == 1) return i;
            }
            return -1;
        }
    }
}
