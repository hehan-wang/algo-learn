package com.david.algo.basic;

import java.util.Arrays;

/**
 * 1744. 你能在你最喜欢的那天吃到你最喜欢的糖果吗？
 * 输入：candiesCount = [7,4,5,3,8], queries = [[0,2,2],[4,2,4],[2,13,1000000000]]
 * 输出：[true,false,true]
 * 提示：
 * 1- 在第 0 天吃 2 颗糖果(类型 0），第 1 天吃 2 颗糖果（类型 0），第 2 天你可以吃到类型 0 的糖果。
 * 2- 每天你最多吃 4 颗糖果。即使第 0 天吃 4 颗糖果（类型 0），第 1 天吃 4 颗糖果（类型 0 和类型 1），你也没办法在第 2 天吃到类型 4 的糖果。换言之，你没法在每天吃 4 颗糖果的限制下在第 2 天吃到第 4 类糖果。
 * 3- 如果你每天吃 1 颗糖果，你可以在第 13 天吃到类型 2 的糖果。
 */
public class CanEat_1744 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new CanEat_1744().new Solution().canEat(new int[]{7, 4, 5, 3, 8}, new int[][]{
                {0, 2, 2},
                {4, 2, 4},
                {2, 13, 1000000000}
        })));
    }

    /**
     * 思路
     * 1.使用前缀和,计算吃到当前下标前面共有多少个糖
     * 2.计算最快时间和最慢时间 判断当前位置是否在区间内
     * O(n)
     */
    class Solution {
        public boolean[] canEat(int[] candiesCount, int[][] queries) {
            int m = candiesCount.length, n = queries.length;
            long[] sum = new long[m + 1];//sum[i]存当前 i 前面的糖果总数 必须用long！ 有的用例超过integer最大值了
            boolean[] res = new boolean[n];
            for (int i = 1; i <= m; i++) sum[i] = sum[i - 1] + candiesCount[i - 1];
            for (int i = 0; i < n; i++) {
                int type = queries[i][0], day = queries[i][1] + 1, cap = queries[i][2];//day+1 由于题目day是从0开始，而我们计算max min的是从1开始。
                long max = sum[type + 1], min = sum[type] / cap + 1;//max 每天吃一个《吃完type+1》需要多少天。min每天吃cap个 《吃完type之前的》所有糖需要多少天
                res[i] = day >= min && day <= max;
            }
            return res;
        }
    }
}
