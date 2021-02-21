package com.david.com.david.day.d47;

import java.util.*;

public class LadderLength_127 {
    public static void main(String[] args) {
//        int i = new Solution().ladderLength("hit", "cog", List.of("hot", "dot", "dog", "lot", "log", "cog"));
        int i = new Solution1().ladderLength("hit", "cog", List.of("hot", "dot", "dog", "lot", "log", "cog"));
        System.out.println(i);
    }

    /**
     * 双向bfs
     * 思路
     * 1.使用两个set 从两个方向搜索 。每次把beginSet替换成短的，endSet 存另一端
     * 2.替换当前每个字符 a-z 代替world list 优化world list太长的时候
     * <p>
     * 模板
     * 1.边界条件wordlist中都没有endword直接返回0
     * 2.初始化beginSet endSet visited、wordlist放入Set 搜索复杂度降为O(1)
     */
    static class Solution1 {
        public int ladderLength(String beginWord, String endWord, List<String> wordList) {
            if (!wordList.contains(endWord)) return 0;
            HashSet<String> visited = new HashSet<>(),
                    beginSet = new HashSet<>(),
                    endSet = new HashSet<>(),
                    wordSet = new HashSet<>(wordList);
            beginSet.add(beginWord);
            endSet.add(endWord);
            int count = 1;
            while (!beginSet.isEmpty() && !endSet.isEmpty()) {
                if (beginSet.size() > endSet.size()) {
                    HashSet<String> tmp = beginSet;
                    beginSet = endSet;
                    endSet = tmp;
                }
                HashSet<String> newBeginSet = new HashSet<>();
                for (String curr : beginSet) {
                    char[] chars = curr.toCharArray();
                    for (int i = 0; i < chars.length; i++) {
                        char origin = chars[i];
                        for (char c = 'a'; c <= 'z'; c++) {
                            chars[i] = c;
                            String newStr = new String(chars);
                            if (endSet.contains(newStr)) return count + 1;
                            if (!visited.contains(newStr) && wordSet.contains(newStr)) {
                                newBeginSet.add(newStr);
                                visited.add(newStr);
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

    //单向bfs
    static class Solution {
        public int ladderLength(String beginWord, String endWord, List<String> wordList) {
            Queue<String> queue = new LinkedList<>();
            boolean[] visited = new boolean[wordList.size()];
            int count = 0;
            queue.offer(beginWord);
            int i = wordList.indexOf(beginWord);
            if (i >= 0) visited[i] = true;
            while (!queue.isEmpty()) {
                count++;
                int size = queue.size();
                while (size-- > 0) {
                    String curr = queue.poll();
                    //搜worldlist
                    for (int j = 0; j < wordList.size(); j++) {
                        if (visited[j]) continue;//搜过
                        String word = wordList.get(j);
                        if (!diff1(word, curr)) continue;
                        if (endWord.equals(word)) return count + 1;//搜到了
                        visited[j] = true;
                        queue.offer(word);
                    }
                }
            }
            return 0;//没搜到返回0 不能返回count
        }

        private boolean diff1(String s, String s1) {
            int diff = 0;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) != s1.charAt(i) && ++diff > 1) break; //判断有且只进一次的时候返回true
            }
            return diff == 1;
        }
    }
}
