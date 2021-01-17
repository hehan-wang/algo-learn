package com.david.com.david.day.d20;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum_15 {
    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> list = new Solution().threeSum(nums);
        System.out.println(list);
    }

    /**
     * 使用双指针夹逼
     * 1.排序
     * 2.边界条件
     * 3.用第一个元素当target
     * 4.定义前后指针 夹逼
     */
    static class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            Arrays.sort(nums);
            List<List<Integer>> res = new ArrayList<>();
            for (int i = 0; i < nums.length - 2; i++) {
                if (nums[i] > 0) break;
                if (i > 0 && nums[i] == nums[i - 1]) continue;
                int j = i + 1, k = nums.length - 1;
                while (j < k) {
                    int sum = nums[i] + nums[j] + nums[k];
                    if (sum > 0) {
                        while (j < k && nums[k] == nums[--k]) ;
                    } else if (sum < 0) {
                        while (j < k && nums[j] == nums[++j]) ;
                    } else {
                        res.add(List.of(nums[i], nums[j], nums[k]));
                        while (j < k && nums[k] == nums[--k]) ;
                        while (j < k && nums[j] == nums[++j]) ;
                    }
                }
            }
            return res;
        }
    }

    static class Solution1 {
        public List<List<Integer>> threeSum(int[] nums) {
            Arrays.sort(nums);
            List<List<Integer>> res = new ArrayList<>();
            for (int i = 0; i < nums.length - 2; i++) {
                if (nums[i] > 0) break;
                if (i > 0 && nums[i] == nums[i - 1]) continue;
                int j = i + 1, k = nums.length - 1;
                while (j < k) {
                    int sum = nums[i] + nums[j] + nums[k];
                    if (sum > 0) {
                        k--;
                    } else if (sum < 0) {
                        j++;
                    } else {
                        res.add(List.of(nums[i], nums[j], nums[k]));
                        k--;
                        j++;
                    }
                }
            }
            return res;
        }
    }
}
