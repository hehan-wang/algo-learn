package com.david.com.david.day.d27;

public class IsPerfectSquare_367 {
    public static void main(String[] args) {

    }

    //二分查找 超时
    static class Solution {
        public boolean isPerfectSquare(int num) {
            if (num < 2) return true;
            int left = 2;
            int right = num / 2;
            int x = 2;
            while (left <= right) {
                x = left + (right - left) >> 1;
                int bench = x * x;
                if (bench > num) {
                    right = x - 1;
                } else if (bench < num) {
                    left = x + 1;
                } else {
                    return true;
                }
            }
            return true;
        }
    }

    /**
     * 牛顿迭代
     * https://leetcode-cn.com/problems/valid-perfect-square/solution/ceng-ceng-di-jin-zhu-bu-zui-you-de-si-chong-jie-fa/
     * x*x>num时候 x=(x+num/x)/2向左找
     */
    static class Solution1 {
        public boolean isPerfectSquare(int num) {
            if (num < 2) return true;
            long x = num >> 1;//必须使用long 否则num=808201报错
            while (x * x > num) {
                x = (x + num / x) >> 1;
            }
            return (x * x == num);
        }
    }
}
