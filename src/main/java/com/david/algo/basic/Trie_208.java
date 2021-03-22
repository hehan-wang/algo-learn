package com.david.algo.basic;

public class Trie_208 {
    public static void main(String[] args) {
        Trie root = new Trie_208().new Trie();

        root.insert("apple");
        System.out.println(root.search("apple"));// 返回 true
        System.out.println(root.search("app"));// 返回 false
        System.out.println(root.startsWith("app"));// 返回 true
        root.insert("app");
        System.out.println(root.search("app"));// 返回 true
        System.out.println("---end---");
    }

    class Trie {
        private boolean isEnd;
        private Trie[] next;

        /**
         * Initialize your data structure here.
         */
        public Trie() {
            isEnd = false;
            next = new Trie[26];
        }

        /**
         * Inserts a word into the trie.
         */
        public void insert(String word) {
            if (word == null || word.length() == 0) return;
            char[] chars = word.toCharArray();
            Trie curr = this;
            for (char c : chars) {
                int index = c - 'a';
                if (curr.next[index] == null) curr.next[index] = new Trie();
                curr = curr.next[index];
            }
            curr.isEnd = true;
        }

        /**
         * Returns if the word is in the trie.
         */
        public boolean search(String word) {
            if (word == null || word.length() == 0) return false;
            Trie trie = searchPrefix(word);
            return trie != null && trie.isEnd;
        }

        /**
         * Returns if there is any word in the trie that starts with the given prefix.
         */
        public boolean startsWith(String prefix) {
            if (prefix == null || prefix.length() == 0) return false;
            return searchPrefix(prefix) != null;
        }

        private Trie searchPrefix(String prefix) {
            char[] chars = prefix.toCharArray();
            Trie curr = this;
            for (char c : chars) {
                int index = c - 'a';
                if (curr.next[index] == null) return null;
                curr = curr.next[index];
            }
            return curr;
        }
    }
}
