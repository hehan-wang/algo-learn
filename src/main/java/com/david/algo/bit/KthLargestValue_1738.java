package com.david.algo.bit;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 1738. 找出第 K 大的异或坐标值
 * 输入：matrix = [[5,2],[1,6]], k = 1
 * 输出：7
 * 解释：坐标 (0,1) 的值是 5 XOR 2 = 7 ，为最大的值。
 */
public class KthLargestValue_1738 {
    public static void main(String[] args) {
        System.out.println(new KthLargestValue_1738().new Solution().kthLargestValue(new int[][]{{5, 2}, {1, 6}}, 1));
        System.out.println(new KthLargestValue_1738().new Solution1().kthLargestValue(new int[][]{{5, 2}, {1, 6}}, 1));
    }

    /**
     * 前缀和缓存+sort求topk
     * 递推 两层循环O(mn) 排序O(mnlog(mn)) 取大的~= O(mnlog(mn))
     */
    class Solution {
        public int kthLargestValue(int[][] matrix, int k) {
            int m = matrix.length, n = matrix[0].length, len = m * n, index = 0;
            int[][] dp = new int[m + 1][n + 1];
            int[] res = new int[len];
            for (int i = 1; i <= m; i++) {
                for (int j = 1; j <= n; j++) {
                    dp[i][j] = dp[i - 1][j] ^ dp[i][j - 1] ^ dp[i - 1][j - 1] ^ matrix[i - 1][j - 1];
                    res[index++] = dp[i][j];
                }
            }
            Arrays.sort(res);
            return res[len - k];
        }
    }

    /**
     * 第k大使用小根堆存k个元素 当前元素大于堆顶
     * 使用堆优化排序复杂度
     * O(mnlogk)
     */
    class Solution1 {
        public int kthLargestValue(int[][] matrix, int k) {
            int m = matrix.length, n = matrix[0].length;
            PriorityQueue<Integer> minHeap = new PriorityQueue<>(Comparator.naturalOrder());
            int[][] dp = new int[m + 1][n + 1];
            for (int i = 1; i <= m; i++) {
                for (int j = 1; j <= n; j++) {
                    dp[i][j] = dp[i - 1][j] ^ dp[i][j - 1] ^ dp[i - 1][j - 1] ^ matrix[i - 1][j - 1];
                    if (minHeap.size() < k) {//最大的数字的个数<k 直接放入堆中
                        minHeap.offer(dp[i][j]);
                    } else {
                        if (dp[i][j] > minHeap.peek()) {//最大的数字的个数>=k 而且当前数字大于堆底元素则弹出堆顶的小元素 放入当前元素
                            minHeap.poll();
                            minHeap.offer(dp[i][j]);
                        }
                    }
                }
            }
            return minHeap.peek();
        }
    }

    /**
     * 在1的基础上判断 k>m*n/2的情况 转化为求第几 (m*n-k) 小个元素
     */
    class Solution2 {
        public int kthLargestValue(int[][] matrix, int k) {
            int m = matrix.length, n = matrix[0].length;
            PriorityQueue<Integer> minHeap = new PriorityQueue<>(Comparator.naturalOrder());
            int[][] dp = new int[m + 1][n + 1];
            for (int i = 1; i <= m; i++) {
                for (int j = 1; j <= n; j++) {
                    dp[i][j] = dp[i - 1][j] ^ dp[i][j - 1] ^ dp[i - 1][j - 1] ^ matrix[i - 1][j - 1];
                    if (minHeap.size() < k) {//最大的数字的个数<k 直接放入堆中
                        minHeap.offer(dp[i][j]);
                    } else {
                        if (dp[i][j] > minHeap.peek()) {//最大的数字的个数>=k 而且当前数字大于堆底元素则弹出堆顶的小元素 放入当前元素
                            minHeap.poll();
                            minHeap.offer(dp[i][j]);
                        }
                    }
                }
            }
            return minHeap.peek();
        }
    }
}
