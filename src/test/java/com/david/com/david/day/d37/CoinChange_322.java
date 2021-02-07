package com.david.com.david.day.d37;

import java.util.Arrays;

//TODO
public class CoinChange_322 {
    public static void main(String[] args) {

    }


    /**
     * dp
     * 从后向前递推
     * 每个面值每个硬币取一次 取（拿当前面值和不拿）的最大值
     * dp[i]=Math.min(dp[i],dp[j-coin[i]+1);
     */
    static public class Solution {
        public int coinChange(int[] coins, int amount) {
            int max = amount + 1;
            int[] dp = new int[amount + 1];
            Arrays.fill(dp, max);
            dp[0] = 0;
            for (int i = 1; i <= amount; i++) {
                for (int coin : coins) {
                    if (i > coin) {
                        dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                    }
                }
            }
            return dp[amount] > amount ? -1 : dp[amount];
        }
    }
}
