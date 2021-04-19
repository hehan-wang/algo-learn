package com.david.day.d10;

import java.util.Stack;

//2021-01-07
public class RemoveOuterParentheses_1021 {
    public static void main(String[] args) {
        System.out.println(new RemoveOuterParentheses_1021().new Solution().removeOuterParentheses("(()())(())"));
        System.out.println(new RemoveOuterParentheses_1021().new Solution1().removeOuterParentheses("(()())(())"));
        System.out.println(new RemoveOuterParentheses_1021().new Solution1().removeOuterParentheses("(abab)(cd)"));
    }

    /**
     * 简洁写法 使用一个计数器
     * 左括号多的情况就append当前char
     */
    class Solution1 {
        public String removeOuterParentheses(String s) {
            StringBuilder res = new StringBuilder();
            char[] chars = s.toCharArray();
            int count = 0;
            for (char c : chars) {
                if (c == ')') count--;
                if (count >= 1) res.append(c);
                if (c == '(') count++;
            }
            return res.toString();
        }
    }

    /**
     * 使用栈解决先后成对问题
     * 找到()包裹的子串的左右下标 append到结果
     * O(n)
     */
    class Solution {
        public String removeOuterParentheses(String s) {
            StringBuilder res = new StringBuilder();
            Stack<Character> stack = new Stack<>();
            char[] chars = s.toCharArray();

            for (int left = 0, right = 0; right < chars.length; right++) {
                char c = chars[right];
                if (c == '(') {
                    if (stack.isEmpty()) left = right;//左下标
                    stack.push(c);
                } else if (c == ')') {
                    stack.pop();
                    if (stack.isEmpty()) res.append(s, left + 1, right);
                }
            }
            return res.toString();
        }
    }
}
