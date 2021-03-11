package com.david.day.d67;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Permute_46 {
    public static void main(String[] args) {
        System.out.println(new Solution().permute(new int[]{1, 2, 3}));
    }

    //dfs+回溯
    static class Solution {
        public List<List<Integer>> permute(int[] nums) {
            boolean[] used = new boolean[nums.length];
            List<List<Integer>> res = new ArrayList<>();
            Deque<Integer> deque = new LinkedList<>();
            dfs(res, nums, 0, nums.length, used, deque);
            return res;
        }

        private void dfs(List<List<Integer>> res, int[] nums, int depth, int n, boolean[] used, Deque<Integer> deque) {
            if (depth == n) {
                res.add(new ArrayList<>(deque));
                return;
            }
            for (int i = 0; i < nums.length; i++) {
                if (used[i]) continue;
                used[i] = true;
                deque.addLast(nums[i]);
                dfs(res, nums, depth + 1, n, used, deque);
                used[i] = false;
                deque.removeLast();
            }
        }
    }
}
