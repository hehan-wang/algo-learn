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
public class HIndex_274 {
    public static void main(String[] args) {
        System.out.println(new HIndex_274().new Solution().hIndex(new int[]{3, 0, 6, 1, 5}));
        System.out.println(new HIndex_274().new Solution().hIndex(new int[]{0}));
        System.out.println(new HIndex_274().new Solution().hIndex(new int[]{100}));
        System.out.println("================================================");

        System.out.println(new HIndex_274().new Solution2().hIndex(new int[]{3, 0, 6, 1, 5}));
        System.out.println(new HIndex_274().new Solution2().hIndex(new int[]{0}));
        System.out.println(new HIndex_274().new Solution2().hIndex(new int[]{100}));
    }

    /**
     * 快排
     * O(nlogn)
     */
    class Solution {
        public int hIndex(int[] citations) {
            Arrays.sort(citations);
            int n = citations.length, h = 0;
            for (int i = n - 1; i >= 0 && citations[i] > h; i--) {//从右到左遍历 h依次++ arr[i]>h的时候就是h的最大值
                h++;
            }
            return h;
        }
    }

    /**
     * 计数排序
     * 1.先遍历一次把每个数字的数量统计出来。因为数组长度为n，结果最大只能是n，所以大于n的放在一起。
     * 2.n从大到小遍历，计数加和，找到了返回
     * O(n)
     */
    class Solution2 {
        public int hIndex(int[] citations) {
            int n = citations.length, count = 0;
            int[] counter = new int[n + 1];//存每个数字的计数
            for (int i = 0; i < n; i++) {
                if (citations[i] >= n) counter[n]++;//大于n的都放在一个桶里！
                else counter[citations[i]]++;
            }
            for (int i = n; i >= 0; i--) {//从后往前找凑齐i的数量 下标即为数字
                count += counter[i];
                if (count >= i) return i;
            }
            return 0;
        }
    }

}
