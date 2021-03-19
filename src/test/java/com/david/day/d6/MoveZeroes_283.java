package com.david.day.d6;

import java.util.Arrays;

public class MoveZeroes_283 {
    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 3, 12};
        System.out.println(Arrays.toString(nums));
        new MoveZeroes_283().new Solution().moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }

    /**
     * 遍历1次 不为0交换
     * O(n)
     */
    class Solution {
        public void moveZeroes(int[] nums) {
            int fistZeroIndex = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] != 0) {
                    int tmp = nums[fistZeroIndex];
                    nums[fistZeroIndex++] = nums[i];
                    nums[i] = tmp;
                }
            }
        }
    }
}
