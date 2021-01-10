package com.david.com.david.day.d14;

import java.util.Arrays;

public class MoveZeroes_283 {
    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 3, 12};
        new Solution().moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }

    /**
     * 双指针法
     * 利用快拍思想 把<0的放在左边
     * https://leetcode-cn.com/problems/move-zeroes/solution/dong-hua-yan-shi-283yi-dong-ling-by-wang_ni_ma/
     */
    static class Solution {
        public void moveZeroes(int[] nums) {
            int j = 0;//0的下标
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] != 0) {//只有找到等于0的才交换
                    int tmp = nums[i];
                    nums[i] = nums[j];
                    nums[j++] = tmp;
                }
            }
        }
    }
}
