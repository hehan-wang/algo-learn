package com.david.algo.dp;

/**
 * 474. 一和零
 * 输入：strs = ["10", "0001", "111001", "1", "0"], m = 5, n = 3
 * 输出：4
 * 解释：最多有 5 个 0 和 3 个 1 的最大子集是 {"10","0001","1","0"} ，因此答案是 4 。
 * 其他满足题意但较小的子集包括 {"0001","1"} 和 {"10","1","0"} 。{"111001"} 不满足题意，因为它含 4 个 1 ，大于 n 的值 3 。
 * 思路：
 * https://leetcode-cn.com/problems/ones-and-zeroes/solution/dong-tai-gui-hua-zhuan-huan-wei-0-1-bei-bao-wen-ti/
 */
public class FindMaxForm_474 {
    public static void main(String[] args) {
        System.out.println(new FindMaxForm_474().new Solution2().findMaxForm(new String[]{"10", "0001", "111001", "1", "0"}, 5, 3));
//        System.out.println(new FindMaxForm_474().new Solution().findMaxForm(new String[]{"10", "0001", "111001", "1", "0"}, 5, 3));
//        System.out.println(new FindMaxForm_474().new Solution().findMaxForm(new String[]{"10", "0", "1"}, 1, 1));
    }

    /**
     * 动态规划
     * dp[i][j][k] 存strs[0-i]达成m n 所需的最大子集
     * <p>
     * dp[i][j][k]=dp[i-1][j][k] 不考虑当前字符串至少等于i-1
     * if(i>m&&j>n) dp[i][j][k]=max(dp[i-1][j][k],dp[i-1][j-d0][k-d1]+1) 选择当前字符串
     * time: O(len(strs)*m*n)
     * space: O(len(strs)*m*n)
     */
    class Solution {
        public int findMaxForm(String[] strs, int m, int n) {
            int l = strs.length;
            int[][][] dp = new int[l + 1][m + 1][n + 1];
            for (int i = 1; i <= l; i++) {
                //计算0-1个数
                int[] b = new int[2];
                char[] chars = strs[i - 1].toCharArray();
                for (char aChar : chars) b[aChar - '0']++;
                int b0 = b[0], b1 = b[1];
                //递推
                for (int j = 0; j <= m; j++) {
                    for (int k = 0; k <= n; k++) {
                        dp[i][j][k] = dp[i - 1][j][k];
                        if (j >= b0 && k >= b1) dp[i][j][k] = Math.max(dp[i - 1][j][k], dp[i - 1][j - b0][k - b1] + 1);
                    }
                }
            }
            return dp[l][m][n];
        }
    }

    /**
     * 空间优化 由于i只与i-1有关 优化成dp[m][n]
     * dp[i][j]=max(dp[i][j],dp[i-zeros][n]j-ones]+1);
     * 使用倒序遍历 m n为了保证到下一层能使用到上一层的的完整数据
     * <p>
     * time: O(len(strs)*m*n)
     * space: O(m*n)
     * <p>
     * 这题倒序来优化空间我想了很久终于明白了： 1.首先“记录本”不一样了，我本来应该拿三维数组记录的，比如dp[i][m][n]代表前i个字符满足m个0，n个0的最大子集数，这时候我们就顺着来，因为每一个层数我们都会记录，但是递推公式发现只和上一层有关，也就是dp[i][m][n]只和dp[i-1][][]这一层的有关，那么就进行优化。 2.我只用一个二维的“记录本”来记录上一层，也就是dp[m][n]代表的意义是上一层满足m个0和n个1的最大子集数，我没法找到任意一层了，因为我现在只有一个更小的“记录本”，所以我要保证算的过程中，永远能用上一层的数据，我就必须得倒着来，因为正着来的时候，我算dp[m][n] = dp[m-zeros][n-ones]就错了，因为本来要用上一次赋值了的dp[m-zeros][n-ones]结果，你在这一层遍历先赋值了他们，后来才算的dp[m][n]，乱了，上一层数据没了，给你盖住了！ 总之，倒序的目的就是少用一维数组，省下了空间，因为记录那么多层没必要，我只要上一层就ok。
     */
    public class Solution2 {
        public int findMaxForm(String[] strs, int m, int n) {
            int[][] dp = new int[m + 1][n + 1];
            for (String str : strs) {
                //计算0-1
                int[] counts = new int[2];
                char[] chars = str.toCharArray();
                for (char c : chars) counts[c - '0']++;
                int zeros = counts[0], ones = counts[1];
                //倒序递推
                for (int i = m; i >= zeros; i--) {
                    for (int j = n; j >= ones; j--) {
                        dp[i][j] = Math.max(dp[i][j], dp[i - zeros][j - ones] + 1);
                    }
                }
            }
            return dp[m][n];
        }
    }

}
