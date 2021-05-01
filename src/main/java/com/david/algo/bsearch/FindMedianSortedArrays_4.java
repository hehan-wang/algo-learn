package com.david.algo.bsearch;

/**
 * 输入：nums1 = [1,3], nums2 = [2]
 * 输出：2.00000
 * 解释：合并数组 = [1,2,3] ，中位数 2
 * 思路
 * 1.先合并数组 在求中位数
 * 2.有序就二分 O(logn)
 */
public class FindMedianSortedArrays_4 {

    public static void main(String[] args) {
        System.out.println(1 + 1 * 2);
        System.out.println(1 + 2 >> 1);
    }

    /**
     * 二分法
     * https://leetcode-cn.com/problems/median-of-two-sorted-arrays/solution/he-bing-yi-hou-zhao-gui-bing-guo-cheng-zhong-zhao-/
     * 中位数分割线左边元素 奇数个元素: (m+n/2)+1  偶数个元素m+n/2
     * 分割线左边的总数固定 移动两个数组的边界
     */
    class Solution {
        public double findMedianSortedArrays(int[] nums1, int[] nums2) {
            //1.长度小的改成替换到nums1 减少二分查找的次数
            if (nums1.length > nums2.length) {
                int[] tmp = nums1;
                nums1 = nums2;
                nums2 = tmp;
            }
            int m = nums1.length;
            int n = nums2.length;
            //2.计算左边元素的总个数
            int totalLeft = (m + n + 1) >> 1;
            //3.搜索nums1 找分割线位置
            int left = 0, right = m;
            while (left < right) {
                int m1 = left + ((right - left+1) >> 1);
                int m2 = totalLeft - m1;
                //nums1切分线左边第一个元素>nums2切分线右边第一个元素 此时nums1切分线向左移动
                if (nums1[m1 - 1] > nums2[m2]) right = m1 - 1;
                else left = m1;
            }
            //4.计算中位数 奇数的话取max(nums1左,nums2左)。偶数的话计取平均数(max(num1左,num2左)+min(nums1右,nums2右))/2.0
            int m1 = left, m2 = totalLeft - left;
            int nums1LeftMax = m1 == 0 ? Integer.MIN_VALUE : nums1[m1 - 1];
            int nums1RightMin = m1 == m ? Integer.MAX_VALUE : nums1[m1];
            int nums2LeftMax = m2 == 0 ? Integer.MIN_VALUE : nums2[m2 - 1];
            int nums2RightMin = m2 == n ? Integer.MAX_VALUE : nums2[m2];
            //偶数&1==0
            if (((m + n) & 1) == 0) return (Math.max(nums1LeftMax, nums2LeftMax) + Math.min(nums1RightMin, nums2RightMin)) / 2.0;
            else return Math.max(nums1LeftMax, nums2LeftMax);
        }
    }
}
