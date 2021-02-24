package com.david.algo.binarysearch;

/**
 * 升序排列的整数数组 nums 在预先未知的某个点上进行了旋转（例如， [0,1,2,4,5,6,7] 经旋转后可能变为 [4,5,6,7,0,1,2] ）。
 * <p>
 * 请你在数组中搜索 target ，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/search-in-rotated-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode33 {
    public static void main(String[] args) {
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
//        System.out.println(search(nums, 5));
//        System.out.println(search(nums, 7));
//        System.out.println(search(nums, 1));
//        System.out.println(search(new int[]{1, 3}, 3));
        System.out.println(search(new int[]{1, 3, 5}, 1));
    }

    /**
     * mid切割一定有一边是排序的 nums[低]<nums[高]的一定是排序的
     * 如果在排序范围内二分查找否则在另一边在继续找
     */
    public static int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {//空数组返回null
            return -1;
        }
        int n = nums.length - 1;
        if (nums.length == 1) {//一个元素判断是否相等
            return nums[0] == target ? 0 : -1;
        }
        int low = 0;
        int high = n;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (nums[mid] == target) {//找到退出
                return mid;
            }
            if (nums[0] <= nums[mid]) {//左边有序 一定要加"="号!!!
                if (target >= nums[0] && target < nums[mid]) {//target>=左边界 在左边区间内 一定要加"="号!!!
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else {//右边有序
                if (target > nums[mid] && target <= nums[n]) {//target<=右边界 在右边在区间内 一定要加"="号!!!
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        return -1;
    }
}
