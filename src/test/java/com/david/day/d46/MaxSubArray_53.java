package com.david.day.d46;

/**
 * 2021-02-11
 * 输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
 * 输出：6
 * 解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
 */
public class MaxSubArray_53 {
    public static void main(String[] args) {
        System.out.println(new Solution().maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
        System.out.println(new Solution1().maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
    }

    /**
     * 暴力法 遍历所有子数组边界 取最大值
     * time:O(n^2)
     * space:O(1)
     */
    static class Solution1 {
        public int maxSubArray(int[] nums) {
            int n = nums.length;
            int max = Integer.MIN_VALUE;
            for (int l = 0; l < n; l++) {//左边界
                int sum = 0;//左边界移动的时候sum重置
                for (int r = l; r < n; r++) {//右边界
                    sum += nums[r];
                    max = Math.max(sum, max);
                }
            }
            return max;
        }
    }

    /**
     * 正增法 sum为为负数就舍弃掉
     * time:O(n)
     * space:O(1)
     */
    static class Solution {
        public int maxSubArray(int[] nums) {
            //长度<=1d的边界条件
            if (nums.length == 0) return 0;
            int sum = 0, max = nums[0];
            for (int num : nums) {
                if (sum <= 0) sum = num;
                else sum += num;
                max = Math.max(sum, max);
            }
            return max;
        }
    }
}
