package com.mtvhere.java.heap;

import java.util.PriorityQueue;
import java.util.Queue;

public class PriorityQueueExample {
    public static void main(final String[] args) {
        final PriorityQueue<Integer> pq = new PriorityQueue<Integer>((a, b) -> {
            return b.compareTo(a);
        });

        pq.add(12);
        pq.add(-1);
        pq.add(0);
        pq.add(9);
        pq.add(15);
        pq.add(-2);

        System.out.println("Queue" + pq);

        pq.stream().forEach(item -> System.out.print(item + ", "));
        System.out.println();

        testStringsNaturalOrdering();

    }


    private static void testStringsNaturalOrdering() {
        final Queue<String> testStringsPQ = new PriorityQueue<>();
        testStringsPQ.add("abcd");
        testStringsPQ.add("1234");
        testStringsPQ.add("23bc");
        testStringsPQ.add("zzxx");
        testStringsPQ.add("abxy");

        System.out.println("Strings Stored in Natural Ordering in a Priority Queue\n");
        while (!testStringsPQ.isEmpty()) {
            System.out.println(testStringsPQ.poll());
        }
    }
}
