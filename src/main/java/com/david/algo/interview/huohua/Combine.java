package com.david.algo.interview.huohua;

import java.util.ArrayList;
import java.util.List;

/**
 * 火花思维一面
 * 数组M=[1,2,3,4,5,6,15,20,30,40,50,...139...]
 * 取一个组合，组合内个数不限，使加和最接近与N
 */
public class Combine {
    public static void main(String[] args) {
        System.out.println(new Combine().new solution().find(List.of(1, 2, 3, 5, 6, 22, 34, 56, 67, 131), 35));
    }

    /**
     * 1.获取所有组合
     * 2.取出绝对值最接近的
     * O(m^3)
     */
    public class solution {
        public List<List<Integer>> res = new ArrayList<>();

        public void dfs(List<Integer> input, int count, int curr, List<Integer> tmp, int start) {
            if (curr == count) {
                res.add(List.copyOf(tmp));
                return;
            }
            for (int i = start + 1; i < input.size(); i++) {//避免重复拿
                tmp.add(input.get(i));
                dfs(input, count, curr + 1, tmp, i);
                tmp.remove(tmp.size() - 1);
            }
        }

        //取出所有组合
        public List<List<Integer>> combine(List<Integer> input, int count) {
            res = new ArrayList<>();
            dfs(input, count, 0, new ArrayList<>(), -1);
            return res;
        }

        public List<Integer> find(List<Integer> m, int n) {
            int abs = Integer.MAX_VALUE;
            List<Integer> res = List.of();
            for (int i = 0; i < m.size(); i++) {
                List<List<Integer>> combine = combine(m, i);
                //取绝对值最小的
                for (List<Integer> l : combine) {
                    int sum = l.stream().mapToInt(Integer::valueOf).sum();
                    int curr = Math.abs(sum - n);
                    if (curr < abs) {
                        res = l;
                        abs = curr;
                    }
                }
            }
            return res;
        }
    }
}
