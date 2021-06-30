package com.david.algo.tree;

import java.util.LinkedList;

/**
 * offer 37
 */
public class Codec {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1,
                new TreeNode(2),
                new TreeNode(3,
                        new TreeNode(4),
                        new TreeNode(5)));
        Codec codec = new Codec();
        String serialize = codec.serialize(root);
        inorder(root);
        System.out.println(serialize);
        TreeNode deserialize = codec.deserialize(serialize);
        inorder(deserialize);
    }

    public static void inorder(TreeNode treeNode) {
        if (treeNode == null) return;
        System.out.println(treeNode.val);
        inorder(treeNode.left);
        inorder(treeNode.right);
    }

    /**
     * 最近子问题
     * 当前树的序列化=join(root.val,左子树的序列化,右子树的序列化)
     */
    public String serialize(TreeNode root) {
        if (root == null) return "x";//空节点编码为x
        String left = serialize(root.left);
        String right = serialize(root.right);
        return String.join(",", String.valueOf(root.val), left, right);
    }


    public TreeNode deserialize(String data) {
        LinkedList<String> queue = new LinkedList<>();
        for (String s : data.split(",")) queue.add(s);
        return buildTree(queue);
    }

    /**
     * 最近子问题
     * 构建当前树=(root.val,构建左子树，构建右子树)
     */
    private TreeNode buildTree(LinkedList<String> queue) {
        String root = queue.removeFirst();
        if ("x".equals(root)) return null;//空节点为x
        return new TreeNode(Integer.parseInt(root), buildTree(queue), buildTree(queue));
    }
}
