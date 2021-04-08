package com.david.algo.basic;

import java.util.Arrays;

public class SortArrayByParity_905 {
    public static void main(String[] args) {
        int[] arr = {3, 1, 2, 4};
        int[] res = new SortArrayByParity_905().new Solution().sortArrayByParity(arr);
        System.out.println(Arrays.toString(res));
    }
    class Solution {
        public int[] sortArrayByParity(int[] a) {
            int[] res = new int[a.length];
            int left = 0, right = a.length - 1;
            for (int i : a) {
                if ((i & 1) == 0) res[left++] = i;
                else res[right--] = i;
            }
            return res;
        }
    }
}
