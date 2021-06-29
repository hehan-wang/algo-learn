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
     */
    class Solution {
        public String convertToTitle(int columnNumber) {
            StringBuilder sb = new StringBuilder();
            while (columnNumber > 0) {
                columnNumber--;//解决从1开始的关键 (26-1)%26 =25 25+'A'='Z'
                sb.append((char) ('A' + columnNumber % 26));
                columnNumber /= 26;
            }
            return sb.reverse().toString();
        }
    }
}
