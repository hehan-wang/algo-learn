package com.david.com.david.day.d18;

public class LowestCommonAncestor_offer68 {
    public static void main(String[] args) {

    }

    /**
     * 递归法 后序遍历树
     * https://leetcode-cn.com/problems/er-cha-shu-de-zui-jin-gong-gong-zu-xian-lcof/solution/mian-shi-ti-68-ii-er-cha-shu-de-zui-jin-gong-gon-7/
     *
     * 1.当 left 和 right 同时为空 ：说明 root 的左 / 右子树中都不包含 p,q ，返回 null ；
     * 2.当 left 和 right 同时不为空 ：说明 p, q 分列在 root 的 异侧 （分别在 左 / 右子树），因此 root 为最近公共祖先，返回 root ；
     * 3.当 left 为空 ，right 不为空 ：p,q 都不在 root 的左子树中，直接返回 right 。具体可分为两种情况：
     *   p,q 其中一个在 root 的 右子树 中，此时 right 指向 p（假设为 p ）；
     *   p,q 两节点都在 root 的 右子树 中，此时的 right 指向 最近公共祖先节点 ；
     * 4.当 left 不为空 ， right 为空 ：与情况 3. 同理；
     *
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

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
