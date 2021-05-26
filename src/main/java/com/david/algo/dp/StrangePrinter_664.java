package com.david.algo.dp;

/**
 * 664. 奇怪的打印机
 * 动态规划
 */
public class StrangePrinter_664 {
    public static void main(String[] args) {
        System.out.println(new StrangePrinter_664().new Solution().strangePrinter("abab"));
    }

    /**
     * 二维dp 存s和s最小值 i j为字符串s的下标 k为分隔点
     * if s[i]=s[j] :dp[i][j]=dp[i][j-1]
     * else dp[i][j]=min(dp[i][j], dp[i][k],dp[k+1][j]  ...)
     * time:O(n^3)
     * space:O(n^2)
     */
    class Solution {
        public int strangePrinter(String s) {
            int n = s.length();
            int[][] dp = new int[n][n];
            for (int i = n - 1; i >= 0; i--) {
                dp[i][i] = 1;//自己变换成自己
                for (int j = i + 1; j < n; j++) {
                    int min = Integer.MAX_VALUE;
                    if (s.charAt(i) == s.charAt(j)) {
                        dp[i][j] = dp[i][j - 1];
                    } else {
                        for (int k = i; k < j; k++) {//遍历中点的所有取法的最小值
                            min = Math.min(min, dp[i][k] + dp[k + 1][j]);
                        }
                        dp[i][j] = min;
                    }
                }
            }
            return dp[0][n - 1];
        }
    }
}
