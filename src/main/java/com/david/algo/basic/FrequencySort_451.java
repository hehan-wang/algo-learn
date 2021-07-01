package com.david.algo.basic;

import java.util.*;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * 输入:
 * "tree"
 * <p>
 * 输出:
 * "eert"
 * <p>
 * 解释:
 * 'e'出现两次，'r'和't'都只出现一次。
 * 因此'e'必须出现在'r'和't'之前。此外，"eetr"也是一个有效的答案。
 * * @author: david
 * * @date: 2021/7/3
 */
public class FrequencySort_451 {
    public static void main(String[] args) {
        System.out.println(new FrequencySort_451().new Solution().frequencySort("tree"));
        System.out.println(new FrequencySort_451().new Solution().frequencySort("Aabb"));
    }

    /**
     * 1.使用HashMap表存频率
     * 2.对map排序输出
     * time:O(nlogn) 取决于排序O(nlogn)
     */
    class Solution1 {
        public String frequencySort(String s) {
            HashMap<Character, Integer> counts = new HashMap<>();
            for (char c : s.toCharArray()) counts.compute(c, (k, v) -> v == null ? 1 : v + 1);
            StringBuilder sb = new StringBuilder();
            counts.entrySet().stream().sorted((e, e1) -> e1.getValue() - e.getValue()).forEach(e -> {
                sb.append(String.valueOf(e.getKey()).repeat(Math.max(0, e.getValue())));
            });
            return sb.toString();
        }
    }

    /**
     * 重拳出击 一行写法
     */
    class Solution {
        public String frequencySort(String s) {
            return s.chars().boxed()
                    .collect(Collectors.groupingBy(e -> (char) (int) e, Collectors.counting()))//转化成词频map
                    .entrySet().stream()
                    .sorted((e, e1) -> (int) (e1.getValue() - e.getValue()))//排序
                    .map(e -> String.valueOf(e.getKey()).repeat(Math.toIntExact(e.getValue())))//映射成字符串
                    .collect(Collectors.joining());//组合

        }
    }
}

