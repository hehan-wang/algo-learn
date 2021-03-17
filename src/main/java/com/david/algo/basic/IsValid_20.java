package com.david.algo.basic;

import java.util.Stack;

public class IsValid_20 {
    public static void main(String[] args) {
//        System.out.println((int) '{');
//        System.out.println((int) '}');
//        System.out.println((int) '[');
//        System.out.println((int) ']');
//        System.out.println((int) '(');
//        System.out.println((int) ')');
        System.out.println(new IsValid_20().new Solution().isValid("([)]"));
    }

    /**
     * 使用栈先进后出的特性 判断括号是否跟前一个成对
     * 遇到左括号"("入栈一个右括号")"
     * 遇到右括号出栈")" 判断是否成对 没有左括号 或者不成对(中间插入单个别的左括号)返回false
     */
    class Solution {
        public boolean isValid(String s) {
            if (s.isEmpty()) return true;//空串为true
            if ((s.length() & 1) == 1) return false;//长度奇数为false
            Stack<Character> stack = new Stack<>();
            for (char c : s.toCharArray()) {
                if (c == '(') stack.push(')');
                else if (c == '{') stack.push('}');
                else if (c == '[') stack.push(']');
                else if (stack.empty() || c != stack.pop()) return false;//右括号情况
            }
            return stack.empty();
        }
    }
}
