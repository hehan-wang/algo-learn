package com.david.algo.basic;

import java.util.Arrays;

public class SortedSquares_977 {
    /**
     * 双指针大数放在后面 因为-x*-x=x^2 绝对值大的在后面
     * O(n)
     */
    class Solution1 {
        public int[] sortedSquares(int[] nums) {
            int n = nums.length;
            int[] res = new int[n];
            for (int i = 0, j = n - 1, pos = n - 1; i <= j; ) {
                int l = nums[i] * nums[i];
                int r = nums[j] * nums[j];
                if (l > r) {
                    res[pos--] = l;
                    i++;
                } else {
                    res[pos--] = r;
                    j--;
                }
            }
            return res;
        }
    }

    /**
     * time O(nlogn)
     */
    class Solution {
        public int[] sortedSquares(int[] nums) {
            for (int i = 0; i < nums.length; i++) {
                nums[i] = nums[i] * nums[i];
            }
            Arrays.sort(nums);
            return nums;
        }
    }
}
