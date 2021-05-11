package com.david.algo.bsearch;

import java.util.Arrays;

/**
 * 制作 m 束花所需的最少天数
 * 输入：bloomDay = [1,10,3,10,2], m = 3, k = 1
 * 输出：3
 * 解释：让我们一起观察这三天的花开过程，x 表示花开，而 _ 表示花还未开。
 * 现在需要制作 3 束花，每束只需要 1 朵。
 * 1 天后：[x, _, _, _, _]   // 只能制作 1 束花
 * 2 天后：[x, _, _, _, x]   // 只能制作 2 束花
 * 3 天后：[x, _, x, _, x]   // 可以制作 3 束花，答案为 3
 */
public class MinDays_1482 {
    public static void main(String[] args) {
        System.out.println(new MinDays_1482().new Solution().minDays(new int[]{1, 10, 3, 10, 2}, 3, 1));
    }

    /**
     * 二分搜索天数的最大值优化O(n)遍历 为O(logn)
     * 看那一天能否组成花束
     */
    class Solution {
        public int minDays(int[] bloomDay, int m, int k) {
            int n = bloomDay.length;
            if (n < m * k) return -1;//花不够的情况
            int left = 0, right = Arrays.stream(bloomDay).max().getAsInt();//二分搜索天数
            while (left < right) {
                int mid = left + ((right - left) >> 1);//需要注意 '+' '-' 的运算优先级大于 '>>' 所以需要加括号。这种方式也会防止(left+right)/2 可能超出Integer的最大值的情况
                if (canMake(bloomDay, mid, m, k)) right = mid;//可以组成花束的话要找更小的值
                else left = mid + 1;
            }
            return right;
        }

        //存在连续k个小于day的天数，flowers+1，最后比较 flowers>=m 表示当前天数可以凑够m个花束
        private boolean canMake(int[] bloomDay, int day, int m, int k) {
            int flowers = 0, part = 0;//flowers存花束的数量 ，part存连续花的数量 当凑后k或者断了清零
            for (int d : bloomDay) {
                if (d <= day) {
                    part++;
                    if (part >= k) {
                        flowers++;
                        part = 0;
                    }
                } else {
                    part = 0;
                }
            }
            return flowers >= m;
        }
    }
}
