package com.david.algo.dp;

import java.util.Arrays;

/**
 * 输入：coins = [1, 2, 5], amount = 11
 * 输出：3
 * 解释：11 = 5 + 5 + 1
 */
public class CoinChange_322 {
    public static void main(String[] args) {
        System.out.println(new CoinChange_322().new Solution().coinChange(new int[]{1, 2, 5}, 11));
    }

    class Solution {
        public int coinChange(int[] coins, int amount) {
            int[] dp = new int[amount + 1];
            Arrays.fill(dp, amount + 1);
            dp[0] = 0;
            for (int i = 1; i <= amount; i++) {
                for (int coin : coins) {
                    if (i >= coin) dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
            return dp[amount] > amount ? -1 : dp[amount];
        }
    }
}
