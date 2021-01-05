package com.mtvhere.java.collection;

import java.util.Iterator;
import java.util.LinkedList;

public class LinkedListExample {
    public static void main(final String[] args) {
        final LinkedList<Integer> numbersList = new LinkedList();

        
        numbersList.add(10);
        numbersList.add(30);
        numbersList.addFirst(0);
        numbersList.addLast(1);
        numbersList.add(2);
        numbersList.add(4);

        System.out.println(numbersList);

        final Iterator<Integer> itr = numbersList.descendingIterator();

        while (itr.hasNext()) {
            System.out.println("Item : " + itr.next());
        }
    }
}
