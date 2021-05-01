package com.david.algo.d2021_05;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * 输入：[[1, 5, [2, 3]], [2, 3, []], [3, 3, []]], 1
 * 输出：11
 * 解释：
 * 员工 1 自身的重要度是 5 ，他有两个直系下属 2 和 3 ，而且 2 和 3 的重要度均为 3 。因此员工 1 的总重要度是 5 + 3 + 3 = 11 。
 */
public class GetImportance_690 {

    public static void main(String[] args) {
        List<Employee> l = List.of(
                new Employee(1, 5, List.of(2, 3)),
                new Employee(2, 3, List.of()),
                new Employee(3, 3, List.of())
        );
        System.out.println(new GetImportance_690().new Solution().getImportance(l, 1));
        System.out.println(new GetImportance_690().new Solution1().getImportance(l, 1));
    }

    //整理了下面的代码
    class Solution1 {

        public int getImportance(List<Employee> employees, int id) {
            //先把employee放入map缓存O(n)
            Map<Integer, Employee> cache = employees.stream().collect(Collectors.toMap(e -> e.id, Function.identity()));
            return sum(cache, id);
        }

        /**
         * 最近重复子问题：总权重=自己的权重+下级的权重和
         */
        public int sum(Map<Integer, Employee> cache, int id) {
            int res = 0;
            Employee e = cache.get(id);
            res += e.importance;//加入自己的权重
            if (e.subordinates == null || e.subordinates.size() == 0) return res;
            res += e.subordinates.stream().map(cache::get).map(s -> sum(cache, s.id)).mapToInt(Integer::intValue).sum();//加入下级的权重
            return res;
        }
    }

    /**
     * 思路：
     * 使用map缓存employee
     */
    class Solution {
        int res = 0;

        public int getImportance(List<Employee> employees, int id) {
            Map<Integer, Employee> cache = employees.stream().collect(Collectors.toMap(e -> e.id, Function.identity()));
            Employee employee = cache.get(id);
            if (employee == null) return 0;
            sum(employee, cache);
            return res;
        }

        public void sum(Employee e, Map<Integer, Employee> cache) {
            res += e.importance;
            if (e.subordinates == null || e.subordinates.size() == 0) return;
            for (Integer sub : e.subordinates) {
                sum(cache.get(sub), cache);
            }
        }
    }

    static class Employee {
        public int id;
        public int importance;
        public List<Integer> subordinates;

        public Employee(int id, int importance, List<Integer> subordinates) {
            this.id = id;
            this.importance = importance;
            this.subordinates = subordinates;
        }
    }
}
