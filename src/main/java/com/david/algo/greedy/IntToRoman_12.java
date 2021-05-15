package com.david.algo.greedy;

/**
 * 输入: num = 1994
 * 输出: "MCMXCIV"
 * 解释: M = 1000, CM = 900, XC = 90, IV = 4.
 * <p>
 * 字符          数值
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 */
public class IntToRoman_12 {
    public static void main(String[] args) {
        System.out.println(new IntToRoman_12().new Solution().intToRoman(1994));
        System.out.println(new IntToRoman_12().new Solution().intToRoman(1800));
    }

    /**
     * 关键点：由于带4和9的只能出现一次。其余的数字前面是后面的倍数。利用贪心的思想 先拿大的拿完再用小的填充
     * 复杂度跟num的位数相关即O(log10 n)= O(logn)
     */
    public class Solution {
        public String intToRoman(int num) {
            //维护映射关系
            int[] nums = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
            String[] romans = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
            StringBuilder res = new StringBuilder();
            for (int i = 0; i < 13; ) {//一次循环 当由于nums是从大到小排列 当前位置拿不够了才去拿下一个 下标移动1
                if (num >= nums[i]) {
                    num -= nums[i];
                    res.append(romans[i]);
                } else i++;
            }
            return res.toString();
        }
    }
}
