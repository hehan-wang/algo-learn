package com.david.day.d23;

public class ClimbStairs_70 {
    public static void main(String[] args) {
        int res = new Solution().climbStairs(4);
        System.out.println(res);
    }

    /**
     * 递归法+备忘录
     * 可以理解成斐波那契数列
     * 每次可以从n-1楼梯上一层 或者n-2上两层
     * f(n)=f(n-1)+f(n-2)
     */
    static class Solution {
        public int climbStairs(int n) {
            int[] cache = new int[n + 1];
            return rec(n, cache);
        }

        private int rec(int n, int[] cache) {
            if (n <= 2) return n;
            if (cache[n] != 0) return cache[n];
            int curr = rec(n - 1, cache) + rec(n - 2, cache);
            cache[n] = curr;
            return curr;
        }
    }
}
