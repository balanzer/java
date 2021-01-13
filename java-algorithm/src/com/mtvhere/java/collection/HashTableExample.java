package com.mtvhere.java.collection;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.LinkedList;

public class HashTableExample {
    public static void main(final String[] args) {
        final Hashtable<Integer, String> table = new Hashtable<>();

        table.put(1, "Hello");
        table.put(2, "Hello");
        table.put(4, "Hello");
        table.put(4, "Hello1");
        table.put(4, "Hello2");


        System.out.println("Keys : " + table.keySet());

        final HashMap<Integer, LinkedList<String>> map = new HashMap<>();
        final LinkedList<String> list = new LinkedList<>();
        list.add("hello");
        map.put(1, list);
        map.get(1).add("world");

        System.out.println("Keys : " + map.keySet());
        System.out.println("Values : " + map.get(1));

    }
}
