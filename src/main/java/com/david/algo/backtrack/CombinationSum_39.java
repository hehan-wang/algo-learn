package com.david.algo.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 39. 组合总和
 * 输入：candidates = [2,3,5], target = 8,
 * 所求解集为：
 * [
 * [2,2,2,2],
 * [2,3,3],
 * [3,5]
 * ]
 */
public class CombinationSum_39 {
    public static void main(String[] args) {
        System.out.println(new CombinationSum_39().new Solution().combinationSum(new int[]{2, 3, 5}, 8));
        System.out.println(new CombinationSum_39().new Solution1().combinationSum(new int[]{2, 3, 5}, 8));
    }

    /**
     * 回溯
     */
    class Solution {
        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            List<List<Integer>> res = new ArrayList<>();
            backtrack(candidates, target, res, new LinkedList<>(), 0);
            return res;
        }

        /**
         * @param candidates 待选数组
         * @param target     目标值 每次-当前选中值
         * @param res        保存结果
         * @param tmp        选中的中间数组
         * @param begin      搜索的初始位置避免重复
         */
        private void backtrack(int[] candidates, int target, List<List<Integer>> res, LinkedList<Integer> tmp, int begin) {
            if (target < 0) return;
            if (target == 0) res.add(new ArrayList<>(tmp));
            for (int i = begin; i < candidates.length; i++) {
                tmp.add(candidates[i]);
                backtrack(candidates, target - candidates[i], res, tmp, i);
                tmp.removeLast();
            }
        }
    }

    /**
     * 再上一个基础上进行
     * <p>
     * 先排序，再减一个数<0 后面更大的数字就不用搜了
     */
    class Solution1 {
        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            List<List<Integer>> res = new ArrayList<>();
            Arrays.sort(candidates);//先排序
            backtrack(candidates, target, res, new LinkedList<>(), 0);
            return res;
        }

        private void backtrack(int[] candidates, int target, List<List<Integer>> res, LinkedList<Integer> tmp, int begin) {
            if (target == 0) res.add(new ArrayList<>(tmp));
            for (int i = begin; i < candidates.length; i++) {
                if (target - candidates[i] < 0) break;//已经<0不处理了
                tmp.add(candidates[i]);
                backtrack(candidates, target - candidates[i], res, tmp, i);
                tmp.removeLast();
            }
        }
    }
}
