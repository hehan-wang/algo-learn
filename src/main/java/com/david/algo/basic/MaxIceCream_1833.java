package com.david.algo.basic;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Predicate;

/**
 * @author: david
 * @date
 */
public class MaxIceCream_1833 {
    public static void main(String[] args) {
        System.out.println(new MaxIceCream_1833().new Solution().maxIceCream(new int[]{1, 3, 2, 4, 1}, 7));
        System.out.println(new MaxIceCream_1833().new Solution().maxIceCream(new int[]{10, 6, 8, 7, 7, 8}, 5));
        System.out.println(new MaxIceCream_1833().new Solution().maxIceCream(new int[]{1, 6, 3, 1, 2, 5}, 20));

        System.out.println("=================");
        System.out.println(new MaxIceCream_1833().new Solution1().maxIceCream(new int[]{1, 3, 2, 4, 1}, 7));
        System.out.println(new MaxIceCream_1833().new Solution1().maxIceCream(new int[]{10, 6, 8, 7, 7, 8}, 5));
        System.out.println(new MaxIceCream_1833().new Solution1().maxIceCream(new int[]{1, 6, 3, 1, 2, 5}, 20));
    }

    /**
     * 排序+贪心
     * 排序然后先拿小的
     * O(nlogn)
     */
    class Solution {
        public int maxIceCream(int[] costs, int coins) {
            Arrays.sort(costs);
            int res = 0;
            for (int i = 0; i < costs.length; i++) {
                coins -= costs[i];
                if (coins < 0) break;
                res++;
            }
            return res;
        }
    }

    /**
     * 排序+贪心
     * 一行解法
     * 1.先排序
     * 2.然后每次coins-cost
     * 3.当coins<0退出 取遍历次数
     */
    class Solution1 {
        public int maxIceCream(int[] costs, int coins) {
            int[] cs = {coins};//由于lambda需要final变量 所以包装成数组
            return (int) Arrays.stream(costs).boxed().sorted().peek(c -> cs[0] = cs[0] - c).takeWhile(c -> cs[0] >= 0).count();
        }
    }
}
