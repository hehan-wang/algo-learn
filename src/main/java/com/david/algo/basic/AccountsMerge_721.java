package com.david.algo.basic;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 输入：
 * accounts = [["John", "johnsmith@mail.com", "john00@mail.com"], ["John", "johnnybravo@mail.com"], ["John", "johnsmith@mail.com", "john_newyork@mail.com"], ["Mary", "mary@mail.com"]]
 * <p>
 * 输出：
 * [["John", 'john00@mail.com', 'john_newyork@mail.com', 'johnsmith@mail.com'],  ["John", "johnnybravo@mail.com"], ["Mary", "mary@mail.com"]]
 * <p>
 * 解释：
 * 第一个和第三个 John 是同一个人，因为他们有共同的邮箱地址 "johnsmith@mail.com"。
 * 第二个 John 和 Mary 是不同的人，因为他们的邮箱地址没有被其他帐户使用。
 * 可以以任何顺序返回这些列表，例如答案 [['Mary'，'mary@mail.com']，['John'，'johnnybravo@mail.com']，
 * ['John'，'john00@mail.com'，'john_newyork@mail.com'，'johnsmith@mail.com']] 也是正确的。
 * <p>
 */
public class AccountsMerge_721 {
    public static void main(String[] args) {
        List<List<String>> l = List.of(List.of("John", "johnsmith@mail.com", "john00@mail.com"),
                List.of("John", "johnnybravo@mail.com"),
                List.of("John", "johnsmith@mail.com", "john_newyork@mail.com"),
                List.of("Mary", "mary@mail.com")
        );
        System.out.println(new AccountsMerge_721().new Solution().accountsMerge(l));
        ;
    }

    /**
     * 并查集+map
     * 账号个数作为连通
     */
    class Solution {
        public List<List<String>> accountsMerge(List<List<String>> accounts) {
            //<邮箱,用户id>
            Map<String, Integer> email2Id = new HashMap<>();
            UnionFind unionFind = new UnionFind(accounts.size());//n列n个人
            for (int i = 0; i < accounts.size(); i++) {
                List<String> a = accounts.get(i);
                for (int j = 1; j < a.size(); j++) {
                    String email = a.get(j);
                    //如果map中存在该邮箱 合并，否则添加
                    if (email2Id.containsKey(email)) {
                        unionFind.union(email2Id.get(email), i);
                    } else {
                        email2Id.put(email, i);
                    }
                }
            }
            //转化成<用户id,List<邮箱>>
            Map<Integer, List<String>> collect = email2Id.entrySet().stream().collect(Collectors.groupingBy(e -> unionFind.find(e.getValue()), Collectors.mapping(Map.Entry::getKey, Collectors.toList())));
            List<List<String>> res = collect.entrySet().stream().map(e -> {
                ArrayList<String> l = new ArrayList<>();
                l.add(accounts.get(e.getKey()).get(0));
                List<String> value = e.getValue();
                Collections.sort(value);
                l.addAll(value);
                return l;
            }).collect(Collectors.toList());
            return res;
        }
    }

    public class UnionFind {
        private int[] parent;

        public UnionFind(int n) {
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        public int find(int p) {//到顶了
            while (p != parent[p]) {
                parent[p] = parent[parent[p]];//爷爷赋给爸爸
                p = parent[p];//一次迭代两个
            }
            return p;
        }

        public void union(int p, int q) {
            int rootP = find(p);//找到p的根
            int rootQ = find(q);//找到q的根
            if (rootP == rootQ) return;//如果在相等则为同一个树
            parent[rootP] = rootQ;//否则一个合道另一个下面
        }
    }
}
