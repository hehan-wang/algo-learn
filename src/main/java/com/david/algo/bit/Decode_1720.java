package com.david.algo.bit;

/**
 * 0^x=x; 0跟自己的区别就是自己
 * x^x=0; 自己跟自己没区别
 * <p>
 * 输入：encoded = [1,2,3], first = 1
 * 输出：[1,0,2,1]
 * 解释：若 arr = [1,0,2,1] ，那么 first = 1 且 encoded = [1 XOR 0, 0 XOR 2, 2 XOR 1] = [1,2,3]
 */
public class Decode_1720 {
    /**
     * 推导过程
     * 已知：encoded[i] = arr[i] ^ arr[i + 1]
     * -> encoded[i-1]=arr[i-1]^arr[i] 这样才能使用上first
     * 两边同时异或arr[i-1] ：encoded[i-1]^arr[i-1]=arr[i-1]^arr[i-1]^arr[i]
     * -> encoded[i-1]^arr[i-1]=0^arr[i]
     * -> arr[i]=encoded[i-1]^arr[i-1]
     */
    class Solution {
        public int[] decode(int[] encoded, int first) {
            int[] arr = new int[encoded.length + 1];
            arr[0] = first;
            for (int i = 1; i <= encoded.length; i++) {
                arr[i] = arr[i - 1] ^ encoded[i - 1];
            }
            return arr;
        }
    }
}
