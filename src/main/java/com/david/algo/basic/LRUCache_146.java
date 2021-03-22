package com.david.algo.basic;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 1.使用系统LinkedHashMap
 * 2.使用HashMap+LinkedList
 */
public class LRUCache_146 extends LinkedHashMap<Integer, Integer> {
    int capacity;

    public LRUCache_146(int capacity) {
        super(capacity, 0.75f, true);//true开启lru
        this.capacity = capacity;
    }

    public int get(int key) {
        return super.getOrDefault(key, -1);
    }

    public int put(int key, int value) {
        return super.put(key, value);
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
        return size() > capacity;
    }
}
