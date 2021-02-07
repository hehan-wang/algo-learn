package com.david.com.david.day.d39;

import java.util.ArrayList;
import java.util.List;

public class Preorder_589 {
    public static void main(String[] args) {

    }

    //dfs
    static class Solution {

        public List<Integer> preorder(Node root) {
            List<Integer> res = new ArrayList<>();
            if (root == null) return res;
            dfs(res, root);
            return res;
        }

        private void dfs(List<Integer> res, Node root) {
            //terminator
            if (root == null) return;
            //process
            res.add(root.val);
            //drill down
            if (root.children != null && root.children.size() > 0) root.children.forEach(r -> dfs(res, r));
        }
    }


    static class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    ;
}
