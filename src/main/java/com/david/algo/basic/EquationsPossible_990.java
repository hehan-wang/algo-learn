package com.david.algo.basic;

import java.util.HashMap;
import java.util.Map;

/**
 * 连通问题用并查集
 */
public class EquationsPossible_990 {
    public static void main(String[] args) {
        System.out.println(new EquationsPossible_990().new Solution().equationsPossible(new String[]{"a==b", "b!=a"}));
    }

    /**
     * 先union 遇到==元素合并
     * 在find  遇到！= 但是找到相同root 返回false
     */
    class Solution {
        public boolean equationsPossible(String[] equations) {
            UnionFind unionFind = new UnionFind(26);
            for (String equation : equations) {
                char c1 = equation.charAt(0);
                char c2 = equation.charAt(3);
                if (equation.charAt(1) == '=') unionFind.merge(c1 - 'a', c2 - 'a');
            }
            for (String equation : equations) {
                char c1 = equation.charAt(0);
                char c2 = equation.charAt(3);
                if (equation.charAt(1) == '!' && unionFind.find(c1 - 'a') == unionFind.find(c2 - 'a')) return false;
            }
            return true;
        }
    }

    class UnionFind {
        int[] parent;

        public UnionFind(int n) {
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        public int find(int x) {
            int p = x;
            while (parent[p] != p) {
                parent[p] = parent[parent[p]];
                p = parent[p];
            }
            return p;
        }

        public void merge(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX != rootY) {
                parent[rootX] = rootY;
            }
        }
    }
}
