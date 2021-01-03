package com.mtvhere.java.collection;

import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;

public class CollectionsExample {


    public static void main(final String[] args) {

        final List<Integer> numbers = Arrays.asList(1, 2, 3, 2, 2, 2, 3, 2, 2, 3, 2, 2, 4, 2, 0, 1, 3, 4, 3, 22);
        //System.out.println(Collections.binarySearch(numbers, 0));

        //numbers.forEach(num -> System.out.println(num));

        //numbers.add(1);

        final ListIterator<Integer> numItr = numbers.listIterator();

      
        while (numItr.hasNext()) {

            final Integer next = numItr.hasNext() ? numItr.next() : null;

            //System.out.println("value is : " + next + ", prev index:" + numItr.previousIndex() + ", next index:" + numItr.nextIndex());
        }


    }
}
