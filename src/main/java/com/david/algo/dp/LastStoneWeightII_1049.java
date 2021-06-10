package com.david.algo.dp;

/**
 * 1049. 最后一块石头的重量 II
 * 输入：stones = [2,7,4,1,8,1]
 * 输出：1
 * 解释：
 * 组合 2 和 4，得到 2，所以数组转化为 [2,7,1,8,1]，
 * 组合 7 和 8，得到 1，所以数组转化为 [2,1,1,1]，
 * 组合 2 和 1，得到 1，所以数组转化为 [1,1,1]，
 * 组合 1 和 1，得到 0，所以数组转化为 [1]，这就是最优值。
 * <p>
 */
public class LastStoneWeightII_1049 {
    public static void main(String[] args) {
//        System.out.println(new LastStoneWeightII_1049().new Solution().lastStoneWeightII(new int[]{2, 7, 4, 1, 8, 1}));
        System.out.println(new LastStoneWeightII_1049().new Solution().lastStoneWeightII(new int[]{1, 2}));
        System.out.println(new LastStoneWeightII_1049().new Solution1().lastStoneWeightII(new int[]{1, 2}));
    }

    /**
     * 一维dp
     */
    class Solution1 {
        public int lastStoneWeightII(int[] stones) {
            int n = stones.length, sum = 0;
            for (int s : stones) sum += s;
            int max = sum >> 1;
            int[] dp = new int[max + 1];
            for (int i = 1; i <= n; i++) {
                int s = stones[i - 1];
                for (int j = max; j >= s; j--) {
                    dp[j] = Math.max(dp[j], dp[j - s] + s);
                }
            }
            return Math.abs(sum - (dp[max] << 1));
        }
    }

    /**
     * 思路:
     * 转化成01背包问题 取拿到最接近sum/2 个重量s 结果为 sum-2*s
     */
    class Solution {
        public int lastStoneWeightII(int[] stones) {
            int n = stones.length, sum = 0;
            for (int s : stones) sum += s;
            int max = sum >> 1;
            int[][] dp = new int[n + 1][max + 1];
            for (int i = 1; i <= n; i++) {
                int s = stones[i - 1];
                for (int j = 1; j <= max; j++) {
                    dp[i][j] = dp[i - 1][j];//当前至少跟上一个不拿一样大
                    if (j >= s) dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - s] + s);
                }
            }
            return Math.abs(sum - (dp[n][max] << 1));
        }
    }
}
