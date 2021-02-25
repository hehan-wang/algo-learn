package com.david.leetcode;

public class MirrorTree_offer27 {
    public static void main(String[] args) {

    }

    static public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * dfs 子问题为替换
     */
    static class Solution {
        public TreeNode mirrorTree(TreeNode root) {
            if (root == null) return root;
            TreeNode tmp = root.left;
            root.left = mirrorTree(root.right);
            root.right = mirrorTree(tmp);
            return root;
        }
    }
}
