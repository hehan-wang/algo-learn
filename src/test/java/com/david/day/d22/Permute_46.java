package com.david.day.d22;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class Permute_46 {
    public static void main(String[] args) {
        List<List<Integer>> res = new Solution().permute(new int[]{1, 2, 3});
        System.out.println(res);
    }

    static class Solution {
        public List<List<Integer>> permute(int[] nums) {
            List<List<Integer>> res = new ArrayList<>();
            if (nums == null) return res;
            ArrayDeque<Integer> path = new ArrayDeque<>();
            boolean[] used = new boolean[nums.length];
            dfs(res, nums, 0, path, used);
            return res;
        }

        private void dfs(List<List<Integer>> res, int[] nums, int depth, ArrayDeque<Integer> path, boolean[] used) {
            //terminator
            if (depth == nums.length) {
                res.add(new ArrayList<>(path));
                return;
            }
            for (int i = 0; i < nums.length; i++) {
                //process
                if (used[i]) continue;
                path.addLast(nums[i]);
                used[i] = true;
                //drill down
                dfs(res, nums, depth + 1, path, used);
                //reverse states
                path.removeLast();
                used[i] = false;
            }
        }
    }
}
