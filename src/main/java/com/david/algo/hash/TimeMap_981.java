package com.david.algo.hash;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * 981. 基于时间的键值存储
 * <p>
 * 输入：inputs = ["TimeMap","set","get","get","set","get","get"], inputs = [[],["foo","bar",1],["foo",1],["foo",3],["foo","bar2",4],["foo",4],["foo",5]]
 * 输出：[null,null,"bar","bar",null,"bar2","bar2"]
 * 解释： 
 * TimeMap kv;  
 * kv.set("foo", "bar", 1); // 存储键 "foo" 和值 "bar" 以及时间戳 timestamp = 1  
 * kv.get("foo", 1);  // 输出 "bar"  
 * kv.get("foo", 3); // 输出 "bar" 因为在时间戳 3 和时间戳 2 处没有对应 "foo" 的值，所以唯一的值位于时间戳 1 处（即 "bar"）  
 * kv.set("foo", "bar2", 4);  
 * kv.get("foo", 4); // 输出 "bar2"  
 * kv.get("foo", 5); // 输出 "bar2"  
 * <p>
 *
 * @author: david
 * @date: 2021/7/10
 */
class TimeMap_981 {
    public static void main(String[] args) {
        TimeMap timeMap = new TimeMap();
        timeMap.set("a", "bar", 1);
        timeMap.set("a", "b", 3);
        System.out.println(timeMap.get("b", 3));
        timeMap.set("foo", "bar2", 4);
        System.out.println(timeMap.get("foo", 4));
        System.out.println(timeMap.get("foo", 5));

    }

    /**
     * 使用TreeMap(红黑树)实现 把时间和value的对对应关系存红黑树
     * 插入O(logn) 查找O(logn)
     * Map<key,TreeMap<time,value>>
     */
    static class TimeMap {

        static class Node {
            String key, value;
            int t;

            public Node(String key, String value, int t) {
                this.key = key;
                this.value = value;
                this.t = t;
            }
        }

        Map<String, TreeMap<Integer, Node>> data;

        /**
         * Initialize your data structure here.
         */
        public TimeMap() {
            data = new HashMap<>();
        }

        public void set(String key, String value, int timestamp) {
            TreeMap<Integer, Node> treeMap = data.getOrDefault(key, new TreeMap<>());
            treeMap.put(timestamp, new Node(key, value, timestamp));
            data.put(key, treeMap);
        }

        public String get(String key, int timestamp) {
            TreeMap<Integer, Node> treeMap = data.get(key);
            if (treeMap == null) return "";
            Map.Entry<Integer, Node> e = treeMap.floorEntry(timestamp);
            return e != null && e.getValue().t <= timestamp ? e.getValue().value : "";
        }
    }

}
