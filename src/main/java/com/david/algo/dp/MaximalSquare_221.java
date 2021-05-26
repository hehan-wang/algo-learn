package com.david.algo.dp;

import static java.lang.Math.min;

/**
 * 221. 最大正方形
 */
public class MaximalSquare_221 {
    /**
     * dp[i][j]存右下角为 i j 的最大正方形的边长
     * if(matrix[i][j]=='1') dp[i][j]=min(dp[i-1][j],dp[i][j-1],dp[i-1][j-1])+1;
     */
    class Solution {
        public int maximalSquare(char[][] matrix) {
            int m = matrix.length, n = matrix[0].length, maxLen = 0;
            int[][] dp = new int[m + 1][n + 1];
            for (int i = 1; i <= m; i++) {
                for (int j = 1; j <= n; j++) {
                    if (matrix[i - 1][j - 1] == '1') {
                        dp[i][j] = Math.min(Math.min(dp[i][j - 1], dp[i - 1][j]), dp[i - 1][j - 1]) + 1;
                        maxLen = Math.max(dp[i][j], maxLen);
                    }
                }
            }
            return maxLen * maxLen;
        }
    }
}
