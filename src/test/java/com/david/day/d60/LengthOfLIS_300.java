package com.david.day.d60;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/longest-increasing-subsequence/solution/zui-chang-shang-sheng-zi-xu-lie-dong-tai-gui-hua-2/
 */
public class LengthOfLIS_300 {
    public static void main(String[] args) {
        System.out.println(new Solution().lengthOfLIS(new int[]{10, 9, 2, 5, 3, 7, 101, 18}));
    }

    /**
     * dp
     * 前i个元素的最大值
     * 当nums[i]>nums[j] 新增的i可以接在递增序列后面
     * dp[i]=max(dp[i],dp[j]+1)
     * time:O(n^2)
     */
    static class Solution {
        public int lengthOfLIS(int[] nums) {
            int res = 0, n = nums.length;
            int[] dp = new int[n];
            Arrays.fill(dp, 1);//初始化dp数组 最短递增子数组也有1个长度
            for (int i = 0; i < n; i++) {//i表示 取前i个元素的子数组
                for (int j = 0; j < i; j++) {//使用j 遍历子数组
                    if (nums[i] > nums[j]) dp[i] = Math.max(dp[i], dp[j] + 1);//当nums[i]<nums[j]、i可以插入当前序列、长度+1、更新dp数组
                }
                res = Math.max(res, dp[i]);
            }
            return res;
        }
    }
}
