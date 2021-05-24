package com.david.algo.tree;

import java.util.LinkedList;

/**
 * 101. 对称二叉树
 */
public class IsSymmetric_101 {
    public static void main(String[] args) {
        TreeNode root =
                new TreeNode(1,
                        new TreeNode(2,
                                null,
                                new TreeNode(2)),
                        new TreeNode(2,
                                null,
                                new TreeNode(3)));
        System.out.println(new IsSymmetric_101().new Solution().isSymmetric(root));
        System.out.println(new IsSymmetric_101().new Solution1().isSymmetric(root));
    }

    /**
     * 思路
     * 最近子问题比较left.left==right.right &left.right==right.left
     * O(2n) >> O(n)
     */
    class Solution {
        public boolean isSymmetric(TreeNode root) {
            if (root == null) return true;
            return dfs(root.left, root.right);
        }

        private boolean dfs(TreeNode left, TreeNode right) {
            if (left == null && right == null) return true;
            if (left == null || right == null) return false;
            if (left.val != right.val) return false;
            return dfs(left.left, right.right) && dfs(left.right, right.left);
        }
    }

    /**
     * 思路
     * 使用队列bfs
     * 分别把成对的一起放入队列
     */
    class Solution1 {
        public boolean isSymmetric(TreeNode root) {
            if (root == null || (root.left == null && root.right == null)) return true;
            LinkedList<TreeNode> queue = new LinkedList<>();
            queue.offer(root.left);
            queue.offer(root.right);
            while (!queue.isEmpty()) {
                TreeNode left = queue.poll(), right = queue.poll();
                if (left == null && right == null) continue;//继续向下比
                if (left == null || right == null) return false;//一个为空一个不为空不对称
                if (left.val != right.val) return false;//左右不相等
                queue.offer(left.left);
                queue.offer(right.right);
                queue.offer(left.right);
                queue.offer(right.left);
            }
            return true;
        }
    }
}
