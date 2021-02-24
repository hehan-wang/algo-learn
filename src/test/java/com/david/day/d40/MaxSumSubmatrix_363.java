package com.david.day.d40;

public class MaxSumSubmatrix_363 {
    public static void main(String[] args) {
        System.out.println(new Solution().maxSumSubmatrix(new int[][]{{1, 0, 1}, {0, -2, 3}}, 2));
//        System.out.println(new Solution1().maxSumSubmatrix(new int[][]{{1, 0, 1}, {0, -2, 3}}, 2));
//        System.out.println(new Solution2().maxSumSubmatrix(new int[][]{{1, 0, 1}, {0, -2, 3}}, 2));
        System.out.println(new Solution2().maxSumSubmatrix(new int[][]{{2, 2, -1}}, 3));
//        System.out.println(new Solution0().maxSumSubmatrix(new int[][]{{1, 0, 1}, {0, -2, 3}}, 2));
    }


    static class Solution2 {
        public int maxSumSubmatrix(int[][] matrix, int k) {
            int max = Integer.MIN_VALUE, cols = matrix[0].length, rows = matrix.length;
            for (int l = 0; l < cols; l++) {//左边界
                int[] rowSum = new int[rows];//每次左边界需要重新初始化
                for (int r = l; r < cols; r++) {//右边界大于等于左边界
                    for (int i = 0; i < rows; i++) {//遍历行取和
                        rowSum[i] += matrix[i][r];
                    }
                    max = Math.max(max, dpmax(rowSum, k));
                    if (max == k) return k;//当max==k 不可能存在更大的max了 直接返回减少循环次数
                }
            }
            return max;
        }

        /**
         * 取数组不大于k的最大值
         * 先使用53题方法取最大值 取不到使用暴力法
         */
        private int dpmax(int[] arr, int k) {
            int rowSum = arr[0], rowMax = rowSum;
            for (int i = 1; i < arr.length; i++) {//前面的和>0才取，前面都是负数的果断抛弃，用新值必然>=前值
                if (rowSum > 0) rowSum += arr[i];
                else rowSum = arr[i];
                if (rowSum > rowMax) rowMax = rowSum;
//                if (sum == k) return k;//减少循环次数
            }
            if (rowMax <= k) return rowMax;//找到小于k的最大值
            //否则暴力求解遍历所有左右边界
            rowMax = Integer.MIN_VALUE;
            for (int l = 0; l < arr.length; l++) {
                rowSum = 0;
                for (int r = l; r < arr.length; r++) {
                    rowSum += arr[r];
                    if (rowSum > rowMax && rowSum <= k) rowMax = rowSum;
                    if (rowMax == k) return rowMax;
                }
            }
            return rowMax;
        }
    }


    //solution1 i1 j1移动后前面的可以丢弃掉 dp数组压缩成2维数组
    static class Solution1 {
        public int maxSumSubmatrix(int[][] matrix, int k) {
            int max = Integer.MIN_VALUE, cols = matrix.length, rows = matrix[0].length;
            for (int i1 = 1; i1 <= cols; i1++) {
                for (int j1 = 1; j1 <= rows; j1++) {
                    int[][] dp = new int[cols + 1][rows + 1];
                    dp[i1][j1] = matrix[i1 - 1][j1 - 1];//每次初始化 i1 j1到i1 j1
                    for (int i2 = i1; i2 <= cols; i2++) {//右下角坐标大于等于左上角
                        for (int j2 = j1; j2 <= rows; j2++) {
                            dp[i2][j2] = dp[i2 - 1][j2] + dp[i2][j2 - 1] - dp[i2 - 1][j2 - 1] + matrix[i2 - 1][j2 - 1];
                            if (dp[i2][j2] <= k && dp[i2][j2] > max) max = dp[i2][j2];
                        }
                    }
                }
            }
            return max;
        }
    }

    /**
     * 暴力法
     * https://leetcode-cn.com/problems/max-sum-of-rectangle-no-larger-than-k/solution/javacong-bao-li-kai-shi-you-hua-pei-tu-pei-zhu-shi/
     * dp[i1][j1][i2][j2]=dp[i1][j1][i2][j2-1]+dp[i1][j1][i2-1][j2]+dp[i1][j1][i2-1][j2-1]+matrix[i2-1][j2-1]
     * dp=左边+上边-公共+右下角格子
     * time:O(m2n2)
     * space:O(m2n2)
     * 内存超限
     */
    static class Solution {
        public int maxSumSubmatrix(int[][] matrix, int k) {
            int max = Integer.MIN_VALUE, cols = matrix.length, rows = matrix[0].length;
            int[][][][] dp = new int[cols + 1][rows + 1][cols + 1][rows + 1];
            for (int i1 = 1; i1 <= cols; i1++) {
                for (int j1 = 1; j1 <= rows; j1++) {
                    dp[i1][j1][i1][j1] = matrix[i1 - 1][j1 - 1];//初始化 i1 j1到i1 j1
                    for (int i2 = i1; i2 <= cols; i2++) {//右下角坐标大于等于左上角
                        for (int j2 = j1; j2 <= rows; j2++) {
                            dp[i1][j1][i2][j2] = dp[i1][j1][i2 - 1][j2] + dp[i1][j1][i2][j2 - 1] - dp[i1][j1][i2 - 1][j2 - 1] + matrix[i2 - 1][j2 - 1];
                            if (dp[i1][j1][i2][j2] <= k && dp[i1][j1][i2][j2] > max) max = dp[i1][j1][i2][j2];
                        }
                    }
                }
            }
            return max;
        }
    }


}
