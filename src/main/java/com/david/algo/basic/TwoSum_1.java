package com.david.algo.basic;

import java.util.Arrays;
import java.util.HashMap;

/**
 * 思路
 * <p>
 * 1.一次遍历，走过的字符存hash表 存在target-nums[i] 直接返回 O(n)
 * 2.暴力法  永远可以穷举两次遍历 O(n^2)
 */
public class TwoSum_1 {
    public static void main(String[] args) {
//        int[] res = new TwoSum_1().new Solution1().twoSum(new int[]{2, 7, 11, 15}, 9);
        int[] res = new TwoSum_1().new Solution().twoSum(new int[]{2, 7, 11, 15}, 9);
        System.out.println(Arrays.toString(res));
    }

    class Solution1 {
        public int[] twoSum(int[] nums, int target) {
            HashMap<Integer, Integer> cache = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                if (cache.containsKey(target - nums[i])) return new int[]{cache.get(target - nums[i]), i};
                cache.put(nums[i], i);
            }
            return new int[0];
        }
    }

    class Solution {
        public int[] twoSum(int[] nums, int target) {
            if (nums == null || nums.length < 2) return new int[0];
            int[] cache = new int[1001];
            for (int i = 0; i < nums.length; i++) {
                if (target - nums[i] >= 0 && cache[target - nums[i]] != 0) return new int[]{cache[target - nums[i]], i};
                cache[nums[i]] = i;
            }
            return new int[0];
        }
    }
}
