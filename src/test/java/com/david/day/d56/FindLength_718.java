package com.david.day.d56;

public class FindLength_718 {
    public static void main(String[] args) {
        System.out.println(new Solution().findLength(new int[]{1, 2, 3, 2, 1}, new int[]{3, 2, 1, 4, 7}));
//        System.out.println(new Solution1().findLength(new int[]{1, 2, 3, 2, 1}, new int[]{3, 2, 1, 4, 7}));
    }


    /**
     * 使用dp 类似1143 最长公共子序列
     * https://leetcode-cn.com/problems/maximum-length-of-repeated-subarray/solution/zhe-yao-jie-shi-ken-ding-jiu-dong-liao-by-hyj8/
     * time:O(m*n)
     */
    static class Solution {
        public int findLength(int[] A, int[] B) {
            int m = A.length, n = B.length;
            int[][] dp = new int[m + 1][n + 1];
            int res = 0;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    dp[i + 1][j + 1] = A[i] == B[j] ? dp[i][j] + 1 : 0;//dp方程当前元素相等最大长度+1 否则清0
                    res = Math.max(res, dp[i + 1][j + 1]);
                }
            }
            return res;
        }
    }
}
