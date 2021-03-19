package com.david.algo.basic;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

/**
 * 思路：
 * 1.计数法 找出数量是1的字符
 */
public class FindTheDifference_389 {
    public static void main(String[] args) {
        System.out.println((char) 0);
//        System.out.println(new FindTheDifference_389().new Solution().findTheDifference("abcd", "abcde"));
    }

    /**
     * 异或reduce
     */
    class Solution3 {
        public char findTheDifference(String s, String t) {
            return (char) (s + t).chars().reduce(0, (c, c1) -> c ^= c1);
        }
    }

    /**
     * 异或法 'a'^'a'=0
     * 相同数字异或为0
     * O(s+t)
     */
    class Solution2 {
        public char findTheDifference(String s, String t) {
            int res = 0;
            for (char c : s.toCharArray()) {
                res ^= c;
            }
            for (char c : t.toCharArray()) {
                res ^= c;
            }
            return (char) res;
        }
    }

    /**
     * 计数数组 时间复杂度最佳
     * o(s+t)
     */
    class Solution1 {
        public char findTheDifference(String s, String t) {
            int[] cache = new int[255];
            for (char c : s.toCharArray()) {
                cache[c]++;
            }
            for (char c : t.toCharArray()) {
                if (--cache[c] < 0) return c;
            }
            return 0;
        }
    }

    /**
     * 计数map
     * time O(s+2t)
     */
    class Solution {
        public char findTheDifference(String s, String t) {
            HashMap<Character, Integer> cache = new HashMap<>();
            for (char c : s.toCharArray()) {
                cache.compute(c, (character, integer) -> integer == null ? 1 : integer + 1);
            }
            for (char c : t.toCharArray()) {
                cache.compute(c, (character, integer) -> integer == null ? -1 : integer - 1);
            }
            for (Map.Entry<Character, Integer> entry : cache.entrySet()) {
                if (entry.getValue() == -1) return entry.getKey();
            }
            return ' ';
        }
    }
}
