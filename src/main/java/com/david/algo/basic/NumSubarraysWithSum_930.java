package com.david.algo.basic;

import java.util.HashMap;

/**
 * @author: david
 * @date: 2021/7/8
 */
public class NumSubarraysWithSum_930 {
    public static void main(String[] args) {
        System.out.println(new NumSubarraysWithSum_930().new Solution().numSubarraysWithSum(new int[]{1, 0, 1, 0, 1}, 2));
        System.out.println(new NumSubarraysWithSum_930().new Solution().numSubarraysWithSum(new int[]{0, 0, 0, 0, 0}, 0));
    }

    /**
     * 前缀和
     */
    class Solution {
        public int numSubarraysWithSum(int[] nums, int goal) {
            int res = 0, sum = 0;
            HashMap<Integer, Integer> sumCounts = new HashMap<>();//存到目前下标为止的sum的次数
            for (int num : nums) {
                sumCounts.put(sum, sumCounts.getOrDefault(sum, 0) + 1);
                sum += num;
                res += sumCounts.getOrDefault(sum - goal, 0);
            }
            return res;
        }
    }
}
