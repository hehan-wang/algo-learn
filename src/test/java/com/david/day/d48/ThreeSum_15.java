package com.david.day.d48;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum_15 {
    public static void main(String[] args) {
        System.out.println(new Solution().threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
    }

    static class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            List<List<Integer>> res = new ArrayList<>();
            Arrays.sort(nums);
            for (int i = 0; i < nums.length - 2; i++) {//留出双指针位置
                if (nums[i] > 0) break;
                if (i > 0 && nums[i - 1] == nums[i]) continue;//重复的target直接跳过
                int j = i + 1, k = nums.length - 1;
                while (j < k) {
                    int sum = nums[i] + nums[j] + nums[k];
                    if (sum < 0) {
                        while (j < k && nums[j] == nums[++j]) ;//sum小于0
                    } else if (sum > 0) {
                        while (j < k && nums[k] == nums[--k]) ;
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
