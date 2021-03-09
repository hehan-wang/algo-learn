package com.david.day.d65;

import java.util.List;

/**
 * dp[i][j]=min(dp[i+1][j],dp[i+1][j+1])+num[i][j]
 */
public class MinimumTotal_120 {
    public static void main(String[] args) {
        List<List<Integer>> l = List.of(
                List.of(2),
                List.of(3, 4),
                List.of(6, 5, 7),
                List.of(4, 1, 8, 3)
        );
        System.out.println(new Solution().minimumTotal(l));
        System.out.println(new Solution1().minimumTotal(l));
    }

    //一维数组dp 滚动更新一行
    static class Solution1 {
        public int minimumTotal(List<List<Integer>> triangle) {
            int n = triangle.size();
            int[] dp = new int[n + 1];
            for (int i = n - 1; i >= 0; i--) {
                for (int j = 0; j <= i; j++) {
                    dp[j] = Math.min(dp[j], dp[j + 1]) + triangle.get(i).get(j);
                }
            }
            return dp[0];
        }
    }

    //二维数组dp 从后向前递推
    static class Solution {
        public int minimumTotal(List<List<Integer>> triangle) {
            int n = triangle.size();
            int[][] dp = new int[n + 1][n + 1];
            for (int i = n - 1; i >= 0; i--) {
                for (int j = 0; j <= i; j++) {
                    dp[i][j] = Math.min(dp[i + 1][j], dp[i + 1][j + 1]) + triangle.get(i).get(j);
                }
            }
            return dp[0][0];
        }
    }
}
