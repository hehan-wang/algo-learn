package com.david.day.d36;

public class MinPathSum_64 {
    public static void main(String[] args) {
        int[][] grid = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        System.out.println(new Solution().minPathSum(grid));
        System.out.println(new Solution1().minPathSum(grid));
    }

    /**
     * 简单写法
     * https://leetcode-cn.com/problems/minimum-path-sum/solution/zui-xiao-lu-jing-he-dong-tai-gui-hua-gui-fan-liu-c/
     */
    static class Solution1 {
        public int minPathSum(int[][] grid) {
            int rows = grid.length;
            int cols = grid[0].length;
            for (int i = 0; i < rows; i++) {//复用原数组当成dp数组
                for (int j = 0; j < cols; j++) {//grid[0][0]位置和就是自身 从1开始
                    if (i == 0 & j == 0) continue;
                    else if (i == 0) grid[i][j] = grid[i][j - 1] + grid[i][j]; //第一行
                    else if (j == 0) grid[i][j] = grid[i - 1][j] + grid[i][j];  //第一列
                    else grid[i][j] = Math.min(grid[i][j - 1] + grid[i][j], grid[i - 1][j] + grid[i][j]);
                }
            }
            return grid[rows - 1][cols - 1];
        }
    }

    /**
     * int[][] grid 代表[行]*[列]
     * 自己的丑陋写法
     */
    static class Solution {
        public int minPathSum(int[][] grid) {
            int rows = grid.length;
            int cols = grid[0].length;
            int[][] dp = new int[rows][cols];
            for (int i = 0; i < rows; i++) dp[i][0] = (i - 1 >= 0 ? dp[i - 1][0] : 0) + grid[i][0];//先构建第一例
            for (int j = 0; j < cols; j++) dp[0][j] = (j - 1 >= 0 ? dp[0][j - 1] : 0) + grid[0][j];//先构建第一行
            for (int i = 1; i < rows; i++) {
                for (int j = 1; j < cols; j++) {
                    int up = dp[i][j - 1] + grid[i][j];
                    int left = dp[i - 1][j] + grid[i][j];
                    dp[i][j] = Math.min(left, up);//dp方程取Math.min(left, up)
                }
            }
            return dp[rows - 1][cols - 1];
        }
    }
}
