package com.david.day.d18;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LowestCommonAncestor_offer68 {
    static List<TreeNode> list = IntStream.rangeClosed(0, 9).mapToObj(TreeNode::new).collect(Collectors.toList());

    public static void main(String[] args) {
        TreeNode root = getNode(3);
        root.left = getNode(5);
        root.right = getNode(1);
        getNode(5).left = getNode(6);
        getNode(5).right = getNode(2);
        getNode(2).left = getNode(7);
        getNode(2).right = getNode(4);
        getNode(1).left = getNode(0);
        getNode(1).right = getNode(8);


        TreeNode ancestor = new Solution().lowestCommonAncestor(root, getNode(7), getNode(4));
        System.out.println(ancestor);
    }

    static TreeNode getNode(int num) {
        return list.get(num);
    }

    /**
     * 递归法 后序遍历树
     * https://leetcode-cn.com/problems/er-cha-shu-de-zui-jin-gong-gong-zu-xian-lcof/solution/mian-shi-ti-68-ii-er-cha-shu-de-zui-jin-gong-gon-7/
     * <p>
     * 1.当 left 和 right 同时为空 ：说明 root 的左 / 右子树中都不包含 p,q ，返回 null ；
     * 2.当 left 和 right 同时不为空 ：说明 p, q 分列在 root 的 异侧 （分别在 左 / 右子树），因此 root 为最近公共祖先，返回 root ；
     * 3.当 left 为空 ，right 不为空 ：p,q 都不在 root 的左子树中，直接返回 right 。具体可分为两种情况：
     * p,q 其中一个在 root 的 右子树 中，此时 right 指向 p（假设为 p ）；
     * p,q 两节点都在 root 的 右子树 中，此时的 right 指向 最近公共祖先节点 ；
     * 4.当 left 不为空 ， right 为空 ：与情况 3. 同理；
     */
    static class Solution {
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            /**
             * 父节点为null 证明找到叶子节点没找到元素。
             * 父节点为p，则p肯定是q的最近父亲。
             * 父节点为q同理。
             */
            if (root == null || root == q || root == p) return root;
            TreeNode left = lowestCommonAncestor(root.left, p, q);//迭代左孩子
            TreeNode right = lowestCommonAncestor(root.right, p, q);//迭代右孩子
            if (left == null) return right;//不在左子树返回right
            if (right == null) return left;//不在右子树返回left
            return root;//q p在root两边返回root
        }
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            TreeNode treeNode = (TreeNode) o;
            return val == treeNode.val;
        }

        @Override
        public int hashCode() {
            return Objects.hash(val);
        }

        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder("TreeNode{");
            sb.append("val=").append(val);
            sb.append(", left=").append(left);
            sb.append(", right=").append(right);
            sb.append('}');
            return sb.toString();
        }
    }
}
