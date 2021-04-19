package com.david.day.d8;

import java.util.Arrays;
import java.util.HashMap;

/**
 * 输入：nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出：[2,2]
 * 思路
 * 1. num1 字符数量放入hash表 遍历2 字符存在-1 存在的话放入结果
 * 2. 先排序 双指针遍历两个数组 相等加入结果 不等移动当前元素小的
 * <p>
 * 进阶
 * nums2很大不能加载到内存中只能使用hash法 分词读入nums2的一部分并行查找
 */
public class Intersect_350 {
    public static void main(String[] args) {
//        System.out.println(Arrays.toString(new Intersect_250().new Solution().intersect(new int[]{1, 2, 2, 1}, new int[]{2, 2})));
        System.out.println(Arrays.toString(new Intersect_350().new Solution().intersect(new int[]{4, 9, 5}, new int[]{9, 4, 9, 8, 4})));
        System.out.println(Arrays.toString(new Intersect_350().new Solution1().intersect(new int[]{4, 9, 5}, new int[]{9, 4, 9, 8, 4})));
    }

    /**
     * 排序+双指针
     * O(mlogm+nlogn)
     */
    class Solution1 {
        public int[] intersect(int[] nums1, int[] nums2) {
            Arrays.sort(nums1);
            Arrays.sort(nums2);
            int i1 = 0, i2 = 0, i = 0;
            int[] interaction = new int[Math.min(nums1.length, nums2.length)];
            while (i1 < nums1.length && i2 < nums2.length) {
                if (nums1[i1] < nums2[i2]) {
                    i1++;
                } else if (nums1[i1] > nums2[i2]) {
                    i2++;
                } else {
                    interaction[i++] = nums1[i1];
                    i1++;
                    i2++;
                }
            }
            return Arrays.copyOfRange(interaction, 0, i);
        }
    }

    /**
     * hash表
     * O(m+n)
     */
    class Solution {
        public int[] intersect(int[] nums1, int[] nums2) {
            //num1 为小的
            int[] min = nums1.length < nums2.length ? nums1 : nums2;
            int[] max = nums1.length >= nums2.length ? nums1 : nums2;
            int[] interaction = new int[min.length];
            HashMap<Integer, Integer> cache = new HashMap<>(min.length);
            int index = 0;
            for (int i : min) {
                int count = cache.getOrDefault(i, 0) + 1;
                cache.put(i, count);
            }
            for (int i : max) {
                Integer count = cache.get(i);
                if (count != null && count > 0) {
                    interaction[index++] = i;
                    cache.put(i, count - 1);
                }
            }
            return Arrays.copyOfRange(interaction, 0, index);
        }
    }
}
