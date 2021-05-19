package com.david.algo.dp;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 139. 单词拆分
 * 输入: s = "leetcode", wordDict = ["leet", "code"]
 * 输出: true
 * 解释: 返回 true 因为 "leetcode" 可以被拆分成 "leet code"。
 * <p>
 * 输入: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
 * 输出: false
 */
public class WordBreak_139 {
    public static void main(String[] args) {
        System.out.println(new WordBreak_139().new Solution().wordBreak("leetcode", List.of("leet", "code")));
        ;
    }
    /**
     * 背包问题
     * dp[i]=dp[i-w]&(words.contains(s[i:w]))
     */
    class Solution {
        public boolean wordBreak(String s, List<String> wordDict) {
            int len = s.length(), maxw = 0;//存最长字符串大小
            boolean[] dp = new boolean[len + 1];
            dp[0] = true;
            Set<String> set = new HashSet<>();
            for (String str : wordDict) {
                set.add(str);
                maxw = Math.max(maxw, str.length());
            }
            for (int i = 1; i < len + 1; i++) {//遍历前n个字符
                for (int j = i; j >= 0 && j >= i - maxw; j--) {//依次向前找0到maxw次。  最长向前找最长字符串maxw长度 减少循环次数
                    if (dp[j] && set.contains(s.substring(j, i))) {
                        dp[i] = true;
                        break;
                    }
                }
            }
            return dp[len];
        }
    }
}
