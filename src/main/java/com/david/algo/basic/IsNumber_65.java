package com.david.algo.basic;

/**
 * 有效数字（按顺序）可以分成以下几个部分：
 * <p>
 * 一个 小数 或者 整数
 * （可选）一个 'e' 或 'E' ，后面跟着一个 整数
 * 小数（按顺序）可以分成以下几个部分：
 * <p>
 * （可选）一个符号字符（'+' 或 '-'）
 * 下述格式之一：
 * 至少一位数字，后面跟着一个点 '.'
 * 至少一位数字，后面跟着一个点 '.' ，后面再跟着至少一位数字
 * 一个点 '.' ，后面跟着至少一位数字
 * 整数（按顺序）可以分成以下几个部分：
 * <p>
 * （可选）一个符号字符（'+' 或 '-'）
 * 至少一位数字
 */
public class IsNumber_65 {
    public static void main(String[] args) {
//        System.out.println(new IsNumber_65().new Solution().isNumber("."));
//        System.out.println(new IsNumber_65().new Solution().isNumber("inf"));
        System.out.println(new IsNumber_65().new Solution().isNumber("-1."));
    }

    /**
     * 模拟法
     */
    class Solution {
        public boolean isNumber(String s) {
            int n = s.length();
            int e = -1;//e的下标
            char[] chars = s.toCharArray();
            for (int i = 0; i < n; i++) {
                if (chars[i] == 'e' || chars[i] == 'E') {
                    if (e == -1) e = i;//保存e的下标
                    else return false;//因为出现了第二个e
                }
            }
            boolean res = true;
            if (e == -1) {//不存在e
                res &= check(chars, 0, n - 1, false);
            } else {//存在e
                res &= check(chars, 0, e - 1, false);
                res &= check(chars, e + 1, n - 1, true);
            }
            return res;
        }

        /**
         * 判断是否是数字
         * 1.'+' '-'只能再begin
         * 2.'.'最多出现一次
         * 3.至少有一个数字
         */
        private boolean check(char[] chars, int begin, int end, boolean mustInteger) {
            if (begin > end) return false;
            if (chars[begin] == '+' || chars[begin] == '-') begin++;//'+' '-'可以忽略
            boolean hasNum = false, hasDot = false;
            for (int i = begin; i <= end; i++) {
                if (chars[i] == '.') {
                    if (mustInteger || hasDot) return false;//只能有一个'.' 整数不能有'.'
                    hasDot = true;
                } else if (chars[i] <= '9' && chars[i] >= '0') {
                    hasNum = true;
                } else {
                    return false;
                }
            }
            return hasNum;
        }
    }
}
