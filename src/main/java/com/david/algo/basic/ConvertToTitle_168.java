package com.david.algo.basic;

/**
 * 给定一个正整数，返回它在 Excel 表中相对应的列名称。
 * 输入: 28
 * 输出: "AB"
 */
public class ConvertToTitle_168 {
    public static void main(String[] args) {
        System.out.println(new ConvertToTitle_168().new Solution().convertToTitle(28));
        System.out.println(new ConvertToTitle_168().new Solution().convertToTitle(701));
    }

    /**
     * 十进制转26进制
     * 使用-1 熨平取模的问题。
     * 因为x%26=[0,25] 但是我们取从[1-26]对应[A-Z]
     * 直接取模 26%26=0 不在我们范围内
     * 所以我们采用-1 [0-25]对应[A-Z] (26-1)%26 =25  25+'A'='Z'
     */
    class Solution {
        public String convertToTitle(int columnNumber) {
            StringBuilder sb = new StringBuilder();
            while (columnNumber > 0) {
                columnNumber--;//解决从1开始的关键
                sb.append((char) ('A' + columnNumber % 26));
                columnNumber /= 26;
            }
            return sb.reverse().toString();
        }
    }
}
