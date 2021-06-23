package com.david.algo.bit;

public class HammingWeight_offer15 {
    public static void main(String[] args) {
        System.out.println(new HammingWeight_offer15().new Solution().hammingWeight(3));
        System.out.println(new HammingWeight_offer15().new Solution1().hammingWeight(3));
    }

    //调用函数
    public class Solution {
        // you need to treat n as an unsigned value
        public int hammingWeight(int n) {
            return Integer.bitCount(n);
        }
    }


    /**
     * n&(n-1) 打掉最后一位1
     * 每次打掉一个1 最后一定为0
     */
    public class Solution1 {
        // you need to treat n as an unsigned value
        public int hammingWeight(int n) {
            int res = 0;
            while (n != 0) {
                n &= (n - 1);//每次打掉
                res++;
            }
            return res;
        }
    }
}
