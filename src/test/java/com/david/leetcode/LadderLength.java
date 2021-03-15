package com.david.leetcode;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LadderLength {


    //双向bfs
    class Solution {
        public int ladderLength(String beginWord, String endWord, List<String> wordList) {
            if (!wordList.contains(endWord)) return 0;
            int count = 1;
            Set<String> beginSet = new HashSet<>(), endSet = new HashSet<>(), visited = new HashSet<>(), wordSet = new HashSet<>(wordList);
            beginSet.add(beginWord);
            endSet.add(endWord);
            while (!beginSet.isEmpty() && !endSet.isEmpty()) {
                if (beginSet.size() > endSet.size()) {
                    Set<String> tmp = beginSet;
                    beginSet = endSet;
                    endSet = tmp;
                }
                Set<String> newBeginSet = new HashSet<>();
                for (String word : beginSet) {
                    char[] chars = word.toCharArray();
                    for (int i = 0; i < chars.length; i++) {
                        char origin = chars[i];
                        for (char j = 'a'; j <= 'z'; j++) {
                            chars[i] = j;
                            String newStr = new String(chars);
                            if (endSet.contains(newStr)) return count + 1;
                            if (!visited.contains(newStr) && wordSet.contains(newStr)) {
                                visited.add(newStr);
                                newBeginSet.add(newStr);
                            }
                        }
                        chars[i] = origin;
                    }
                }
                beginSet = newBeginSet;
                count++;
            }
            return 0;
        }
    }
}
