package com.david.com.david.day.d41;

public class Search_33 {
    public static void main(String[] args) {
        System.out.println(new Solution().search(new int[]{4, 5, 6, 7, 0, 1, 2}, 0));
    }

    //使用二分查找
    static class Solution {
        public int search(int[] nums, int target) {
            if (nums == null || nums.length == 0) return -1;
            int n = nums.length - 1;
            int low = 0, high = n;
            while (low <= high) {
                int mid = low + ((high - low) >> 1);
                if (target == nums[mid]) return mid;//找到退出
                if (nums[0] <= nums[mid]) {//左边有序
                    if (target >= nums[0] && target < nums[mid]) {
                        high = mid - 1;
                    } else {
                        low = mid + 1;
                    }
                } else {
                    if (target > nums[mid] && target <= nums[n]) {
                        low = mid + 1;
                    } else {
                        high = mid - 1;
                    }
                }
            }
            return -1;
        }
    }
}
