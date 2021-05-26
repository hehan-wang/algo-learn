package com.david.algo.bit;

/**
 * 461. 汉明距离
 * 输入: x = 1, y = 4
 * <p>
 * 输出: 2
 * <p>
 * 解释:
 * 1   (0 0 0 1)
 * 4   (0 1 0 0)
 * ↑   ↑
 * <p>
 * 上面的箭头指出了对应二进制位不同的位置。
 */
public class HammingDistance_461 {
    public static void main(String[] args) {
        System.out.println(new HammingDistance_461().new Solution().hammingDistance(1, 4));
        System.out.println(new HammingDistance_461().new Solution1().hammingDistance(1, 4));
    }

    /**
     * 先异或然后算1的个数
     */
    class Solution {
        public int hammingDistance(int x, int y) {
            int count = 0, xor = x ^ y;
            while (xor > 0) {
                if (xor % 2 == 1) count++;
                xor >>= 1;
            }
            return count;
        }
    }

    class Solution1 {
        public int hammingDistance(int x, int y) {
            return Integer.bitCount(x ^ y);
        }
    }

}
