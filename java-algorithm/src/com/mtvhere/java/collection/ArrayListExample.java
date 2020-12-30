package com.mtvhere.java.collection;

import java.util.ArrayList;
import java.util.ListIterator;

public class ArrayListExample {
    public static void main(final String[] args) {

        final ArrayList<Integer> numbers = new ArrayList<Integer>();

        numbers.add(1);
        numbers.add(2);

        numbers.add(0, 12);
        numbers.add(10);
        numbers.add(10);
        //System.out.println(numbers);


        final ListIterator<Integer> itr = numbers.listIterator(numbers.size());

        while (itr.hasPrevious()) {
            System.out.println("Number : " + itr.previous() + " prev index : " + itr.previousIndex());
        }

    }


}
