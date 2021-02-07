package com.david.com.david.day.d38;

import java.util.Arrays;

public class Rob_213 {
    public static void main(String[] args) {
        System.out.println(new Solution().rob(new int[]{2, 3, 2}));
    }

    static class Solution {
        public int rob(int[] nums) {
            if (nums.length == 0) return 0;
            if (nums.length == 1) return nums[0];
            return Math.max(
                    myRob(Arrays.copyOfRange(nums, 1, nums.length)),
                    myRob(Arrays.copyOfRange(nums, 0, nums.length - 1))
            );
        }

        public int myRob(int[] nums) {
            int pre = 0, now = 0, tmp;
            for (int n : nums) {
                tmp = now;
                now = Math.max(pre + n, now);
                pre = tmp;
            }
            return now;
        }
    }
}
