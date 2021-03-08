package com.david.day.d58;

import java.util.Arrays;

public class UniquePaths_62 {
    public static void main(String[] args) {
        System.out.println(new Solution().uniquePaths(3, 2));
        System.out.println(new Solution().uniquePaths(3, 7));
        System.out.println(new Solution1().uniquePaths(3, 7));
    }

    /**
     * 优化空间复杂度O(n)
     * 每次滚动第一行
     */
    static class Solution1 {
        public int uniquePaths(int m, int n) {
            int[] dp = new int[n];
            Arrays.fill(dp, 1);
            for (int i = 1; i < m; i++) {
                for (int j = 1; j < n; j++) {
                    dp[j] += dp[j - 1];
                }
            }
            return dp[n - 1];
        }
    }

    /**
     * dp
     * 每一个格子可以从左边向右走一格 上边向下走一格
     * 第一行只能从左边过来
     * 第一列只能从上边过来
     */
    static class Solution {
        public int uniquePaths(int m, int n) {
            int[][] dp = new int[m + 1][n + 1];
            for (int i = 0; i <= m; i++) dp[i][0] = 1;
            for (int j = 0; j <= n; j++) dp[0][j] = 1;

            for (int i = 1; i < m; i++) {
                for (int j = 1; j < n; j++) {
                    dp[i][j] = dp[i][j - 1] + dp[i - 1][j];
                }
            }
            return dp[m - 1][n - 1];
        }
    }
}
