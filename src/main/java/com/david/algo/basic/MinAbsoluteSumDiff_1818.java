package com.david.algo.basic;

import java.util.Arrays;

/**
 * 输入：nums1 = [1,7,5], nums2 = [2,3,5]
 * 输出：3
 * 解释：有两种可能的最优方案：
 * - 将第二个元素替换为第一个元素：[1,7,5] => [1,1,5] ，或者
 * - 将第二个元素替换为第三个元素：[1,7,5] => [1,5,5]
 * 两种方案的绝对差值和都是 |1-2| + (|1-3| 或者 |5-3|) + |5-5| = 3
 * <p>
 * <p>
 * 思路：
 * 先计算每个位置的绝对值和sum，然后查找到每个元素能节省的绝对值差的最大值max，sum-max为最终答案
 *
 * @author: david
 * @date: 2021/7/14
 */
public class MinAbsoluteSumDiff_1818 {
    public static void main(String[] args) {

//        int[] arr1 = new int[]{57, 42, 21, 28, 30, 25, 22, 12, 55, 3, 47, 18, 43, 29, 20, 44, 59, 9, 43, 7, 8, 5, 42, 53, 99, 34, 37, 88, 87, 62, 38, 68, 31, 3, 11, 61, 93, 34, 63, 27, 20, 48, 38, 5, 71, 100, 88, 54, 52, 15, 98, 59, 74, 26, 81, 38, 11, 44, 25, 69, 79, 81, 51, 85, 59, 84, 83, 99, 31, 47, 31, 23, 83, 70, 82, 79, 86, 31, 50, 17, 11, 100, 55, 15, 98, 11, 90, 16, 46, 89, 34, 33, 57, 53, 82, 34, 25, 70, 5, 1};
//        int[] arr2 = new int[]{76, 3, 5, 29, 18, 53, 55, 79, 30, 33, 87, 3, 56, 93, 40, 80, 9, 91, 71, 38, 35, 78, 32, 58, 77, 41, 63, 5, 21, 67, 21, 84, 52, 80, 65, 38, 62, 99, 80, 13, 59, 94, 21, 61, 43, 82, 29, 97, 31, 24, 95, 52, 90, 92, 37, 26, 65, 89, 90, 32, 27, 3, 42, 47, 93, 25, 14, 5, 39, 85, 89, 7, 74, 38, 12, 46, 40, 25, 51, 2, 19, 8, 21, 62, 58, 29, 32, 77, 62, 9, 74, 98, 10, 55, 25, 62, 48, 48, 24, 21};

        int[] arr1 = new int[]{53, 48, 14, 71, 31, 55, 6, 80, 28, 19, 15, 40, 7, 21, 69, 15, 5, 42, 86, 15, 11, 54, 44, 62, 9, 100, 2, 26, 81, 87, 87, 18, 45, 29, 46, 100, 20, 87, 49, 86, 14, 74, 74, 52, 52, 60, 8, 25, 21, 96, 7, 90, 91, 42, 32, 34, 55, 20, 66, 36, 64, 67, 44, 51, 4, 46, 25, 57, 84, 23, 10, 84, 99, 33, 51, 28, 59, 88, 50, 41, 59, 69, 59, 65, 78, 50, 78, 50, 39, 91, 44, 78, 90, 83, 55, 5, 74, 96, 77, 46};
        int[] arr2 = new int[]{39, 49, 64, 34, 80, 26, 44, 3, 92, 46, 27, 88, 73, 55, 66, 10, 4, 72, 19, 37, 40, 49, 40, 58, 82, 32, 36, 91, 62, 21, 68, 65, 66, 55, 44, 24, 78, 56, 12, 79, 38, 53, 36, 90, 40, 73, 92, 14, 73, 89, 28, 53, 52, 46, 84, 47, 51, 31, 53, 22, 24, 14, 83, 75, 97, 87, 66, 42, 45, 98, 29, 82, 41, 36, 57, 95, 100, 2, 71, 34, 43, 50, 66, 52, 6, 43, 94, 71, 93, 61, 28, 84, 7, 79, 23, 48, 39, 27, 48, 79};

//        System.out.println(new MinAbsoluteSumDiff_1818().new Solution().minAbsoluteSumDiff(new int[]{1, 7, 5}, new int[]{2, 3, 5}));//3
//        System.out.println(new MinAbsoluteSumDiff_1818().new Solution().minAbsoluteSumDiff(new int[]{1, 28, 21}, new int[]{9, 21, 20}));//9
        System.out.println(new MinAbsoluteSumDiff_1818().new Solution().minAbsoluteSumDiff(arr1, arr2));//3441 3156
        System.out.println("=========================================================================================================");
//        System.out.println(new MinAbsoluteSumDiff_1818().new Solution1().minAbsoluteSumDiff(new int[]{1, 7, 5}, new int[]{2, 3, 5}));//3
//        System.out.println(new MinAbsoluteSumDiff_1818().new Solution1().minAbsoluteSumDiff(new int[]{1, 28, 21}, new int[]{9, 21, 20}));//9
        System.out.println(new MinAbsoluteSumDiff_1818().new Solution1().minAbsoluteSumDiff(arr1, arr2));//3441 3156
    }

    /**
     * 二分法 优化暴力法内层循环使查找O(n)降到O(logn)
     * 1.复制num1,排序
     * 2.遍历num2, 使用二分查找最接近num2的两个元素计算最小绝对值差值.
     * O(nlogn)
     */
    class Solution1 {
        public int minAbsoluteSumDiff(int[] nums1, int[] nums2) {
            int[] sorted = nums1.clone();
            Arrays.sort(sorted);//排序num1复制
            int n = nums1.length;
            long sum = 0, max = 0, mod = (int) 1e9 + 7;//sum存总数 max存最大绝对值能省多少
            for (int i = 0; i < n; i++) {
                int n1 = nums1[i], n2 = nums2[i], originAbs = Math.abs(n1 - n2), minAbs = Integer.MAX_VALUE;
                //二分查找街接近n2的元素
                int left = 0, right = n - 1;
                while (left < right) {
                    int mid = left + ((right - left) >> 1);
                    if (sorted[mid] >= n2) right = mid;
                    else left = mid + 1;
                }
                //取与n2相近的左右最小的绝对值
                minAbs = Math.min(minAbs, Math.abs(n2 - sorted[right]));
                if (right - 1 >= 0) minAbs = Math.min(minAbs, Math.abs(n2 - sorted[right - 1]));

                max = Math.max(max, originAbs - minAbs);
                sum += originAbs;
            }
            return (int) ((sum - max) % mod);
        }
    }

    /**
     * 暴力法
     * O(n^2)
     */
    class Solution {
        public int minAbsoluteSumDiff(int[] nums1, int[] nums2) {
            int sum = 0, max = 0, n = nums1.length, mod = (int) 1e9 + 7;
            for (int i = 0; i < n; i++) {//两次循环看能每个元素最多能节省多少
                int n2 = nums2[i], originAbs = Math.abs(nums1[i] - n2), minAbs = Integer.MAX_VALUE;
                for (int j = 0; j < n; j++) minAbs = Math.min(minAbs, Math.abs(n2 - nums1[j]));
                max = Math.max(max, originAbs - minAbs);
                sum += originAbs;   //abs求和
            }
            return (sum - max) % mod;
        }
    }
}
