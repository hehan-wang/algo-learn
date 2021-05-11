package com.david.algo.bit;

import java.util.stream.IntStream;

/**
 * 输入：n = 5, start = 0
 * 输出：8
 * 解释：数组 nums 为 [0, 2, 4, 6, 8]，其中 (0 ^ 2 ^ 4 ^ 6 ^ 8) = 8 。
 * "^" 为按位异或 XOR 运算符。
 */
public class XorOperation_1486 {
    public static void main(String[] args) {
        System.out.println(new XorOperation_1486().new Solution().xorOperation(5, 0));
        System.out.println(new XorOperation_1486().new Solution1().xorOperation(5, 0));
        System.out.println(new XorOperation_1486().new Solution2().xorOperation(5, 0));
    }

    //数学法 O(1)
    class Solution2 {
        public int xorOperation(int n, int start) {
            // 结果的最低位
            // 当n和start的最低位都为1时，lowestOrder=1，否则为0
            int lowestOrder = n & start & 1;

            // start ^ (start+2) ^ (start+4) ^ …… ^(start + 2*(n-1))
            //  =(令s=start/2)
            // (s ^ (s+1) ^ (s+2) ^ …… ^ (s+n-1)) * 2 + lowestOrder
            // 此处lowestOrder是为了补全start/2时丢失的1
            int s = start >> 1;

            // 而n到m(n<m)的异或等于1到n-1的异或 异或 1到m的异或
            // 原因：a^a = 0   0^a = a
            // xorsum(s~s+n-1)=xorsum(1~s-1)^xorsum(1~s+n-1)
            //
            int result = sumXor(s - 1) ^ sumXor(s + n - 1);

//            return result * 2 + lowestOrder;
            return (result << 1) | lowestOrder;
        }

        //计算1-n的xor的和
        int sumXor(int n) {
            // 前n个数异或的结果是有规律的(4个一组) 所以计算sum可以退化为O(1)
            // 例如：   二进制数   异或结果    return
            //      1    0001    0001        1
            //      2    0010    0011       n+1
            //      3    0011    0000        0
            //      4    0100    0100        n
            //      5    0101    0001        1
            //      6    0110    0111       n+1
            //      ……   ……      ……
            return switch (n % 4) {
                case 0 -> n;
                case 1 -> 1;
                case 2 -> n + 1;
                default -> 0;
            };
        }
    }

    /**
     * 直接翻译法O(n)
     */
    class Solution {
        public int xorOperation(int n, int start) {
            int res = 0;
            while (n-- > 0) res ^= (2 * n + start);
            return res;
        }
    }

    //一行
    class Solution1 {
        public int xorOperation(int n, int start) {
            return IntStream.range(0, n).boxed().map(i -> (2 * i + start)).reduce(0, (o, o1) -> o ^= o1);
        }
    }
}
