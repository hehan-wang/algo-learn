package com.david.leetcode;

public class NumDecodings_91 {
    public static void main(String[] args) {
        System.out.println(new Solution().numDecodings("12"));
        System.out.println(new Solution().numDecodings("0"));
        System.out.println(new Solution().numDecodings("06"));
    }

    /**
     * https://leetcode-cn.com/problems/decode-ways/solution/mmplao-niang-zhong-yu-xie-chu-lai-liao-by-vegetabl/
     * dp
     * 10 20: dp[i]=dp[i-2]
     * 11-19 21-26: dp[i]=dp[i-2]+dp[i-1]
     * 1-9: dp[i]=dp[i-1]
     * 0: return 0
     */
    static class Solution {
        public int numDecodings(String s) {
            if (s.length() == 0) return 0;
            if (s.charAt(0) == '0') return 0;
            int pre = 1, curr = 1;//dp[-1]=1 dp[0]=1
            char[] chars = s.toCharArray();
            for (int i = 1; i < s.length(); i++) {
                int tmp = curr;
                if (chars[i] == '0') {
                    if (chars[i - 1] == '1' || chars[i - 1] == '2') curr = pre;//10 20
                    else return 0;
                } else if (chars[i - 1] == '1' || (chars[i - 1] == '2' && chars[i] >= '1' && chars[i] <= '6')) {
                    curr += pre;
                }
                pre = tmp;
            }
            return curr;
        }
    }
}
