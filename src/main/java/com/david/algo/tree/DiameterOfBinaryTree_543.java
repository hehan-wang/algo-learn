package com.david.algo.tree;

/**
 * 543. 二叉树的直径
 * 示例 :
 * 给定二叉树
 * <p>
 * 1
 * / \
 * 2   3
 * / \
 * 4   5
 * 返回 3, 它的长度是路径 [4,2,1,3] 或者 [5,2,1,3]。
 */
public class DiameterOfBinaryTree_543 {
    /**
     * 思路
     * 直径=最长节点数-1
     * 转化为求左右子树深度和的最大值
     */
    class Solution {
        int res = 0;

        public int diameterOfBinaryTree(TreeNode root) {
            dfs(root);
            return res;
        }

        private int dfs(TreeNode root) {
            if (root == null) return 0;//没有子节点的话子节点深度和为0
            int l = dfs(root.left);
            int r = dfs(root.right);
            res = Math.max(l + r, res);
            return Math.max(l, r) + 1;//当前节点深度
        }
    }
}
