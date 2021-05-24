package com.david.algo.tree;

/**
 * 617. 合并二叉树
 * 输入:
 * Tree 1                     Tree 2
 * 1                         2
 * / \                       / \
 * 3   2                     1   3
 * /                           \   \
 * 5                             4   7
 * 输出:
 * 合并后的树:
 * 3
 * / \
 * 4   5
 * / \   \
 * 5   4   7
 */
public class MergeTrees_617 {
    /**
     * 子问题 两个树的值相加
     * 左子树=merge(root1左子树,root2左子树 )
     */
    class Solution {
        public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
            if (root1 == null && root2 == null) return null;
            int val = (root1 == null ? 0 : root1.val) +
                    (root2 == null ? 0 : root2.val);
            TreeNode newRoot = new TreeNode(val);
            newRoot.left = mergeTrees(root1 == null ? null : root1.left, root2 == null ? null : root2.left);
            newRoot.right = mergeTrees(root1 == null ? null : root1.right, root2 == null ? null : root2.right);
            return newRoot;
        }
    }

    //简单判断版
    class Solution1 {
        public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
            if (root1 == null) return root2;//root1为空的话直接返回root2的节点
            if (root2 == null) return root1;
            TreeNode newRoot = new TreeNode(root1.val + root2.val);
            newRoot.left = mergeTrees(root1.left, root2.left);
            newRoot.right = mergeTrees(root1.right, root2.right);
            return newRoot;
        }
    }
}
