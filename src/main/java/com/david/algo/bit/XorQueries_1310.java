package com.david.algo.bit;

import java.util.Arrays;

/**
 * 1310. 子数组异或查询
 * 输入：arr = [1,3,4,8], queries = [[0,1],[1,2],[0,3],[3,3]]
 * 输出：[2,7,14,8]
 * 解释：
 * 数组中元素的二进制表示形式是：
 * 1 = 0001
 * 3 = 0011
 * 4 = 0100
 * 8 = 1000
 * 查询的 XOR 值为：
 * [0,1] = 1 xor 3 = 2
 * [1,2] = 3 xor 4 = 7
 * [0,3] = 1 xor 3 xor 4 xor 8 = 14
 * [3,3] = 8
 */
public class XorQueries_1310 {
    public static void main(String[] args) {
        int[] arr = {1, 3, 4, 8};
        int[][] queries = {
                {0, 1},
                {1, 2},
                {0, 3},
                {3, 3}
        };
        System.out.println(Arrays.toString(new XorQueries_1310().new Solution().xorQueries(arr, queries)));
        System.out.println(Arrays.toString(new XorQueries_1310().new Solution1().xorQueries(arr, queries)));
    }

    /**
     * 缓存前缀和 利用  xor(m ~ n)=xor(1 ~ m)^xor(1 ~ n-1)
     * time:O(arr.length+queries.length) O(m+n)
     */
    class Solution1 {
        public int[] xorQueries(int[] arr, int[][] queries) {
            int[] xor = new int[arr.length + 1], res = new int[queries.length];
            for (int i = 1; i <= arr.length; i++) xor[i] = xor[i - 1] ^ arr[i - 1];//下标i+1 缓存1-i xor的和
            for (int i = 0; i < queries.length; i++) {
                int l = queries[i][0] + 1, r = queries[i][1] + 1;//偏移量+1 由于xor长度为+1了
                res[i] = xor[l - 1] ^ xor[r];//xor(m ~ n)=xor(1 ~ m)^xor(1 ~ n-1)
            }
            return res;
        }
    }

    /**
     * 1.模拟法
     * O(m*n)
     */
    class Solution {
        public int[] xorQueries(int[] arr, int[][] queries) {
            int n = queries.length;
            int[] res = new int[n];
            for (int i = 0; i < n; i++) {
                int[] range = queries[i];
                int tmp = 0;
                for (int j = range[0]; j <= range[1]; j++) {
                    tmp ^= arr[j];
                }
                res[i] = tmp;
            }
            return res;
        }
    }
}
