package com.david.algo.basic;

/**
 * 输入: "MCMXCIV"
 * 输出: 1994
 * 解释: M = 1000, CM = 900, XC = 90, IV = 4.
 * 基本思路是通过按位去依次对应查找，问题是有两种算法。需要找规律统一1. 先把
 */
public class RomanToInt_13 {
    public static void main(String[] args) {
        System.out.println(new RomanToInt_13().new Solution().romanToInt("MCMXCIV"));
        System.out.println(new RomanToInt_13().new Solution1().romanToInt("MCMXCIV"));
//        System.out.println("MCMXCIV".substring(0, 1));
    }

    /**
     * 思路
     * 模拟法
     * 先存好映射关系 然后一个字母一个字母向后扫
     * O(n) 跟字母长度线性相关
     */
    class Solution {
        public int romanToInt(String s) {
            String[] romans = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
            int[] nums = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
            int res = 0, begin = 0, index = 0, n = s.length();
            while (index < 13) {
                String curr = romans[index];
                int end = Math.min(begin + curr.length(), n);//最后一个字符可能越界
                if (curr.equals(s.substring(begin, end))) {//字符串中有当前位置的字符加入结果
                    res += nums[index];
                    begin += curr.length();
                } else index++;
            }
            return res;
        }
    }

    /**
     * 找规律
     * 当前字母对应数字比后一个小的话减去当前数值
     */
    class Solution1 {
        public int romanToInt(String s) {
            char[] romans = s.toCharArray();
            int res = 0, pre = parse(romans[0]);//res存结果 pre存前一个数字
            for (int i = 1; i < romans.length; i++) {
                int num = parse(romans[i]);
                if (pre < num) res -= pre;
                else res += pre;
                pre = num;
            }
            res += pre;
            return res;
        }

        public int parse(char roman) {
            return switch (roman) {
                case 'M' -> 1000;
                case 'D' -> 500;
                case 'C' -> 100;
                case 'L' -> 50;
                case 'X' -> 10;
                case 'V' -> 5;
                case 'I' -> 1;
                default -> 0;
            };
        }
    }


    //先替换来统一成一个字符
    class Solution3 {
        public int romanToInt(String s) {
            s = s.replace("IV", "a");
            s = s.replace("IX", "b");
            s = s.replace("XL", "c");
            s = s.replace("XC", "d");
            s = s.replace("CD", "e");
            s = s.replace("CM", "f");

            int result = 0;
            for (int i = 0; i < s.length(); i++) {
                result += which(s.charAt(i));
            }
            return result;
        }

        public int which(char ch) {
            return switch (ch) {
                case 'I' -> 1;
                case 'V' -> 5;
                case 'X' -> 10;
                case 'L' -> 50;
                case 'C' -> 100;
                case 'D' -> 500;
                case 'M' -> 1000;
                case 'a' -> 4;
                case 'b' -> 9;
                case 'c' -> 40;
                case 'd' -> 90;
                case 'e' -> 400;
                case 'f' -> 900;
                default -> 0;
            };
        }
    }
}
