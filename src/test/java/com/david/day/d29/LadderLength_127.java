package com.david.day.d29;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LadderLength_127 {
    public static void main(String[] args) {

    }

    /**
     * 单向bfs
     * 1.构建queue 存储bfs层级数据， 构建visited 存放过的元素 并且存放beginWord
     * 2.bfs 搜索 遍历层级 遍历词库
     */
    static class Solution {
        public int ladderLength(String beginWord, String endWord, List<String> wordList) {
            Queue<String> queue = new LinkedList<>();//存bfs层级数据
            boolean[] visited = new boolean[wordList.size()];//访问过置为true
            if (wordList.indexOf(beginWord) > 0) visited[wordList.indexOf(beginWord)] = true;
            queue.offer(beginWord);
            int count = 0;
            while (!queue.isEmpty()) {
                int size = queue.size();
                count++;//每增加一层count+1
                while (size-- > 0) {
                    String curr = queue.poll();
                    for (int i = 0; i < wordList.size(); i++) {
                        if (visited[i]) continue;//访问过跳过
                        if (!diff1(wordList.get(i), curr)) continue;//当前串跟字典里没有差1个字符的 跳过
                        if (endWord.equals(wordList.get(i))) return count + 1;//找到了
                        //否则继续查找
                        visited[i] = true;
                        queue.offer(wordList.get(i));
                    }
                }
            }
            return 0;
        }

        //只有一个字符不一样
        private boolean diff1(String s, String begin) {
            int count = 0;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) != begin.charAt(i)) {
                    if (++count > 1) break;
                }
            }
            return count == 1;
        }
    }
}
