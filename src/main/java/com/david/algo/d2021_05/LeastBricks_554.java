package com.david.algo.d2021_05;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.BiFunction;

/**
 * 2021-05-02
 * 输入：wall = [[1,2,2,1],[3,1,2],[1,3,2],[2,4],[3,1,2],[1,3,1,1]]
 * 输出：2
 */
public class LeastBricks_554 {
    public static void main(String[] args) {
        List<List<Integer>> l = List.of(
                List.of(1, 2, 2, 1),
                List.of(3, 1, 2),
                List.of(1, 3, 2),
                List.of(2, 4),
                List.of(3, 1, 2)
        );
//        System.out.println(new LeastBricks_554().new Solution().leastBricks(l));
        System.out.println(new LeastBricks_554().new Solution1().leastBricks(l));
    }

    /**
     * 使用哈希表存储<间隙，数量> 然后用总高度-最大的数量即为答案
     */
    class Solution {
        public int leastBricks(List<List<Integer>> wall) {
            AtomicInteger maxGapCount = new AtomicInteger(0);
            Map<Integer, Integer> map = new HashMap<>();
            for (List<Integer> row : wall) {
                for (int j = 0, gap = 0; j < row.size() - 1; j++) {//最后一个元素忽略掉 因为都指向末尾边界 一块都没穿过
                    gap += row.get(j);
                    map.compute(gap, (k, v) -> {//不存在置为1存在+1
                        int v1 = v == null ? 1 : v + 1;
                        maxGapCount.set(Math.max(maxGapCount.get(), v1));//存储最大值
                        return v1;
                    });
                }
            }
            return wall.size() - maxGapCount.get();
        }
    }

    class Solution1 {
        public int leastBricks(List<List<Integer>> wall) {
            int maxGapCount = 0;
            Map<Integer, Integer> map = new HashMap<>();
            for (List<Integer> row : wall) {
                for (int j = 0, gap = 0; j < row.size() - 1; j++) {//最后一个元素忽略掉 因为都指向末尾边界 一块都没穿过
                    gap += row.get(j);
                    map.put(gap, map.getOrDefault(gap, 0) + 1);
                    maxGapCount = Math.max(maxGapCount, map.get(gap));
                }
            }
            return wall.size() - maxGapCount;
        }
    }
}
