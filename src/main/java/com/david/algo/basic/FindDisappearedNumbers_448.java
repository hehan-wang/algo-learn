package com.david.algo.basic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * 448. 找到所有数组中消失的数字
 * 输入:
 * [4,3,2,7,8,2,3,1]
 * <p>
 * 输出:
 * [5,6]
 */
public class FindDisappearedNumbers_448 {
    public static void main(String[] args) {
        System.out.println(new FindDisappearedNumbers_448().new Solution().findDisappearedNumbers(new int[]{4, 3, 2, 7, 8, 2, 3, 1}));
        System.out.println(new FindDisappearedNumbers_448().new Solution1().findDisappearedNumbers(new int[]{4, 3, 2, 7, 8, 2, 3, 1}));
    }

    /**
     * 使用set去重 O(n)
     */
    class Solution {
        public List<Integer> findDisappearedNumbers(int[] nums) {
            Set<Integer> set = Arrays.stream(nums).boxed().collect(Collectors.toSet());
            return IntStream.rangeClosed(1, nums.length).boxed().filter(n -> !set.contains(n)).collect(Collectors.toList());
        }
    }

    /**
     * 原地标记
     * 1.先遍历一次 nums, nums[nums[i]]+n
     * 2.在遍历一次1~n 小于n的就是没有的元素 存储在结果集中
     * time:O(n)
     */
    class Solution1 {
        public List<Integer> findDisappearedNumbers(int[] nums) {
            int n = nums.length;//最大下标
            for (int num : nums) {
                int x = (num - 1) % n;//求出当前节点应该去的下标
                nums[x] += n;//增加n是为了取模后还可以保留原始信息
            }
            List<Integer> res = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                if (nums[i] <= n) res.add(i + 1);//小于等于n为没有增加过 把下标+1变成数字放入结果集
            }
            return res;
        }
    }
}
