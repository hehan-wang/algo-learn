package com.david.com.david.day.d30;

import java.util.HashMap;

public class TwoSum_1 {
    public static void main(String[] args) {

    }

    class Solution {
        public int[] twoSum(int[] nums, int target) {
            HashMap<Integer, Integer> indexMap = new HashMap<>();
            for (int one = 0; one < nums.length; one++) {
                Integer two = indexMap.get(target - nums[one]);
                if (two != null) return new int[]{one, two};
                indexMap.put(nums[one], one);
            }
            return null;
        }
    }
}
