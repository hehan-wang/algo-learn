package com.david.algo.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.stream.Collectors;

/**
 * 剑指 Offer 38. 字符串的排列
 * 输入：s = "abc"
 * 输出：["abc","acb","bac","bca","cab","cba"]
 */
public class Permutation_offer38 {
    public static void main(String[] args) {
//        System.out.println(Arrays.toString(new Permutation_offer38().new Solution().permutation("abc")));
        System.out.println(Arrays.toString(new Permutation_offer38().new Solution().permutation("aab")));
        System.out.println(Arrays.toString(new Permutation_offer38().new Solution1().permutation("aab")));
    }

    /**
     * 回溯
     */
    class Solution {
        public String[] permutation(String s) {
            HashSet<String> res = new HashSet<>();
            char[] chars = s.toCharArray();
            int n = s.length();
            boolean[] used = new boolean[n];
            backtrack(chars, 0, n, res, used, "");
            return res.toArray(String[]::new);//去重
        }

        private void backtrack(char[] chars, int i, int n, HashSet<String> res, boolean[] used, String tmp) {
            if (i == n) {
                res.add(tmp);
                return;
            }
            for (int j = 0; j < n; j++) {
                if (used[j]) continue;
                used[j] = true;
                backtrack(chars, i + 1, n, res, used, tmp + chars[j]);//由于字符串是不可变类不用回溯
                used[j] = false; //回溯
            }
        }
    }

    //提前使用set判重
    class Solution1 {
        public String[] permutation(String s) {
            ArrayList<String> res = new ArrayList<>();
            char[] chars = s.toCharArray();
            int n = s.length();
            boolean[] used = new boolean[n];
            backtrack(chars, 0, n, res, used, "");
            return res.toArray(String[]::new);
        }

        private void backtrack(char[] chars, int i, int n, ArrayList<String> res, boolean[] used, String tmp) {
            if (i == n) {
                res.add(tmp);
                return;
            }
            HashSet<Character> set = new HashSet<>();//不能拿两个一样的字母
            for (int j = 0; j < n; j++) {
                if (used[j]) continue;
                if (set.contains(chars[j])) continue;
                set.add(chars[j]);
                used[j] = true;
                backtrack(chars, i + 1, n, res, used, tmp + chars[j]);//由于字符串是不可变类不用回溯
                used[j] = false; //回溯
            }
        }
    }
}
