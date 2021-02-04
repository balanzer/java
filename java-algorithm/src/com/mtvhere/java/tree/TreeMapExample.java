package com.mtvhere.java.tree;

import java.util.TreeMap;
import java.util.TreeSet;

public class TreeMapExample {
    public static void main(final String[] args) {
        final TreeMap<Integer, Integer> tree = new TreeMap<>((o1, o2) -> {
            return o2.compareTo(o1);
        });

        tree.put(10, 10);
        tree.put(1, 1);
        tree.put(101, 101);
        tree.put(-1, -1);
        tree.put(0, 0);


        System.out.println(tree);


        System.out.println("Min is " + tree.lastEntry());
        System.out.println("Max is " + tree.firstEntry());
        System.out.println("Keys " + tree.keySet());

        final TreeSet<Integer> setTree = new TreeSet<>((a, b) -> {
            return b.compareTo(a);
        });

        setTree.add(10);
        setTree.add(-1);
        setTree.add(101);
        setTree.add(12);
        setTree.add(0);
        setTree.add(-10);

        System.out.println(setTree);

        System.out.println("Min is " + setTree.first());
        System.out.println("Max is " + setTree.last());


    }
}
