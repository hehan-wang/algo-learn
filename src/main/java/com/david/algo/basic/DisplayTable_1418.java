package com.david.algo.basic;

import com.sun.source.tree.Tree;

import java.util.*;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.Collections.addAll;

/**
 * @author: david
 * @date: 2021/7/6
 */
public class DisplayTable_1418 {
    public static void main(String[] args) {
        System.out.println(new DisplayTable_1418().new Solution().displayTable(List.of(
                List.of("David", "3", "Ceviche"),
                List.of("Corina", "10", "Beef Burrito"),
                List.of("David", "3", "Fried Chicken"),
                List.of("Carla", "5", "Water"),
                List.of("Carla", "5", "Ceviche"),
                List.of("Rous", "3", "Ceviche")
        )));
    }

    /**
     * hash表实现 一坨屎
     */
    class Solution {
        public List<List<String>> displayTable(List<List<String>> orders) {
            List<List<String>> res = new ArrayList<>();
            //<食物,<桌号,个数>>
            Map<String, Map<String, Long>> collect = orders.stream().collect(
                    Collectors.groupingBy(l -> l.get(2),
                            Collectors.groupingBy(l -> l.get(1),
                                    Collectors.counting())));
            List<String> header = new ArrayList<>();
            header.add("Table");
            header.addAll(collect.keySet().stream().sorted().collect(Collectors.toList()));

            HashMap<String, Integer> foodIndexMap = new HashMap<>();//食物下标
            for (int i = 0; i < header.size(); i++) foodIndexMap.put(header.get(i), i);

            TreeMap<String, List<String>> body = new TreeMap<>(Comparator.comparingInt(Integer::parseInt));//按桌子排序
            for (Map.Entry<String, Map<String, Long>> foods : collect.entrySet()) {
                String food = foods.getKey();//食物名称
                Map<String, Long> cnt = foods.getValue();
                for (Map.Entry<String, Long> c : cnt.entrySet()) {
                    String t = c.getKey();//桌号
                    if (!body.containsKey(t)) {
                        ArrayList<String> table = new ArrayList<>(header.size());
                        table.add(t);
                        for (int i = 1; i < header.size(); i++) table.add("0");
                        body.put(t, table);
                    }
                    List<String> table = body.get(t);
                    Integer integer = foodIndexMap.get(food);
                    table.set(integer, String.valueOf(c.getValue()));
                }
            }
            res.add(header);
            res.addAll(body.values());
            return res;
        }
    }
}

