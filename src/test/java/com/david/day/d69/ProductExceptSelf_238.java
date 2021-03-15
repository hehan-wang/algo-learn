package com.david.day.d69;

import java.util.Arrays;

/**
 * 1. 暴力 两次遍历
 * 2. 左右乘积列表 L[i]=L[i-1]*nums[i-1]  R[i]=R[i+1]*nums[i+1]  ans[i]=L[i]*R[i]
 * 3. 优化时间复杂度为O(1) 复用L为结果  R为右乘机
 */
public class ProductExceptSelf_238 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().productExceptSelf(new int[]{1, 2, 3, 4})));
        System.out.println(Arrays.toString(new Solution1().productExceptSelf(new int[]{1, 2, 3, 4})));
    }

    static class Solution1 {
        public int[] productExceptSelf(int[] nums) {
            int[] ans = new int[nums.length];
            int r = 1;
            ans[0] = 1;
            for (int i = 1; i < nums.length; i++) {
                ans[i] = ans[i - 1] * nums[i - 1];
            }
            for (int i = nums.length - 1; i >= 0; i--) {
                ans[i] = ans[i] * r;
                r = r * nums[i];
            }
            return ans;
        }
    }

    /**
     * 左右乘积列表 L[i]=L[i-1]*nums[i-1]  R[i]=R[i+1]*nums[i+1]  ans[i]=L[i]*R[i]
     */
    static class Solution {
        public int[] productExceptSelf(int[] nums) {
            int[] l = new int[nums.length];
            int[] r = new int[nums.length];
            int[] ans = new int[nums.length];
            l[0] = 1;
            for (int i = 1; i < nums.length; i++) {
                l[i] = l[i - 1] * nums[i - 1];
            }
            r[nums.length - 1] = 1;
            for (int j = nums.length - 2; j >= 0; j--) {
                r[j] = r[j + 1] * nums[j + 1];
            }
            for (int i = 0; i < nums.length; i++) {
                ans[i] = l[i] * r[i];
            }
            return ans;
        }
    }
}
