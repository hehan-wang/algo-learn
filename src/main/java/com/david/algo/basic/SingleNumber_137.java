package com.david.algo.basic;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 给你一个整数数组 nums ，除某个元素仅出现 一次 外，其余每个元素都恰出现 三次 。请你找出并返回那个只出现了一次的元素。
 * 输入：nums = [2,2,3,2]
 * 输出：3
 * 思路
 * 1.遍历一次数字次数存map中遍历map找出一次的 计数法
 */
public class SingleNumber_137 {
    /**
     * java 一行解决使用map计数
     * O(2n)
     */
    class Solution {
        public int singleNumber(int[] nums) {
            return Arrays.stream(nums).boxed()
                    .collect(Collectors.groupingBy(i -> i, Collectors.counting()))
                    .entrySet().stream().filter(e -> e.getValue() == 1).findFirst().get().getKey();
        }
    }
}
