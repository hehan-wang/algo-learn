package com.david.algo.dp;

/**
 * 494. 目标和
 * 输入：nums = [1,1,1,1,1], target = 3
 * 输出：5
 * 解释：一共有 5 种方法让最终目标和为 3 。
 * -1 + 1 + 1 + 1 + 1 = 3
 * +1 - 1 + 1 + 1 + 1 = 3
 * +1 + 1 - 1 + 1 + 1 = 3
 * +1 + 1 + 1 - 1 + 1 = 3
 * +1 + 1 + 1 + 1 - 1 = 3
 */
public class FindTargetSumWays_494 {
    public static void main(String[] args) {
        System.out.println(new FindTargetSumWays_494().new Solution().findTargetSumWays(new int[]{1, 1, 1, 1, 1}, 3));
    }

    /**
     * 暴力法
     * O(2^n)
     */
    class Solution {
        int count = 0;

        public int findTargetSumWays(int[] nums, int target) {
            dfs(nums, target, 0, 0);
            return count;
        }

        private void dfs(int[] nums, int target, int i, int sum) {
            if (i == nums.length) {
                if (sum == target) count++;
                return;
            }
            dfs(nums, target, i + 1, sum + nums[i]);
            dfs(nums, target, i + 1, sum - nums[i]);

        }
    }
}
