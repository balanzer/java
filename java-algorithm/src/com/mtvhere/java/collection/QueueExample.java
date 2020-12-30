package com.mtvhere.java.collection;

import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.IntStream;

public class QueueExample {

    public static void main(final String[] args) {
        final Queue<Integer> queue = new LinkedList<>();
        IntStream.range(20, 40).forEach(num -> queue.add(num));

        while (!queue.isEmpty()) {
            queue.poll();
            System.out.println(queue);
        }

    }
}
