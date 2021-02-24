package com.david.day.d28;

import java.util.Arrays;

public class MajorityElement_169 {
    public static void main(String[] args) {
        int[] nums = {2, 2, 1, 1, 1, 2, 2};
        int i = new Solution().majorityElement(nums);
        System.out.println(i);
    }

    static class Solution {
        public int majorityElement(int[] nums) {
            Arrays.sort(nums);
            return nums[nums.length >> 1];
        }
    }
}
