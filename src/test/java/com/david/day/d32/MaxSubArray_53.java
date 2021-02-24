package com.david.day.d32;

public class MaxSubArray_53 {
    public static void main(String[] args) {

    }

    /**
     * 使用正数增益 动态规划
     * 思路：
     * 1.当数组前面的和是负的 就舍弃之前的 也验证了经济学中的沉没成本不是成本这句话
     */
    static class Solution {
        public int maxSubArray(int[] nums) {
            int res = nums[0];
            int sum = 0;
            for (int num : nums) {
                if (sum > 0) sum += num;
                else sum = num;
                res = Math.max(sum, res);
            }

            return res;
        }
    }
}
