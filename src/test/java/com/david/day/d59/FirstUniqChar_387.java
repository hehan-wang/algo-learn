package com.david.day.d59;

/**
 * 思路
 * 1.
 * 2.创建int[26] 遍历一次字符串存数组中+1  遍历第二次返回第一个为0的
 */
public class FirstUniqChar_387 {
    public static void main(String[] args) {
        System.out.println(new Solution().firstUniqChar("leetcode"));
        System.out.println(new Solution().firstUniqChar("loveleetcode"));
    }

    static class Solution {
        public int firstUniqChar(String s) {
            int[] cache = new int[26];
            char[] arr = s.toCharArray();
            for (int i = 0; i < arr.length; i++) {
                cache[arr[i] - 'a']++;
            }
            for (int i = 0; i < arr.length; i++) {
                if (cache[arr[i] - 'a'] == 1) return i;
            }
            return -1;
        }
    }
}
