package com.david.algo.dp;

/**
 * 接雨水
 * <p>
 * 输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出：6
 * 解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。
 */
public class Trap_42 {
    public static void main(String[] args) {
        int[] arr = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(new Trap_42().new Solution().trap(arr));
        System.out.println(new Trap_42().new Solution1().trap(arr));
    }

    /**
     * 动态规划 其实就是在按列求最大的暴力法基础上增加了对左右边界最大值的缓存
     * O(3*n)->O(n)
     * O(3*n)->O(n)
     */
    class Solution1 {
        public int trap(int[] height) {
            if (height == null || height.length == 0) return 0;
            int res = 0, n = height.length;
            int[] maxLeft = new int[n], maxRight = new int[n];
            maxLeft[0] = height[0];//初始化
            for (int i = 1; i < n; i++) {//从前向后递推
                maxLeft[i] = Math.max(height[i], maxLeft[i - 1]);
            }
            maxRight[n - 1] = height[n - 1];//初始化
            for (int i = n - 2; i >= 0; i--) {//从后向前递推
                maxRight[i] = Math.max(height[i], maxRight[i + 1]);
            }
            for (int i = 1; i < n - 1; i++) {
                res += Math.min(maxLeft[i], maxRight[i]) - height[i];
            }
            return res;
        }
    }

    /**
     * 暴力法
     * 每个元素求左右最大高度
     * res+=min(leftHeight,rightHeight)-height[i]
     * time:O(n^2)
     */
    class Solution {
        public int trap(int[] height) {
            int res = 0;
            for (int i = 1; i < height.length - 1; i++) {
                int maxLeft = 0, maxRight = 0;
                for (int j = i; j >= 0; j--) {//左边界
                    maxLeft = Math.max(maxLeft, height[j]);
                }
                for (int j = i; j < height.length; j++) {//右边界
                    maxRight = Math.max(maxRight, height[j]);
                }
                res += Math.min(maxLeft, maxRight) - height[i];
            }
            return res;
        }
    }
}
