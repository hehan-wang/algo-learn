package com.david.day.d3;

import java.util.Arrays;
import java.util.HashMap;

public class TwoSum_1 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new TwoSum_1().new Solution().twoSum(new int[]{2, 7, 11, 15}, 9)));
        System.out.println(Arrays.toString(new TwoSum_1().new Solution().twoSum(new int[]{-3, 4, 3, 90}, 0)));
    }

    class Solution {
        public int[] twoSum(int[] nums, int target) {
            HashMap<Integer, Integer> cache = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                if (cache.containsKey(target - nums[i])) return new int[]{cache.get(target - nums[i]), i};
                cache.put(nums[i], i);
            }
            return new int[0];
        }
    }
}
