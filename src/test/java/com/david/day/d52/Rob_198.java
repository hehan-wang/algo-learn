package com.david.day.d52;

/**
 * 思路
 * 1.dp dp[i]=max(dp[i-2]+nums[i],dp[i-1])
 */
public class Rob_198 {
    public static void main(String[] args) {
//        System.out.println(new Solution().rob(new int[]{1, 2, 3, 1}));
        System.out.println(new Solution1().rob(new int[]{1, 2, 3, 1}));
    }

    static class Solution1 {
        public int rob(int[] nums) {
            int pre = 0, curr = 0;
            for (int num : nums) {
                int tmp = curr;//保存当前值
                curr = Math.max(curr, pre + num);//dp方程
                pre = tmp;//赋给前一个
            }
            return curr;
        }
    }

    static class Solution {
        public int rob(int[] nums) {
            if (nums == null || nums.length == 0) return 0;
            if (nums.length == 1) return nums[0];
            int n = nums.length;
            int[] dp = new int[n];
            dp[0] = nums[0];
            dp[1] = Math.max(nums[0], nums[1]);
            for (int i = 2; i < nums.length; i++) {
                dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
            }
            return dp[n - 1];
        }
    }
}
