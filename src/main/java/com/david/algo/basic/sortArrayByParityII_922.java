package com.david.algo.basic;

import java.util.Arrays;

/**
 * 输入：[4,2,5,7]
 * 输出：[4,5,2,7]
 * 解释：[4,7,2,5]，[2,5,4,7]，[2,7,4,5] 也会被接受。
 */
public class sortArrayByParityII_922 {
    public static void main(String[] args) {
        int[] arr = {4, 2, 5, 7};
        int[] res = new sortArrayByParityII_922().new Solution1().sortArrayByParityII(arr);
        System.out.println(Arrays.toString(res));
    }

    /**
     * 偶数位下标为奇数的
     * 交换第一个不为奇数的奇数位下标
     */
    class Solution1 {
        public int[] sortArrayByParityII(int[] nums) {
            if (nums == null || nums.length == 0) return nums;
            int n = nums.length;
            int j = 1;
            for (int i = 0; i < n; i += 2) {
                if ((nums[i] & 1) == 1) {//偶数位为奇数
                    while ((nums[j] & 1) == 1) j += 2;//找到奇数位第一个不为奇数的值
                    int tmp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = tmp;
                }
            }
            return nums;
        }
    }

    /**
     * 奇偶双指针
     */
    class Solution {
        public int[] sortArrayByParityII(int[] nums) {
            if (nums == null || nums.length <= 1) return nums;
            int n = nums.length;
            int[] res = new int[n];
            for (int even = 0, odd = 1, i = 0; i <= n - 1; i++) {
                if ((nums[i] & 1) == 0 && even <= n - 1) {
                    res[even] = nums[i];
                    even += 2;
                } else if (odd <= n - 1) {
                    res[odd] = nums[i];
                    odd += 2;
                }
            }
            return res;
        }
    }
}
