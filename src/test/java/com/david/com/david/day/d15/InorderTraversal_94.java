package com.david.com.david.day.d15;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 中序遍历
 */
public class InorderTraversal_94 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, null, new TreeNode(2, new TreeNode(3), null));
//        List<Integer> res = new Solution().inorderTraversal(root);
        List<Integer> res = new Solution1().inorderTraversal(root);
        System.out.println(res);
    }

    //栈
    static class Solution1 {
        public List<Integer> inorderTraversal(TreeNode root) {
            ArrayList<Integer> res = new ArrayList<>();
            if (root == null) return res;
            LinkedList<TreeNode> stack = new LinkedList<>();
            TreeNode curr = root;
            while (curr != null || !stack.isEmpty()) {
                while (curr != null) {//左边元素入栈到最左
                    stack.push(curr);
                    curr = curr.left;
                }
                curr = stack.pop();//左边出栈
                res.add(curr.val);//放入值
                curr = curr.right;//右边入栈
            }
            return res;
        }
    }

    //递归
    static class Solution {
        public List<Integer> inorderTraversal(TreeNode root) {
            List<Integer> res = new ArrayList<>();
            if (root == null) return res;
            inOrder(res, root);
            return res;
        }

        private void inOrder(List<Integer> res, TreeNode curr) {
            if (curr == null) return;
            inOrder(res, curr.left);
            res.add(curr.val);
            inOrder(res, curr.right);
        }
    }

    public static class TreeNode {
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
