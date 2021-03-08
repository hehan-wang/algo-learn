package com.david.day.d61;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum_15 {
    public static void main(String[] args) {
        System.out.println(new Solution().threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
    }

    /**
     * 双指针夹逼法
     */
    static class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            List<List<Integer>> res = new ArrayList<>();
            if (nums == null || nums.length < 3) return res;
            Arrays.sort(nums);
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
                        while (j < k && nums[j] == nums[++j]) ;
                        while (j < k && nums[k] == nums[--k]) ;
                    }
                }
            }
            return res;
        }
    }
}
