package com.david.day.d70;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class MaxSlidingWindow_239 {
    public static void main(String[] args) {
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int[] max = new Solution().maxSlidingWindow(nums, 3);
        System.out.println(Arrays.toString(max));
    }

    /**
     * 使用deque存最大值 1.当对头划出窗口删除掉该元素 2.尾部删除小于当前值的元素
     */
    static class Solution {
        public int[] maxSlidingWindow(int[] nums, int k) {
            if (nums == null || nums.length == 0 || k == 0 || nums.length < k) return new int[0];
            int n = nums.length;
            Deque<Integer> deque = new ArrayDeque<>();
            int[] res = new int[n - k + 1];
            for (int i = 0; i < n; i++) {
                int j = i - k + 1;//结果下标
                if (j > 0 && !deque.isEmpty() && deque.peekFirst() == nums[j - 1]) deque.removeFirst();//1.
                while (!deque.isEmpty() && deque.peekLast() < nums[i]) deque.removeLast();//2.
                deque.addLast(nums[i]);
                if (j >= 0 && !deque.isEmpty()) res[j] = deque.peekFirst();
            }
            return res;
        }
    }
}
