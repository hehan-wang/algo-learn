package com.david.algo.dp;

/**
 * 1269. 停在原地的方案数
 * <p>
 * 输入：steps = 3, arrLen = 2
 * 输出：4
 * 解释：3 步后，总共有 4 种不同的方法可以停在索引 0 处。
 * 向右，向左，不动
 * 不动，向右，向左
 * 向右，不动，向左
 * 不动，不动，不动
 * https://leetcode-cn.com/problems/number-of-ways-to-stay-in-the-same-place-after-some-steps/solution/java-jing-dian-dong-tai-gui-hua-er-wei-y-t4n2/
 */
public class NumWays_1269 {
    public static void main(String[] args) {
        System.out.println(new NumWays_1269().new Solution().numWays(27, 7));
    }

    /**
     * 定义dp[i][j]为 走i步,到达j长度的次数
     * dp[i][j]=dp[i-1][j-1]+dp[i-1][j+1]+dp[i-1][j] //从上一步走上来 左走，不动，右走
     * 边界情况另算
     * time:O(max*steps)
     * space:(max*steps)
     */
    class Solution {
        public int numWays(int steps, int arrLen) {
            int max = Math.min(steps / 2 + 1, arrLen - 1), mod = (int) 1e9 + 7;//由于最远能走steps/2 否则就走不回来了
            int[][] dp = new int[steps + 1][max + 1];
            dp[0][0] = 1;//走0次不动的话可以走到0；
            for (int i = 1; i <= steps; i++) {
                for (int j = 0; j <= max; j++) {
                    if (j == 0) dp[i][j] = (dp[i - 1][j] + dp[i - 1][j + 1]) % mod;//当j==0 在左边界的时候不能从左边走过来
                    else if (j == max) dp[i][j] = (dp[i - 1][j] + dp[i - 1][j - 1]) % mod;  //当 j==max 在右边界的时候不能从右边走过来
                    else dp[i][j] = ((dp[i - 1][j] + dp[i - 1][j - 1]) % mod + dp[i - 1][j + 1]) % mod;
                }
            }
            return dp[steps][0];//走steps次回到0的位置
        }
    }


}
