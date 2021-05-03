package com.david.algo.basic;

import java.util.Arrays;

/**
 * 12385764-->12386457
 * [1, 2, 3, 8, 5, 7, 6, 4]
 * [1, 2, 3, 8, 5, 4, 6, 7]
 * [1, 2, 3, 8, 6, 4, 5, 7]
 */
public class NextPermutation_31 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 8, 5, 7, 6, 4};
        System.out.println(Arrays.toString(arr));
        new NextPermutation_31().new Solution().nextPermutation(arr);
        System.out.println(Arrays.toString(arr));
    }

    class Solution {
        public void nextPermutation(int[] nums) {
            int len = nums.length;
            for (int i = len - 1; i > 0; i--) {
                if (nums[i] > nums[i - 1]) {//找到第一个逆序对
                    Arrays.sort(nums, i, len);//排序逆序对后边的数组
                    System.out.println(Arrays.toString(nums));
                    for (int j = i; j < len; j++) {//交换一个大于nums[i-1]的元素返回
                        if (nums[j] > nums[i - 1]) {
                            swap(nums, i, j);
                            return;
                        }
                    }
                }
            }
            Arrays.sort(nums);//没有匹配到的话按照升序排列
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[j];
        nums[j] = nums[i - 1];
        nums[i - 1] = temp;
    }
}
