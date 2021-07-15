package com.david.algo.basic;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.TreeSet;

/**
 * arr 中 第一个 元素必须为 1 。
 * 任意相邻两个元素的差的绝对值 小于等于 1 ，也就是说，对于任意的 1 <= i < arr.length （数组下标从 0 开始），都满足 abs(arr[i] - arr[i - 1]) <= 1 。abs(x) 为 x 的绝对值。
 * <p>
 * 因为从1开始绝对值差小于等于1 所以最大值为arr.length
 * 因为数字只能变小 所以不能超过最大值 res=min(max(arr),arr.length)
 *
 * @author: david
 * @date: 2021/7/15
 */
public class MaximumElementAfterDecrementingAndRearranging_1846 {
    public static void main(String[] args) {
        System.out.println(new MaximumElementAfterDecrementingAndRearranging_1846().new Solution1().maximumElementAfterDecrementingAndRearranging(new int[]{2, 2, 1, 2, 1}));//2
        System.out.println(new MaximumElementAfterDecrementingAndRearranging_1846().new Solution1().maximumElementAfterDecrementingAndRearranging(new int[]{100, 1, 1000}));//3
    }

    /**
     * 计数排序法
     * O(n)
     */
    class Solution1 {
        public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
            int n = arr.length;
            int[] cnts = new int[n + 1];//计数排序大于n的全部记到n
            for (int num : arr) cnts[Math.min(num, n)]++;
            int ans = 0;
            for (int i = 1; i <= n; i++) {
                ans = Math.min(ans + cnts[i], i);
            }
            return ans;
        }
    }

    /**
     * 快拍
     * 三叶 贪心
     */
    class Solution {
        public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
            Arrays.sort(arr);
            int n = arr.length;
            arr[0] = 1;//从1开始
            for (int i = 1; i < arr.length; i++) {
                if (arr[i] - arr[i - 1] > 1) {//减上一个大于1 则+1,相等则不变
                    arr[i] = arr[i - 1] + 1;
                }
            }
            return arr[n - 1];
        }
    }

    /**
     * 贪心 真聪明
     * 每想后走一个最大值也相对应+1
     * O(nlogn)
     */
    class Solution2 {
        public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
            Arrays.sort(arr);
            int res = 0;
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] > res) res++;
            }
            return res;
        }
    }
}
