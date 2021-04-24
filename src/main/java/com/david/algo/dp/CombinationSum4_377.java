package com.david.algo.dp;

/**
 * 给你一个由 不同 整数组成的数组 nums ，和一个目标整数 target 。请你从 nums 中找出并返回总和为 target 的元素组合的个数。
 * <p>
 * 输入：nums = [1,2,3], target = 4
 * 输出：7
 * 解释：
 * 所有可能的组合为：
 * (1, 1, 1, 1)
 * (1, 1, 2)
 * (1, 2, 1)
 * (1, 3)
 * (2, 1, 1)
 * (2, 2)
 * (3, 1)
 * 请注意，顺序不同的序列被视作不同的组合。
 */
public class CombinationSum4_377 {
    public static void main(String[] args) {
        System.out.println(new CombinationSum4_377().new Solution().combinationSum4(new int[]{1, 2, 3}, 4));
    }

    /**
     * 背包问题
     * dp存target=i 的时候的组合个数
     * dp[i]+=dp[i-num]
     */
    class Solution {
        public int combinationSum4(int[] nums, int target) {
            int[] dp = new int[target + 1];
            dp[0] = 1;//没钱只有不拿一种情况
            for (int i = 1; i <= target; i++) {
                for (int num : nums) {
                    if (i >= num) dp[i] += dp[i - num];
                }
            }
            return dp[target];
        }
    }
}
