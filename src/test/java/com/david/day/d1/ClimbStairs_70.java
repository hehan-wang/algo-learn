package com.david.day.d1;

public class ClimbStairs_70 {
    public static void main(String[] args) {
        System.out.println(new ClimbStairs_70().new Solution().climbStairs(3));
    }

    /**
     * dp
     * dp存爬n级台阶的方法数
     * 可以从n-1 爬一节
     * 也可以从n-2爬两节
     * dp[i]=dp[i-2]+dp[i-1]
     */
    class Solution {
        public int climbStairs(int n) {
            int[] dp = new int[n + 1];
            dp[0] = 1;
            dp[1] = 1;
            for (int i = 2; i <= n; i++) {
                dp[i] = dp[i - 1] + dp[i - 2];
            }
            return dp[n];
        }
    }
}
