package com.david.com.david.day.d21;

import java.util.*;

public class GetKthMagicNumber_interview17 {
    public static void main(String[] args) {
        PriorityQueue<Long> minHeap = new PriorityQueue<>();//最x小堆

        Solution solution = new Solution();
        int number = solution.getKthMagicNumber(5);
        System.out.println(number);
    }

    /**
     * 丑数264
     */
    static class Solution {
        int[] prime = new int[]{3, 5, 7};//存因子
        List<Long> res = new ArrayList<>();//存结果数组
        PriorityQueue<Long> minHeap = new PriorityQueue<>();//最小堆 存最小的丑数 读O(1)  插入删除O(logn)
        Set<Long> seen = new HashSet<>();//用来拍重

        public int getKthMagicNumber(int k) {
            res.add(1L);
            minHeap.add(1L);
            for (int i = 0; i < k; i++) {//实际数量肯定小于k很多
                Long ugly = minHeap.poll();
                res.add(i, ugly);
                for (int prime : prime) {
                    long next = prime * ugly;
                    if (!seen.contains(next)) {
                        seen.add(next);
                        minHeap.add(next);
                    }
                }
            }
            return Math.toIntExact(res.get(k - 1));
        }
    }
}
