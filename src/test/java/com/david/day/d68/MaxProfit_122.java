package com.david.day.d68;

public class MaxProfit_122 {
    public static void main(String[] args) {
        System.out.println(new Solution().maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
    }

    /**
     * dp
     * k=不限制 可以降维
     * T[i][k][0]=max(T[i-1][k][0],T[i-1][k][1]+price[i])
     * T[i][k][1]=max(T[i-1][k][1],T[i-1][k][0]-price[i])
     * =
     * T[i][0]=max(T[i-1][0],T[i-1][1]+price[i])
     * T[i][1]=max(T[i-1][1],T[i-1][0]-price[i])
     * =
     * 由于i 只跟i-1有关 退化成两个变量
     * p0=max(p0,p1+price[i])
     * p1=max(p1,p0-price[i])
     * 初始状态
     * p0=T[0][0]=max(T[-1][0],T[-1][1]+price[0])=max(0,(-price[0]+price[0])=0)=0
     * p1=T[0][1]=max(T[-1][1],T[-1][0]-price[0])=max(-price[0],-price[0])= -price[0]
     */
    static class Solution {
        public int maxProfit(int[] prices) {
            int p0 = 0, p1 = -prices[0];
            for (int i = 1; i < prices.length; i++) {
                int p = Math.max(p0, p1 + prices[i]);
                p1 = Math.max(p1, p0 - prices[i]);
                p0 = p;
            }
            return p0;
        }
    }

}
