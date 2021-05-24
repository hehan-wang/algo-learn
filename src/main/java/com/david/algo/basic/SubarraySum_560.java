package com.david.algo.basic;

import java.util.HashMap;

/**
 * 560. 和为K的子数组
 * 输入:nums = [1,1,1], k = 2
 * 输出: 2 , [1,1] 与 [1,1] 为两种不同的情况。
 */
public class SubarraySum_560 {
    public static void main(String[] args) {
        System.out.println(new SubarraySum_560().new Solution().subarraySum(new int[]{1, 1, 1}, 2));//2
//        System.out.println(new SubarraySum_560().new Solution1().subarraySum(new int[]{1, 1, 1}, 2));//2
        System.out.println(new SubarraySum_560().new Solution1().subarraySum(new int[]{3, 4, 7, 2, -3, 1, 4, 2}, 7));//6
//        System.out.println(new SubarraySum_560().new Solution().subarraySum(new int[]{1, 2, 3}, 3));//2
    }

    /**
     * 暴力法 枚举左右边界
     * O(n^2)
     */
    class Solution {
        public int subarraySum(int[] nums, int k) {
            int res = 0, n = nums.length;
            for (int i = 0; i < n; i++) {
                int sum = 0;
                for (int j = i; j < n; j++) {
                    sum += nums[j];
                    if (sum == k) res++;
                }
            }
            return res;
        }
    }

    /**
     * 思路
     * sum(j)- sum(i-1)=k
     * >>sum(i-1)=sum(j)-k
     *
     * 前缀和
     * 使用map<int,int>存储 前缀和与次数
     * O(n)
     */
    class Solution1 {
        public int subarraySum(int[] nums, int k) {
            HashMap<Integer, Integer> map = new HashMap<>();
            map.put(0, 1);//下标0 前缀和0 存在1次
            int pre = 0, count = 0;
            for (int num : nums) {
                pre += num;
                if (map.containsKey(pre - k)) {//截止到数组当前位置，符合pre-k 的前缀和次数
                    count += map.get(pre - k);
                }
                map.put(pre, map.getOrDefault(pre, 0) + 1);//记录前缀和次数
            }
            return count;
        }
    }
}
