package com.david.algo.basic;

import java.util.Arrays;

/**
 * 274. H 指数
 * 思路
 * 求arr[h]>h 的数量
 * <p>
 * <p>
 * 输入：citations = [3,0,6,1,5]
 * 输出：3
 * 解释：给定数组表示研究者总共有 5 篇论文，每篇论文相应的被引用了 3, 0, 6, 1, 5 次。
 *      由于研究者有 3 篇论文每篇 至少 被引用了 3 次，其余两篇论文每篇被引用 不多于 3 次，所以她的 h 指数是 3。
 *
 * @author: david
 * @date: 2021/7/11
 */
public class HIndex_275 {
    public static void main(String[] args) {
        System.out.println(new HIndex_275().new Solution().hIndex(new int[]{0, 1, 3, 5, 6,}));
        System.out.println(new HIndex_275().new Solution().hIndex(new int[]{0}));
        System.out.println(new HIndex_275().new Solution().hIndex(new int[]{100}));
        System.out.println("================================================");
        System.out.println(new HIndex_275().new Solution1().hIndex(new int[]{0, 1, 3, 5, 6,}));
        System.out.println(new HIndex_275().new Solution1().hIndex(new int[]{0}));
        System.out.println(new HIndex_275().new Solution1().hIndex(new int[]{100}));
        System.out.println(new HIndex_275().new Solution1().hIndex(new int[]{0, 0}));
    }

    /**
     * O(n)
     */
    class Solution {
        public int hIndex(int[] citations) {
            int n = citations.length, h = 0;
            for (int i = n - 1; i >= 0 && citations[i] > h; i--) {//从右到左遍历 h依次++ arr[i]>h的时候就是h的最大值
                h++;
            }
            return h;
        }
    }

    /**
     * O(logn)
     * 二分法
     */
    class Solution1 {
        public int hIndex(int[] citations) {
            int n = citations.length, left = 0, right = n - 1;
            while (left < right) {
                int mid = (left + right) >> 1, tmpH = n - mid;
                if (citations[mid] >= tmpH) right = mid ;
                else left = mid +1;
            }
            int h = n - left;
            return citations[left] >= h ? h : 0;
        }
    }
}
