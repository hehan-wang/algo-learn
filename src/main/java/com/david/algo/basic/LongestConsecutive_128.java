package com.david.algo.basic;

import java.util.Arrays;
import java.util.HashSet;

/**
 * 128. 最长连续序列
 * 输入：nums = [100,4,200,1,3,2]
 * 输出：4
 * 解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4。
 * <p>
 * 输入：nums = [0,3,7,2,5,8,4,6,0,1]
 * 输出：9
 */
public class LongestConsecutive_128 {
    public static void main(String[] args) {
        System.out.println(new LongestConsecutive_128().new Solution().longestConsecutive(new int[]{100, 4, 200, 1, 3, 2}));//4
        System.out.println(new LongestConsecutive_128().new Solution().longestConsecutive(new int[]{0, 3, 7, 2, 5, 8, 4, 6, 0, 1}));//9
        System.out.println(new LongestConsecutive_128().new Solution().longestConsecutive(new int[]{1, 2, 0, 1}));//3
        System.out.println("----------------------------------------");
        System.out.println(new LongestConsecutive_128().new Solution1().longestConsecutive(new int[]{100, 4, 200, 1, 3, 2}));//4
        System.out.println(new LongestConsecutive_128().new Solution1().longestConsecutive(new int[]{0, 3, 7, 2, 5, 8, 4, 6, 0, 1}));//9
        System.out.println(new LongestConsecutive_128().new Solution1().longestConsecutive(new int[]{1, 2, 0, 1}));//3
    }

    /**
     * 思路
     * 1.排序
     * 2.扫描
     * O(nlogn)
     */
    class Solution {
        public int longestConsecutive(int[] nums) {
            if (nums == null || nums.length == 0) return 0;
            int max = 0, count = 0;
            Arrays.sort(nums);
            for (int i = 1; i < nums.length; i++) {
                if (nums[i] == nums[i - 1]) continue;
                if ((nums[i] - nums[i - 1]) == 1) count++;//比前一个大1 count++
                else count = 0;//跟前一个相等count不动 跟前一个不等清零
                max = Math.max(max, count);
            }
            return max + 1;
        }
    }

    /**
     * 使用set去重
     * O(n)
     */
    class Solution1 {
        public int longestConsecutive(int[] nums) {
            int max = 0;
            if (nums == null || nums.length == 0) return max;
            HashSet<Integer> set = new HashSet<>();
            for (int num : nums) set.add(num);
            for (int num : nums) {
                if (set.contains(num - 1)) continue;//包含比num小的 此时num不可能为第一个元素
                int len = 0;
                while (set.contains(num++)) len++;//找当前num开头最长len
                max = Math.max(max, len);
            }
            return max;
        }
    }
}
