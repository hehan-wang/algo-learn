package com.david.com.david.day.d13;

import javax.swing.tree.TreeNode;

//TODO 二叉数最大深度
public class MaxDepth_104 {
    public static void main(String[] args) {

    }

    class Solution {
        public int maxDepth(TreeNode root) {
            if (root == null) {//终止条件 没有子节点返回0 代表深度为0
                return 0;
            } else {
                int left = maxDepth(root.left);//取左子树深度
                int right = maxDepth(root.right);//取右面子树深度
                return Math.max(left, right) + 1;//去最大值+当前层
            }
        }
    }

    //    Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }


}
