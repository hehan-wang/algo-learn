package com.david.algo.bsearch;

import java.util.Arrays;

/**
 * 34. 在排序数组中查找元素的第一个和最后一个位置
 * 输入：nums = [5,7,7,8,8,10], target = 8
 * 输出：[3,4]
 */
public class SearchRange_34 {
    public static void main(String[] args) {
//        System.out.println(Arrays.toString(new SearchRange_34().new Solution().searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8)));
        System.out.println(Arrays.toString(new SearchRange_34().new Solution().searchRange(new int[]{2, 2}, 3)));
    }

    /**
     * 思路：
     * 有序就二分 先二分法定位到相等的元素 再左右展开
     * O(logn)
     */
    class Solution {
        public int[] searchRange(int[] nums, int target) {
            if (nums == null || nums.length == 0) return new int[]{-1, -1};//控制空的边界情况
            int n = nums.length, left = 0, right = n - 1, mid = left + ((right - left) >> 1);
            boolean find = false;//判断是否找到了相等数字
            while (left <= right) {
                mid = left + ((right - left) >> 1);//防止right+left超出Integer最大值 使用位运算增加效率
                if (nums[mid] > target) right = mid - 1;
                else if (nums[mid] < target) left = mid + 1;
                else {
                    find = true;
                    break;//找到了推出
                }
            }
            if (!find) return new int[]{-1, -1};
            int l = mid, r = mid;
            while (l - 1 >= 0 && nums[l] == nums[l - 1]) l--;//从中点向左展开
            while (r + 1 <= n - 1 && nums[r] == nums[r + 1]) r++;//从中点向右展开
            return new int[]{l, r};
        }
    }
}
