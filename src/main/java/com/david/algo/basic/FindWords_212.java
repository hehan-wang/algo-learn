package com.david.algo.basic;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FindWords_212 {
    public static void main(String[] args) {
        String[] words = {"oath", "pea", "eat", "rain"};
//        String[] words = {"eat"};
        char[][] board = new char[][]{
                {'o', 'a', 'a', 'n'},
                {'e', 't', 'a', 'e'},
                {'i', 'h', 'k', 'r'},
                {'i', 'f', 'l', 'v'}
        };
        System.out.println(new FindWords_212().new Solution().findWords(board, words));
    }

    /**
     * 使用trie存words  四通图dfs+回溯 搜索
     */
    class Solution {
        int[] dx = new int[]{1, -1, 0, 0};
        int[] dy = new int[]{0, 0, 1, -1};
        Set<String> res = new HashSet<>();

        public List<String> findWords(char[][] board, String[] words) {
            Trie root = new Trie();
            //1.放入trie
            for (String w : words) {
                root.insert(w);
            }
            //2.dfs
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[0].length; j++) {
                    dfs(board, root, i, j);
                }
            }
            return new ArrayList<>(res);
        }

        private void dfs(char[][] board, Trie root, int i, int j) {
            //terminator
            if (i < 0 || i >= board.length || j < 0 || j >= board[0].length) return;
            if (board[i][j] == 'x') return;
            //process
            char c = board[i][j];
            root = root.search(board[i][j]);
            if (root == null) return;
            if (root.isEnd) res.add(root.word);
            board[i][j] = 'x';
            //drill down
            for (int d = 0; d < 4; d++) {
                dfs(board, root, i + dx[d], j + dy[d]);
            }
            //revert states
            board[i][j] = c;
        }

        public class Trie {
            private Trie[] children = new Trie[26];
            private boolean isEnd = false;
            private String word;

            public void insert(String word) {
                if (word == null || word.length() == 0) return;
                Trie curr = this;
                for (char c : word.toCharArray()) {
                    int i = c - 'a';
                    if (curr.children[i] == null) curr.children[i] = new Trie();
                    curr = curr.children[i];
                }
                curr.isEnd = true;
                curr.word = word;
            }

            public Trie search(char c) {
                return children[c - 'a'];
            }
        }
    }


}
