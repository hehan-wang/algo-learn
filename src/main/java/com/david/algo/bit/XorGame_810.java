package com.david.algo.bit;

/**
 * 810. 黑板异或游戏
 */
public class XorGame_810 {
    public static void main(String[] args) {
        System.out.println(new XorGame_810().new Solution().xorGame(new int[]{6, 5, 0, 0, 0, 0}));
        System.out.println(new XorGame_810().new Solution().xorGame(new int[]{6, 0, 0, 0, 0, 0}));
        System.out.println(new XorGame_810().new Solution().xorGame(new int[]{6, 0, 0, 0, 0}));
        System.out.println(new XorGame_810().new Solution().xorGame(new int[]{1, 1, 2}));
    }

    /**
     * https://leetcode-cn.com/problems/chalkboard-xor-game/solution/jian-dan-de-bang-ni-li-jie-zhe-dao-ti-by-kaxa/
     * 1.偶数的时候alice必胜
     * 2.奇数的时候必须开始就异或为0 alice才能赢
     */
    class Solution {
        public boolean xorGame(int[] nums) {
            int n = nums.length, x = 0;
            if ((n & 1) == 0) return true;//偶数赢
            for (int num : nums) x ^= num;
            return x == 0;
        }
    }
}
