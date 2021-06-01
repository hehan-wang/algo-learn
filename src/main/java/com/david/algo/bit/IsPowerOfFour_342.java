package com.david.algo.bit;

/**
 * 342. 4的幂
 * <p>
 * 输入：n = 5
 * 输出：false
 * <p>
 * 输入：n = 16
 * 输出：true
 */
public class IsPowerOfFour_342 {
    public static void main(String[] args) {
        System.out.println(new IsPowerOfFour_342().new Solution().isPowerOfFour(16));
        System.out.println(new IsPowerOfFour_342().new Solution().isPowerOfFour(5));
    }

    /**
     * 先判断是否是2的幂 模3余1
     * O(1)
     */
    class Solution {
        public boolean isPowerOfFour(int n) {
            return (n & (n - 1)) == 0 && n % 3 == 1;
        }
    }
}
