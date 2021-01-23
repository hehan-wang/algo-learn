package com.david.com.david.day.d24;

public class MaxProfit_122 {
    public static void main(String[] args) {
        int[] prices = {1, 2, 3, 4, 5};
        int max = new Solution().maxProfit(prices);
        System.out.println(max);
    }

    static class Solution {
        public int maxProfit(int[] prices) {
            int res = 0;
            for (int i = 1; i < prices.length; i++) {
                res += Math.max(0, prices[i] - prices[i - 1]);//只要后一天比前一天多就加上
            }
            return res;
        }
    }
}
