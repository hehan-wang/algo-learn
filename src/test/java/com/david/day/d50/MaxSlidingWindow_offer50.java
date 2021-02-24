package com.david.day.d50;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 * 思路
 * 1.大顶堆
 * 2.deque 顺序队列 对头存最大值
 */
public class MaxSlidingWindow_offer50 {
    public static void main(String[] args) {
//        int[] ints = new Solution().maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3);
//        int[] ints = new Solution1().maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3);
        int[] ints = new Solution2().maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3);
        Arrays.stream(ints).forEach(System.out::println);
    }

    static class Solution2 {
        public int[] maxSlidingWindow(int[] nums, int k) {
            if (nums == null || nums.length == 0 || k == 0 || nums.length < k) return new int[0];
            int n = nums.length;
            Deque<Integer> deque = new LinkedList<>();
            int[] res = new int[n - k + 1];
            for (int j = 0; j < n; j++) {
                int i = j + 1 - k;//窗口第一个下标
                if (i > 0 && deque.peekFirst() == nums[i - 1]) deque.removeFirst();//第一个元素超出窗口 剔除掉
                while (!deque.isEmpty() && deque.peekLast() < nums[j]) deque.removeLast();//删除小于当前值的元素
                deque.addLast(nums[j]);
                if (i >= 0) res[i] = deque.peekFirst();//构成窗口后放入结果数组
            }
            return res;
        }
    }

    /**
     * 使用deque 存window 队头存最大数字
     */
    static class Solution1 {
        public int[] maxSlidingWindow(int[] nums, int k) {
            if (nums == null || nums.length == 0 || k == 0 || nums.length < k) return new int[0];
            int n = nums.length;
            int[] res = new int[n - k + 1];
            Deque<Integer> deque = new LinkedList<>();
            for (int i = 0; i < k; i++) {//未成窗口
                while (!deque.isEmpty() && deque.peekLast() < nums[i]) deque.removeLast();
                deque.addLast(nums[i]);
            }
            res[0] = deque.peekFirst();
            for (int i = k; i < n; i++) {//已成窗口
                if (deque.peekFirst() == nums[i - k]) deque.removeFirst();
                while (!deque.isEmpty() && deque.peekLast() < nums[i]) deque.removeLast();
                deque.addLast(nums[i]);
                res[i - k + 1] = deque.peekFirst();
            }
            return res;
        }
    }

    /**
     * heap
     * 1.使用heap大顶堆 存 [元素,下标]
     * 2.先遍历一个窗口 元素放入堆中
     * 2.再遍历剩余元素 元素放入堆中 当最大值下标超出边界了再剔除 减少heap的维护
     */
    static class Solution {
        public int[] maxSlidingWindow(int[] nums, int k) {
            if (nums == null || k == 0 || nums.length == 0 || nums.length < k) return new int[0];
            PriorityQueue<int[]> maxHeap = new PriorityQueue<>(((o1, o2) -> o1[0] != o2[0] ? o2[0] - o1[0] : o2[1] - o1[1]));
            int n = nums.length;
            int[] res = new int[n - k + 1];
            for (int i = 0; i < k; i++) {
                maxHeap.offer(new int[]{nums[i], i});
            }
            res[0] = maxHeap.peek()[0];
            for (int i = k; i < n; i++) {
                maxHeap.offer(new int[]{nums[i], i});
                int j = i - k + 1;
                while (maxHeap.peek()[1] < j) maxHeap.poll();//删除掉所有窗口外的最大值
                res[j] = maxHeap.peek()[0];
            }
            return res;
        }
    }
}
