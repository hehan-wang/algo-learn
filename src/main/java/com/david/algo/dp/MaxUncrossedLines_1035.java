package com.david.algo.dp;

import java.util.ArrayList;

/**
 * 1035. 不相交的线
 * 输入：nums1 = [1,4,2], nums2 = [1,2,4]
 * 输出：2
 * 解释：可以画出两条不交叉的线，如上图所示。
 * 但无法画出第三条不相交的直线，因为从 nums1[1]=4 到 nums2[2]=4 的直线将与从 nums1[2]=2 到 nums2[1]=2 的直线相交。
 * <p>
 */
public class MaxUncrossedLines_1035 {
    public static void main(String[] args) {
        System.out.println(new MaxUncrossedLines_1035().new Solution().maxUncrossedLines(new int[]{1, 4, 2}, new int[]{1, 2, 4}));
    }

    /**
     * 想要线不想交 相对位置一致
     * 转化为最长公共子序列问题 "142" "124"
     * dp存nums1[0:i] nums2[0:j] 最长子序列
     * if nums1[i]==nums2[j]  dp[i][j]=dp[i-1][j-1]+1
     * else dp[i][j]=max(dp[i][j-1],dp[i-1][j])
     * 初始情况i/j=0 表示空串 空串和其他的公共子序列长度为0 数组默认值为0 不用处理
     * time:O(mn)
     * space:O(mn)
     */
    class Solution {
        public int maxUncrossedLines(int[] nums1, int[] nums2) {
            int m = nums1.length, n = nums2.length;
            int[][] dp = new int[m + 1][n + 1];
            for (int i = 1; i <= m; i++) {
                for (int j = 1; j <= n; j++) {
                    if (nums1[i - 1] == nums2[j - 1]) dp[i][j] = dp[i - 1][j - 1] + 1;
                    else dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
            return dp[m][n];
        }
    }
}
