package com.david.algo.basic;

import java.util.Stack;
import java.util.StringJoiner;

/**
 * 思路
 * 1.dfs 当发现数字的时候dfs []
 */
public class DecodeString_394 {
    public static void main(String[] args) {
        System.out.println(new DecodeString_394().new Solution().decodeString("dd3[a2[c]]"));
        System.out.println(new DecodeString_394().new Solution1().decodeString("dd3[a2[c]]"));
    }

    /**
     * 辅助栈法 按顺序进出可以使用栈 队列这种
     * 用两个栈分别存 times和str
     * 遇到数字：更新times
     * 遇到'['： times，beforeStr入栈 str=new StringBuilder();
     * 遇到']'： 拼接begoreStr+times*str
     * 遇到一般字符： append
     */
    class Solution1 {
        public String decodeString(String s) {
            int times = 0;//存最后一次的次数
            StringBuilder res = new StringBuilder();//存[]中循环的串
            Stack<String> strStack = new Stack<>();//依次存'['前字符串的栈
            Stack<Integer> timesStack = new Stack<>();//依次存次数栈
            char[] chars = s.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                if (Character.isDigit(chars[i])) {
                    times = times * 10 + Integer.parseInt(chars[i] + "");//一定要变成String 再parse 否则直接char 直接使用ascii码
                } else if (chars[i] == '[') {//遇到'['入栈
                    timesStack.push(times);
                    strStack.push(res.toString());
                    //入栈后清空状态
                    times = 0;
                    res = new StringBuilder();
                } else if (chars[i] == ']') {//碰到']'出栈
                    StringBuilder tmp = new StringBuilder(strStack.pop());
                    for (int t = timesStack.pop(); t > 0; t--) tmp.append(res);
                    res = tmp;
                } else {
                    res.append(chars[i]);
                }
            }
            return res.toString();
        }
    }

    /**
     * 遇到'[' 就dfs 遇到']'返回下标和串
     */
    class Solution {
        public String decodeString(String s) {
            StringBuilder res = new StringBuilder();
            char[] chars = s.toCharArray();
            String[] dfs = dfs(chars, 0, s.length(), res);
//            return dfs[0];
            return res.toString();
        }

        private String[] dfs(char[] chars, int i, int n, StringBuilder res) {
            int times = 0;//截取[]重复次数
            while (i < n) {
                if (Character.isDigit(chars[i])) {
                    times = times * 10 + Integer.parseInt(String.valueOf(chars[i]));
                } else if (chars[i] == '[') {
                    String[] r = dfs(chars, i + 1, n, new StringBuilder());
                    i = Integer.parseInt(r[1]);
                    while (times > 0) {//填充重复串
                        res.append(r[0]);
                        times--;
                    }
                } else if (chars[i] == ']') {
                    return new String[]{res.toString(), String.valueOf(i)};
                } else {
                    res.append(chars[i]);
                }
                i++;
            }
            return new String[]{res.toString()};
        }
    }
}
