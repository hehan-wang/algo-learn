package com.david.algo.basic;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 数组中的第K个最大元素
 */
public class FindKthLargest_215 {
    public static void main(String[] args) {
        System.out.println(new FindKthLargest_215().new Solution1().findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 2));
        System.out.println(new FindKthLargest_215().new Solution().findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 2));
    }

    //排序 取第k个元素
    class Solution1 {
        public int findKthLargest(int[] nums, int k) {
            if (k > nums.length) return -1;
            Arrays.sort(nums);
            return nums[nums.length - k];
        }
    }

    /**
     * 推荐用法！！！！！
     * 使用小顶堆O(logk)
     * 最大最小值问题 首先考虑heap堆。Java中的PriorityQueue是堆的实现。
     * 思路：
     * 使用最小堆存topk个元素
     * 1.每个元素入堆 按照从小到大排列 堆顶是最小元素
     * 2.当堆的长度大于k的时候 移除掉堆顶 留下的就是k个最大的数字
     */
    class Solution0 {
        public int findKthLargest(int[] nums, int k) {
            PriorityQueue<Integer> minHeap = new PriorityQueue<>();
            for (int num : nums) {
                minHeap.add(num);
                if (minHeap.size() > k) {//大于k的话把最小元素poll掉留下的就是k个最大元素
                    minHeap.poll();
                }
            }
            return minHeap.peek();
        }
    }

    //使用大顶堆 O(nlogn)
    class Solution {
        public int findKthLargest(int[] nums, int k) {
            int res = -1;
            if (k > nums.length) return res;
            PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
            for (int num : nums) {
                maxHeap.add(num);
            }
            while (k-- > 0) {
                res = maxHeap.poll();
            }
            return res;
        }
    }
}
