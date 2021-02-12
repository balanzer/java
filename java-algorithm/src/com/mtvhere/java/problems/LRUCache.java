package com.mtvhere.java.problems;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache extends LinkedHashMap<Integer, Integer> {

    private static final long serialVersionUID = -936258199761787200L;

    public static void main(String[] args) {
        LRUCache lRUCache = new LRUCache(2);
        lRUCache.put(1, 1); // cache is {1=1}
        lRUCache.put(2, 2); // cache is {1=1, 2=2}
        lRUCache.get(1);    // return 1
        lRUCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
        lRUCache.get(2);    // returns -1 (not found)
        lRUCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
        lRUCache.get(1);    // return -1 (not found)
        lRUCache.get(3);    // return 3
        lRUCache.get(4);    // return 4
    }

    private int capacity;


    public LRUCache(int capacity) {

        super(capacity > 3000 ? 3000 : capacity, 0.75f, true);
        this.capacity = capacity > 3000 ? 3000 : capacity;

        System.out.println("capacity " + capacity);
    }

    public int get(int key) {

        System.out.println("get key " + key + " data " + super.keySet());
        return super.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        super.put(key, value);
        System.out.println("put " + super.keySet() + " total size : " + super.size());
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
        return this.size() > this.capacity;
        //return false;
    }
}
