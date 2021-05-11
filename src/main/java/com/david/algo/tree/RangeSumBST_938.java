package com.david.algo.tree;


import java.util.LinkedList;

/**
 * 输入：root = [10,5,15,3,7,null,18], low = 7, high = 15
 * 输出：32
 */
public class RangeSumBST_938 {
    /**
     * dfs
     * 最近重复子问题:sum=左树的和+自己+右树的和
     */
    class Solution {
        public int rangeSumBST(TreeNode root, int low, int high) {
            if (root == null) return 0;
            if (root.val < low) return rangeSumBST(root.right, low, high);
            if (root.val > high) return rangeSumBST(root.left, low, high);
            return root.val + rangeSumBST(root.left, low, high) + rangeSumBST(root.right, low, high);
        }
    }

    /**
     * bfs
     */
    class Solution1 {
        public int rangeSumBST(TreeNode root, int low, int high) {
            LinkedList<TreeNode> queue = new LinkedList<>();
            int sum = 0;
            queue.offer(root);
            while (!queue.isEmpty()) {
                TreeNode curr = queue.pop();
                if (curr == null) continue;
                if (curr.val < low) queue.offer(curr.right);
                else if (curr.val > high) queue.offer(curr.left);
                else {
                    sum += curr.val;
                    queue.offer(curr.left);
                    queue.offer(curr.right);
                }
            }
            return sum;
        }
    }
}
