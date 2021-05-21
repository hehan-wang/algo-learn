package com.david.algo.basic;

import java.util.Stack;

/**
 * 415. 字符串相加
 */
public class AddStrings_415 {
    public static void main(String[] args) {
        System.out.println(new AddStrings_415().new Solution().addStrings("123", "1123"));
        System.out.println(new AddStrings_415().new Solution().addStrings("1", "9"));
    }

    /**
     * 诸位相加 放入栈中 倒序拿出
     * "0123"
     * "1123"
     */
    class Solution {
        public String addStrings(String num1, String num2) {
            char[] cs1 = num1.toCharArray(), cs2 = num2.toCharArray();
            int carry = 0, i1 = num1.length() - 1, i2 = num2.length() - 1;
            Stack<Integer> stack = new Stack<>();//使用栈FILO的特性先进去的 低位
            StringBuilder res = new StringBuilder();
            while (i2 >= 0 || i1 >= 0) {
                char c1 = i1 >= 0 ? cs1[i1--] : '0';
                char c2 = i2 >= 0 ? cs2[i2--] : '0';
                int i = Character.getNumericValue(c1) + Character.getNumericValue(c2) + carry;
                carry = i / 10;
                stack.push(i % 10);
            }
            if (carry > 0) stack.push(carry);//最后还有进位的话补一位
            while (!stack.isEmpty()) res.append(stack.pop());
            return res.toString();
        }
    }
}
