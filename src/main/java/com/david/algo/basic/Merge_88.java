package com.david.algo.basic;

import java.util.Arrays;

/**
 * 输入：nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
 * 输出：[1,2,2,3,5,6]
 */
public class Merge_88 {
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        new Merge_88().new Solution().merge(nums1, 3, new int[]{2, 5, 6}, 3);
        System.out.println(Arrays.toString(nums1));
    }

    /**
     * 从后向前
     */
    class Solution {
        public void merge(int[] nums1, int m, int[] nums2, int n) {
            int i = m + n - 1, j = m - 1, k = n - 1;//i为新数组下标 j为nums1下标 k为nums2下标
            while (j >= 0 && k >= 0) {
                if (nums1[j] > nums2[k]) swap(nums1, i--, j--);
                else nums1[i--] = nums2[k--];
            }
            while (j >= 0) nums1[i--] = nums1[j--];
            while (k >= 0) nums1[i--] = nums2[k--];
        }

        public void swap(int[] arr, int i, int j) {
            int tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
        }
    }
}
