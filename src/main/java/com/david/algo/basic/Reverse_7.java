package com.david.algo.basic;

/**
 * 输入：x = 123
 * 输出：321
 */
public class Reverse_7 {
    public static void main(String[] args) {
        System.out.println(new Reverse_7().new Solution().reverse(123));
        System.out.println(new Reverse_7().new Solution().reverse(-123));
        System.out.println(new Reverse_7().new Solution().reverse(-2147483412));
    }

    class Solution {
        public int reverse(int x) {
            int y = 0;
            while (x != 0) {
                int pop = x % 10;
                if (y > Integer.MAX_VALUE / 10 || (y == Integer.MAX_VALUE / 10 && pop > 7)) return 0;
                if (y < Integer.MIN_VALUE / 10 || (y == Integer.MIN_VALUE / 10 && pop < -8)) return 0;
                y = y * 10 + pop;
                x /= 10;
            }
            return y;
        }
    }
}
