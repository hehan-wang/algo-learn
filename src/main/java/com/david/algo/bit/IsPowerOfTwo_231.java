package com.david.algo.bit;

/**
 * 231. 2 的幂
 * 输入：n = 16
 * 输出：true
 * 解释：24 = 16
 */
public class IsPowerOfTwo_231 {
    public static void main(String[] args) {
        System.out.println(new IsPowerOfTwo_231().new Solution().isPowerOfTwo(1));
        System.out.println(new IsPowerOfTwo_231().new Solution().isPowerOfTwo(16));
        System.out.println(new IsPowerOfTwo_231().new Solution().isPowerOfTwo(3));
    }

    /**
     * 使用位运算
     * 2^n 一定只有最高位有一个1
     * n&(n-1)打掉最高位1 结果为0返回true
     * time:O(1)
     */
    class Solution {
        public boolean isPowerOfTwo(int n) {
            if (n <= 0) return false;
            return (n & (n - 1)) == 0;
        }
    }
}
