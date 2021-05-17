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
}
