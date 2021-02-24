package com.david.day.d49;

import java.util.ArrayList;
import java.util.List;

/**
 * 2020-02-21
 * 思路：
 * 1.dfs
 * 2.dp
 */
public class GenerateParenthesis_22 {
    public static void main(String[] args) {
        System.out.println(new Solution().generateParenthesis(3));
    }

    //dfs
    static class Solution {
        public List<String> generateParenthesis(int n) {
            List<String> res = new ArrayList<>();
            dfs(0, 0, n, res, "");
            return res;
        }

        private void dfs(int l, int r, int n, List<String> res, String s) {
            if (l == n && r == n) {
                res.add(s);
                return;
            }
            if (l < n) dfs(l + 1, r, n, res, s + "(");
            if (r < l) dfs(l, r + 1, n, res, s + ")");
        }
    }
}
