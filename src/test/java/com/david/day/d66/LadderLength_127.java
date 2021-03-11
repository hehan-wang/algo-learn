package com.david.day.d66;

import java.util.HashSet;
import java.util.List;

public class LadderLength_127 {
    public static void main(String[] args) {
        int i = new Solution().ladderLength("hit", "cog", List.of("hot", "dot", "dog", "lot", "log", "cog"));
        System.out.println(i);
    }


    //双向bfs
    static class Solution {
        public int ladderLength(String beginWord, String endWord, List<String> wordList) {
            HashSet<String> beginSet = new HashSet<>(), endSet = new HashSet<>(), visited = new HashSet<>(), wordSet = new HashSet<>(wordList);
            if (!wordSet.contains(endWord)) return 0;
            int count = 1;
            beginSet.add(beginWord);
            endSet.add(endWord);
            while (!beginSet.isEmpty() && !endSet.isEmpty()) {
                //beginSet替换成短的
                if (beginSet.size() > endSet.size()) {
                    HashSet<String> tmp = beginSet;
                    beginSet = endSet;
                    endSet = tmp;
                }
                //bfd每个单词每个字母a-z
                HashSet<String> newBeginSet = new HashSet<>();
                for (String curr : beginSet) {
                    char[] chars = curr.toCharArray();
                    for (int i = 0; i < chars.length; i++) {
                        char origin = chars[i];
                        for (char c = 'a'; c <= 'z'; c++) {
                            chars[i] = c;
                            String newStr = String.valueOf(chars);
                            if (endSet.contains(newStr)) return count + 1;//两个set相遇了，找到返回
                            if (!visited.contains(newStr) && wordSet.contains(newStr)) {
                                visited.add(newStr);
                                newBeginSet.add(newStr);
                            }
                        }
                        chars[i] = origin;//回溯
                    }
                }
                beginSet = newBeginSet;
                count++;
            }
            return 0;
        }
    }
}
