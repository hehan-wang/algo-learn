package com.david.day.d53;

/**
 * 思路
 * 循环32次 res=res<<1+ns&1
 */
public class ReverseBits {

    public class Solution {
        // you need treat n as an unsigned value
        public int reverseBits(int n) {
            int res = 0;
            for (int i = 0; i < 32; i++) {
                res = (res << 1) + (n & 1);
                n >>= 1;
            }
            return res;
        }
    }
}
