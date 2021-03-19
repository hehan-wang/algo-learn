package com.david.day.d9;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

//2021-01-06
public class MaxSlidingWindow_offer59 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new MaxSlidingWindow_offer59().new Solution().maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3)));
    }

    /**
     * 使用双端 deque 队列头存最大值 窗口滑动的时候 先清理无效值 再加入新值
     * O(n)
     */
    class Solution {
        public int[] maxSlidingWindow(int[] nums, int k) {
            int n = nums.length;
            if (n == 0 || n < k) return new int[0];
            int[] res = new int[n - k + 1];//窗口的个数
            Deque<Integer> deque = new LinkedList<>();
            for (int i = 0; i < n; i++) {
                int window = i - k + 1;
                if (i - k >= 0 && nums[i - k] == deque.peekFirst()) deque.removeFirst();//上个划出窗口的值是最大值的话删除
                while (!deque.isEmpty() && deque.peekLast() < nums[i]) deque.removeLast();//从后向前删除小于当前元素的值
                deque.addLast(nums[i]);
                if (window >= 0) res[window] = deque.peekFirst();
            }
            return res;
        }
    }
}
