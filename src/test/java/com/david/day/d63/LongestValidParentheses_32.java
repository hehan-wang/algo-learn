package com.david.day.d63;

//2021-03-07
public class LongestValidParentheses_32 {
    public static void main(String[] args) {
//        System.out.println(new Solution().longestValidParentheses(")()())"));
        String s = "(()())";
        System.out.println(new Solution1().longestValidParentheses(s));
    }

    class Solution {
        public int longestValidParentheses(String s) {
            int max = 0;
            int[] dp = new int[s.length()];
            char[] chars = s.toCharArray();
            for (int i = 1; i < chars.length; i++) {
                if (chars[i] == ')') {
                    if (chars[i - 1] == '(') {
                        dp[i] = (i - 2 >= 0 ? dp[i - 2] : 0) + 2;
                    } else if ((i - dp[i - 1] -1)>= 0 && chars[i - dp[i - 1] - 1] == '(') {
                        dp[i] = dp[i - 1] + ((i - dp[i - 1] - 2) >= 0 ? dp[i - dp[i - 1] - 2] : 0) + 2;
                    }
                    max = Math.max(dp[i], max);
                }
            }
            return max;
        }
    }
    /**
     * dp解法
     * https://leetcode-cn.com/problems/longest-valid-parentheses/solution/zui-chang-you-xiao-gua-hao-by-leetcode-solution/
     */
    static class Solution1 {
        public int longestValidParentheses(String s) {
            char[] chars = s.toCharArray();
            int res = 0;
            int[] dp = new int[chars.length];
            for (int i = 1; i < chars.length; i++) {//下标1开始因为只有第二个元素才有可能凑成括号
                if (chars[i] == ')') {   //只有出现)才可配对
                    if (chars[i - 1] == '(') dp[i] = (i - 2 >= 0 ? dp[i - 2] : 0) + 2;      //前一个为( 组成...()正好配对+2
                    else if ((i - dp[i - 1] - 1) >= 0 && chars[i - dp[i - 1] - 1] == '(') {//  (...))  取当前都段内的dp最大值即i-1 + 前面dp最大值dp[i-dp[i-1]-2]
                        dp[i] = dp[i - 1] + 2 + ((i - dp[i - 1] - 2) >= 0 ? dp[i - dp[i - 1] - 2] : 0);
                    }
                    res = Math.max(res, dp[i]);
                }
            }
            return res;
        }
    }
}
