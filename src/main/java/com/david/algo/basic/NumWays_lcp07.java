package com.david.algo.basic;

import java.util.*;
import java.util.function.Function;

/**
 * LCP 07. 传递信息
 */
public class NumWays_lcp07 {
    public static void main(String[] args) {
        System.out.println(new NumWays_lcp07().new Solution().numWays(5, new int[][]{{0, 2}, {2, 1}, {3, 4}, {2, 3}, {1, 4}, {2, 0}, {0, 4}}, 3));
        System.out.println(new NumWays_lcp07().new Solution1().numWays(5, new int[][]{{0, 2}, {2, 1}, {3, 4}, {2, 3}, {1, 4}, {2, 0}, {0, 4}}, 3));
    }

    /**
     * bfs
     * 由于题目说k次可达 即使用bfs 搜k次
     */
    class Solution {
        public int numWays(int n, int[][] relation, int k) {
            HashMap<Integer, Set<Integer>> map = new HashMap<>();
            for (int[] r : relation) map.computeIfAbsent(r[0], key -> new HashSet<>()).add(r[1]);//关系缓存到map中
            Queue<Integer> queue = new LinkedList<>();
            queue.offer(0);//小朋友a入队
            while (k-- > 0 && !queue.isEmpty()) {//搜索k次
                int size = queue.size();
                while (size-- > 0) {
                    Integer curr = queue.poll();
                    Set<Integer> set = map.getOrDefault(curr, new HashSet<>());
                    for (int i : set) queue.offer(i);
                }
            }
            return (int) queue.stream().filter(e -> (n - 1) == e).count();   //看当前queue里有几个n-1
        }
    }

    /**
     * 动态规划
     * dp[i][j]存走了i轮到达j的步数
     * dp[0][0]=1 走0步(初始位置)在0号同学的路线有1种
     * dp[i+1][dest]+=Σdp[i][src] 走到dest的路线的个数=前一步的位置的src所有到dest路径和
     * O(r*k)
     */
    class Solution1 {
        public int numWays(int n, int[][] relation, int k) {
            int[][] dp = new int[k + 1][n];
            dp[0][0] = 1;
            for (int i = 1; i <= k; i++) {
                for (int[] r : relation) {
                    int src = r[0], dest = r[1];
                    dp[i][dest] += dp[i - 1][src];
                }
            }
            return dp[k][n - 1];//走k次到达n-1
        }
    }
}
