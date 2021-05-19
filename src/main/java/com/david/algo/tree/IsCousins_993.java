package com.david.algo.tree;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/**
 * 993. 二叉树的堂兄弟节点
 * 输入：root = [1,2,3,null,4,null,5], x = 5, y = 4
 * 输出：true
 */
public class IsCousins_993 {

    /**
     * 使用bfs 把[当前值,父亲,深度] 包装在一起传递
     */
    class Solution2 {
        public boolean isCousins(TreeNode root, int x, int y) {
            int[] xi = bfs(root, x);
            int[] yi = bfs(root, y);
            return xi[0] == yi[0] && xi[1] != yi[1];
        }

        /**
         * @param root 根节点
         * @param t    查找的节点值
         * @return [深度, 父亲]
         */
        private int[] bfs(TreeNode root, int t) {
            LinkedList<Object[]> queue = new LinkedList<>();//[当前值,父亲,深度]
            queue.offer(new Object[]{root, null, 0});
            while (!queue.isEmpty()) {
                int size = queue.size();
                while (size-- > 0) {
                    Object[] obj = queue.poll();
                    TreeNode curr = (TreeNode) obj[0], parent = (TreeNode) obj[1];
                    int depth = (int) obj[2];
                    if (curr.val == t) return new int[]{depth, parent == null ? 0 : parent.val};
                    if (curr.left != null) queue.offer(new Object[]{curr.left, curr, depth + 1});
                    if (curr.right != null) queue.offer(new Object[]{curr.right, curr, depth + 1});
                }
            }
            return new int[]{-1, -1};//没找到
        }
    }

    /**
     * 思路
     * bfs+hash bfs一层一层遍历 hash存<子节点,父节点>
     */
    class Solution {
        public boolean isCousins(TreeNode root, int x, int y) {
            LinkedList<TreeNode> queue = new LinkedList<>();
            HashMap<Integer, Integer> map = new HashMap<>();//存子和父的映射
            queue.offer(root);
            while (!queue.isEmpty()) {
                Set<Integer> currLevel = new HashSet<>();//存当前层级兄弟节点集合
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    TreeNode curr = queue.poll();
                    currLevel.add(curr.val);
                    if (curr.left != null) {
                        map.put(curr.left.val, curr.val);
                        queue.offer(curr.left);
                    }
                    if (curr.right != null) {
                        map.put(curr.right.val, curr.val);
                        queue.offer(curr.right);
                    }
                }
                //判断两个节点是否在同一层 而且不同父亲
                if (currLevel.contains(x) && currLevel.contains(y) && !map.get(x).equals(map.get(y))) return true;
            }
            return false;
        }
    }

    /**
     * 使用dfs 存储x y的深度和父亲 最后比较
     */
    class Solution1 {
        int depth1 = 0, depth2 = 0;//存两个节点的深度
        TreeNode parent1 = null, parent2 = null;//存两个节点的父节点

        public boolean isCousins(TreeNode root, int x, int y) {
            dfs(root, null, x, y, 0);
            return depth1 == depth2 && parent1 != parent2;//深度相同 父亲不同¬
        }

        private void dfs(TreeNode root, TreeNode parent, int x, int y, int depth) {
            if (root == null) return;
            if (root.val == x) {//找到x 填充x的信息
                depth1 = depth;
                parent1 = parent;
            }
            if (root.val == y) {//同上
                depth2 = depth;
                parent2 = parent;
            }
            dfs(root.left, root, x, y, depth + 1);//dfs左孩子 深度+1 然后left的父亲当然是当前root
            dfs(root.right, root, x, y, depth + 1);
        }
    }
}
