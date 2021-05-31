package com.david.algo.stack;

import java.util.Stack;

/**
 * 1190. 反转每对括号间的子串
 * <p>
 * 输入：s = "(abcd)"
 * 输出："dcba"
 * <p>
 * 输入：s = "(ed(et(oc))el)"
 * 输出："leetcode"
 */
public class ReverseParentheses_1190 {
    public static void main(String[] args) {
//        System.out.println(new ReverseParentheses_1190().new Solution().reverseParentheses("(ed(et(oc))el)"));
//        System.out.println(new ReverseParentheses_1190().new Solution().reverseParentheses("a(bcdefghijkl(mno)p)q"));

        System.out.println(new ReverseParentheses_1190().new Solution1().reverseParentheses("(ed(et(oc))el)"));
    }

    /**
     * 思路
     * 成对括号问题使用栈
     * 1.遇到 ')'出栈到前一个'(',去掉括号反转入栈
     * 2.遇到'(' 入栈,
     */
    class Solution {
        public String reverseParentheses(String s) {
            Stack<Character> stack = new Stack<>();
            char[] chars = s.toCharArray();
            for (char c : chars) {
                if (c == ')') {//遇到')'出栈 反转
                    StringBuilder tmp = new StringBuilder();//存最内层()内的字符串
                    while (stack.peek() != '(') tmp.append(stack.pop());
                    stack.pop();//把'('出栈
                    for (char ch : tmp.toString().toCharArray()) stack.push(ch);//反转后再入栈
                } else stack.push(c);
            }
            StringBuilder sb = new StringBuilder();
            for (Character c : stack) sb.append(c);
            return sb.toString();
        }
    }

    //大佬写法
    class Solution1 {
        public String reverseParentheses(String s) {
            char[] stack = s.toCharArray();
            int n = stack.length, ptr = -1;
            for (int i = 0; i < n; ++i) {
                if (stack[i] != ')') {//找到第一个')'
                    stack[++ptr] = stack[i];
                    continue;
                }
                int j = i;//j 子串存左边接 i存右边界
                for (char pop; (pop = stack[ptr--]) != '('; stack[j--] = pop) ;
                reverse(stack, j + 1, i);//反转字符串
                while (++j <= i) stack[++ptr] = stack[j];
            }
            return new String(stack, 0, ptr + 1);
        }

        void reverse(char[] str, int from, int to) {
            while (from < to) {
                char tmp = str[from];
                str[from++] = str[to];
                str[to--] = tmp;
            }
        }
    }
}
