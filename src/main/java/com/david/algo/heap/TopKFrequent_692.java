package com.david.algo.heap;

import java.util.*;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

/**
 * 692. 前K个高频单词
 * 输入: ["i", "love", "leetcode", "i", "love", "coding"], k = 2
 * 输出: ["i", "love"]
 * 解析: "i" 和 "love" 为出现次数最多的两个单词，均为2次。
 * 注意，按字母顺序 "i" 在 "love" 之前。
 */
public class TopKFrequent_692 {
    public static void main(String[] args) {
        System.out.println(new TopKFrequent_692().new Solution().topKFrequent(new String[]{"i", "love", "leetcode", "i", "love", "coding"}, 2));
        System.out.println(new TopKFrequent_692().new Solution1().topKFrequent(new String[]{"i", "love", "leetcode", "i", "love", "coding"}, 2));
    }

    /**
     * 思路
     * 先把单词数量存map中 然后排序先按value倒序 再按key升序
     * O(nlogn) 需要排序
     */
    class Solution {
        public List<String> topKFrequent(String[] words, int k) {
            Map<String, Long> count = Arrays.stream(words).collect(Collectors.groupingBy(e -> e, Collectors.counting()));
            return count.entrySet().stream().sorted((o1, o2) -> o2.getValue().equals(o1.getValue()) ? o1.getKey().compareTo(o2.getKey()) : Long.compare(o2.getValue(), o1.getValue())).limit(k).map(Map.Entry::getKey).collect(Collectors.toList());
        }
    }

    /**
     * 原始写法
     * 使用小根堆求topk
     * O(nlogk)
     */
    class Solution1 {
        public List<String> topKFrequent(String[] words, int k) {
            HashMap<String, Long> count = new HashMap<>();
            for (String word : words) count.compute(word, (s, v) -> v == null ? 0 : v + 1);
            //词频相同按字典倒序 词频不同按词频升序
            PriorityQueue<Map.Entry<String, Long>> minHeap = new PriorityQueue<>((e1, e2) -> e2.getValue().equals(e1.getValue()) ? e2.getKey().compareTo(e1.getKey()) : (int) (e1.getValue() - e2.getValue()));
            for (Map.Entry<String, Long> entry : count.entrySet()) {//超过k个就放入queue 让堆自己处理
                minHeap.offer(entry);
                if (minHeap.size() > k) minHeap.poll();
            }
            List<String> res = new ArrayList<>();
            while (!minHeap.isEmpty()) res.add(minHeap.poll().getKey());
            Collections.reverse(res);
            return res;
        }
    }
}
