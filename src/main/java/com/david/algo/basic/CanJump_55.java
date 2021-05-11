package com.david.algo.basic;

/**
 * 55. 跳跃游戏
 * 贪心算法
 * time:O(n)
 * 遍历数组
 */
public class CanJump_55 {
    public static void main(String[] args) {
        System.out.println(new CanJump_55().new Solution().canJump(new int[]{3, 2, 1, 0, 4}));
    }

    /**
     * 使用贪心 由于可以跳1-nums[i]步数，所以维护max为最远距离，当i>max 证明到不了max后面的格子了返回false，max到末尾了直接返回true
     */
    class Solution {
        public boolean canJump(int[] nums) {
            int max = 0;
            for (int i = 0; i < nums.length; i++) {
                if (i > max) return false;//证明跳不到后面了
                max = Math.max(max, i + nums[i]);
                if (max >= nums.length - 1) return true;//能跳到末尾直接返回
            }
            return false;
        }
    }
}
