package com.david.day.d51;

public class isPerfectSquare_367 {
    public static void main(String[] args) {
//        System.out.println(new Solution1().isPerfectSquare(16));
        System.out.println(new Solution().isPerfectSquare(4));
    }

    //牛顿迭代
    static class Solution1 {
        public boolean isPerfectSquare(int num) {
            if (num < 2) return true;
            long x = num >> 1;//必须使用long 防止num太大截断
            while (x * x > num) {
                x = (x + num / x) / 2;
            }
            return (x * x == num);
        }
    }

    //二分法
    static class Solution {
        public boolean isPerfectSquare(int num) {
            if (num < 2) return true;
            long left = 1, right = num >> 1;
            while (left <= right) {
                long mid = left + (right - left) / 2;
                long l = mid * mid;
                if (l == num) return true;
                else if (l > num) right = mid - 1;
                else left = mid + 1;
            }
            return false;
        }
    }
}
