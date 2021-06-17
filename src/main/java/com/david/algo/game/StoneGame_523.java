package com.david.algo.game;

/**
 * https://leetcode-cn.com/problems/stone-game/solution/gong-shui-san-xie-jing-dian-qu-jian-dp-j-wn31/
 * 输入：nums = [23,2,4,6,7], k = 6
 * 输出：true
 * 解释：[2,4] 是一个大小为 2 的子数组，并且和为 6 。
 */
public class StoneGame_523 {
    public static void main(String[] args) {
        System.out.println(new StoneGame_523().new Solution().stoneGame(new int[]{23, 2, 4, 6, 7}));
    }

    //dp
    class Solution {
        public boolean stoneGame(int[] ps) {
            int n = ps.length;
            int[][] f = new int[n + 2][n + 2];
            for (int len = 1; len <= n; len++) { // 枚举区间长度
                for (int l = 1; l + len - 1 <= n; l++) { // 枚举左端点
                    int r = l + len - 1; // 计算右端点
                    int a = ps[l - 1] - f[l + 1][r];
                    int b = ps[r - 1] - f[l][r - 1];
                    f[l][r] = Math.max(a, b);
                }
            }
            return f[1][n] > 0;
        }
    }

    /**
     * 博弈论 先手肯定赢
     */
    class Solution1 {
        public boolean checkSubarraySum(int[] nums, int k) {
            return true;
        }
    }
}
