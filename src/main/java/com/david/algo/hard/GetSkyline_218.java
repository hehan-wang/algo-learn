package com.david.algo.hard;

import java.util.*;

/**
 * 又是cv的一天 哈哈哈
 * @author: david
 * @date: 2021/7/13
 */
public class GetSkyline_218 {
    public static void main(String[] args) {
        System.out.println(new GetSkyline_218().new Solution().getSkyline(new int[][]{
                {0, 2, 3},
                {2, 5, 3}
        }));
    }

    class Solution {
        public List<List<Integer>> getSkyline(int[][] buildings) {
            // x轴从小到大排序，如果x相等，则按照高度从低到高排序
            PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] != b[0] ? a[0] - b[0] : a[1] - b[1]);
            for (int[] building : buildings) {
                // 左端点和高度入队，高度为负值说明是左端点
                pq.offer(new int[]{building[0], -building[2]});
                // 右端点和高度入队
                pq.offer(new int[]{building[1], building[2]});
            }

            List<List<Integer>> res = new ArrayList<>();

            // 降序排列
            TreeMap<Integer, Integer> heights = new TreeMap<>((a, b) -> b - a);
            heights.put(0, 1);
            int left = 0, height = 0;

            while (!pq.isEmpty()) {
                int[] arr = pq.poll();
                // 如果是左端点
                if (arr[1] < 0) {
                    // 高度 --> 高度 + 1
                    heights.put(-arr[1], heights.getOrDefault(-arr[1], 0) + 1);
                }
                // 右端点
                else {
                    // 高度 --> 高度 - 1
                    heights.put(arr[1], heights.get(arr[1]) - 1);
                    // 说明左右端点都已经遍历完
                    if (heights.get(arr[1]) == 0) heights.remove(arr[1]);
                }
                // heights是以降序的方式排列的，所以以下会获得最大高度
                int maxHeight = heights.keySet().iterator().next();
                // 如果最大高度不变，则说明当前建筑高度在一个比它高的建筑下面，不做操作
                if (maxHeight != height) {
                    left = arr[0];
                    height = maxHeight;
                    res.add(Arrays.asList(left, height));
                }
            }
            return res;
        }
    }
}
