package com.david.algo.bit;

import java.util.Arrays;

/**
 * 1734. 解码异或后的排列
 * <p>
 * 输入：encoded = [3,1]
 * 输出：[1,2,3]
 * 解释：如果 perm = [1,2,3] ，那么 encoded = [1 XOR 2,2 XOR 3] = [3,1]
 */
public class Decode_1734 {
    public static void main(String[] args) {
        int[] decode = new Decode_1734().new Solution().decode(new int[]{3, 1});
        System.out.println(Arrays.toString(decode));
    }

    /**
     * 思路：
     * 先计算出最后一个元素 然后顺序递推回来
     * 最后一个元素 = 所有数字异或^去掉最后一个异或
     * O(3n)
     * 条件
     * 1.encoded[i]=perm[i]^perm[i+1];
     * 2.原数组是1-n的排列
     */
    class Solution {
        public int[] decode(int[] encoded) {
            int a = 0, b = 0, n = encoded.length + 1;//n表示数字个数
            for (int i = 0; i < n - 1; i += 2) a ^= encoded[i];  //由于条件1可以各一个一跳计算前n-1个的异或
            for (int i = 1; i <= n; i++) b ^= i;     //计算所有数的异或
            int[] res = new int[n];
            res[n - 1] = a ^ b; // 利用 a^a=0, a^0=a; 可得n=xor(1~n-1)^xor(1~n)
            for (int i = n - 2; i >= 0; i--) {//由于最后一个数已经存在从数组的倒数第二个元素递推
                res[i] = encoded[i] ^ res[i + 1];
            }
            return res;
        }
    }
}
