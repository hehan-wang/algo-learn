package com.david.algo.trie;

/**
 * 输入：nums = [3,10,5,25,2,8]
 * 输出：28
 * 解释：最大运算结果是 5 XOR 25 = 28.
 */
public class FindMaximumXOR_421 {
    public static void main(String[] args) {
        System.out.println(new FindMaximumXOR_421().new Solution().findMaximumXOR(new int[]{3, 10, 5, 25, 2, 8}));
        System.out.println(new FindMaximumXOR_421().new Solution1().findMaximumXOR(new int[]{3, 10, 5, 25, 2, 8}));
    }

    /**
     * 重点！由于数字位运算 把数字转化为32位的bit 使用两个子节点的trie树
     * 使用trie树 依次存从高到低位 循环一次。
     * 每个数字遍历30次  O(30n)~=O(n)
     */
    class Solution1 {
        int MAX_INT_BITS = 30;//int 最长30位
        TrieNode root = new TrieNode();

        class TrieNode {
            TrieNode[] child = new TrieNode[2];//只有0 1两种情况
        }

        //加入字典树
        public void add(int num) {
            TrieNode p = this.root;
            for (int i = MAX_INT_BITS; i >= 0; i--) {
                int bit = num >> i & 1;//从高到低位依次取每一位
                if (p.child[bit] == null) p.child[bit] = new TrieNode();
                p = p.child[bit];
            }
        }

        //查找字典树
        public int search(int num) {
            TrieNode p = this.root;
            int res = 0;
            for (int i = MAX_INT_BITS; i >= 0; i--) {
                int bit = num >> i & 1;
                if (p.child[bit ^ 1] != null) {//证明这一位有1
                    res += (1 << i);
                    p = p.child[bit ^ 1];
                } else p = p.child[bit];//0^bit = bit
            }
            return res;
        }

        public int findMaximumXOR(int[] nums) {
            int max = 0;
            for (int i = 1; i < nums.length; i++) {
                add(nums[i - 1]);
                max = Math.max(max, search(nums[i]));
            }
            return max;
        }
    }

    /**
     * O(n^2)暴力法枚举两个数
     */
    class Solution {
        public int findMaximumXOR(int[] nums) {
            int max = 0, n = nums.length;
            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    max = Math.max(max, nums[i] ^ nums[j]);
                }
            }
            return max;
        }
    }
}
