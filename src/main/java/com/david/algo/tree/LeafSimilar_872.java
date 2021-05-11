package com.david.algo.tree;

import java.util.ArrayList;
import java.util.Collections;

/**
 * 872. 叶子相似的树
 * 思路：
 * 1.相同方式遍历两棵树 判断数组是否相等
 */
public class LeafSimilar_872 {
    /**
     * 思路1 ### 解题思路
     * 遍历两棵树把叶子节点放入list中 再进行比较 O(m+n)
     */
    class Solution {
        public boolean leafSimilar(TreeNode root1, TreeNode root2) {
            ArrayList<Integer> l1 = new ArrayList<>(), l2 = new ArrayList<>();
            inorder(root1, l1);
            inorder(root2, l2);
            if (l1.size() != l2.size()) return false;
            for (int i = 0; i < l1.size(); i++) {
                if (!l1.get(i).equals(l2.get(i))) return false;
            }
            return true;
        }

        private void inorder(TreeNode root, ArrayList<Integer> l) {
            if (root == null) return;//到末尾了返回
            if (root.left == null && root.right == null) l.add(root.val);//到叶子节点了加入数组
            inorder(root.left, l);
            inorder(root.right, l);
        }
    }
}
