package com.david.algo.interview.feishu;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * 一面 二叉树层序遍历
 */
public class Part1 {

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
    }

    public class Solution {
        /**
         * @param root TreeNode类
         * @return int整型ArrayList<ArrayList <>>
         */
        public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
            // write code here
            ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
            if (root == null) return res;
            LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
            queue.add(root);
            while (!queue.isEmpty()) {
                int size = queue.size();
                ArrayList<Integer> currLevel = new ArrayList<Integer>();
                while (size-- > 0) {
                    TreeNode curr = queue.pollFirst();
                    currLevel.add(curr.val);
                    if (curr.left != null) queue.offerLast(curr.left);
                    if (curr.right != null) queue.offerLast(curr.right);
                }
                res.add(currLevel);
            }
            return res;
        }

    }


// public class Solution {
//     /**
//      *
//      * @param root TreeNode类
//      * @return int整型ArrayList<ArrayList<>>
//      */
//     public ArrayList<ArrayList<Integer>> levelOrder (TreeNode root) {
//         // write code here
//        ArrayList<ArrayList<Integer>> res =  new ArrayList<ArrayList<Integer>>();
//        dfs(res,root,0);
//        return res;
//     }
//     public void dfs(ArrayList<ArrayList<Integer>> res,TreeNode root,int level){
//         if(root==null)return;
//         if(res.size()==level) res.add(new ArrayList<Integer>()); //到最新一层
//         res.get(level).add(root.val);
//         dfs(res,root.left,level+1);
//         dfs(res,root.right,level+1);
//     }
// }

}
