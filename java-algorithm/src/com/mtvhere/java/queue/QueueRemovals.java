package com.mtvhere.java.queue;

import java.util.LinkedList;
import java.util.Queue;

public class QueueRemovals {
    // Add any helper functions you may need here

    static class Node {
        int value;
        int index;

        public Node(final int item, final int index) {
            this.value = item;
            this.index = index;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "value=" + this.value +
                    ", index=" + this.index +
                    '}';
        }
    }

    static int[] findPositions(final int[] arr, int x) {
        // Write your code here
        final int[] retArr = new int[x];
        int itemsPop = x;
        int arrKey = 0;
        final Queue<Node> queue = new LinkedList<>();

        for (int i = 0; i < arr.length; i++) {
            queue.add(new Node(arr[i], i + 1));
        }

        //System.out.println(queue);
        do {
            boolean added = false;
            if (itemsPop > queue.size()) {
                itemsPop = queue.size();
            }
            // System.out.println("x is " + x + " itemsPop " + itemsPop);
            int max = Integer.MIN_VALUE;
            final Queue<Node> tmpQueue = new LinkedList<>();
            for (int i = 0; i < itemsPop; i++) {
                final Node item = queue.poll();

                if (item.value >= max) {
                    max = item.value;
                }
                tmpQueue.add(item);
            }
            while (tmpQueue.size() != 0) {
                final Node item = tmpQueue.poll();
                if (item.value == max && !added) {

                    //System.out.println("\tMax is " + max + " index " + item.index);

                    retArr[arrKey++] = item.index;
                    added = true;
                } else {
                    if (item.value > 0) {
                        item.value = item.value - 1;
                    }
                    queue.add(item);
                }
            }

            x--;

        } while (x > 0);

        return retArr;
    }


    // These are the tests we use to determine if the solution is correct.
    // You can add your own at the bottom, but they are otherwise not editable!
    int test_case_number = 1;

    void check(final int[] expected, final int[] output) {
        final int expected_size = expected.length;
        final int output_size = output.length;
        boolean result = true;
        if (expected_size != output_size) {
            result = false;
        }
        for (int i = 0; i < Math.min(expected_size, output_size); i++) {
            result &= (output[i] == expected[i]);
        }
        final char rightTick = '\u2713';
        final char wrongTick = '\u2717';
        if (result) {
            System.out.println(rightTick + " Test #" + this.test_case_number);
        } else {
            System.out.print(wrongTick + " Test #" + this.test_case_number + ": Expected ");
            QueueRemovals.printIntegerArray(expected);
            System.out.print(" Your output: ");
            QueueRemovals.printIntegerArray(output);
            System.out.println();
        }
        this.test_case_number++;
    }

    static void printIntegerArray(final int[] arr) {
        final int len = arr.length;
        System.out.print("[");
        for (int i = 0; i < len; i++) {
            if (i != 0) {
                System.out.print(", ");
            }
            System.out.print(arr[i]);
        }
        System.out.print("]");
    }

    public void run() {
        final int n_1 = 6;
        final int x_1 = 5;
        final int[] arr_1 = {1, 2, 2, 3, 4, 5};
        final int[] expected_1 = {5, 6, 4, 1, 2};
        final int[] output_1 = QueueRemovals.findPositions(arr_1, x_1);
        this.check(expected_1, output_1);

        final int n_2 = 13;
        final int x_2 = 4;
        final int[] arr_2 = {2, 4, 2, 4, 3, 1, 2, 2, 3, 4, 3, 4, 4};
        final int[] expected_2 = {2, 5, 10, 13};
        final int[] output_2 = QueueRemovals.findPositions(arr_2, x_2);
        this.check(expected_2, output_2);

        // Add your own test cases here

    }

    public static void main(final String[] args) {
        new QueueRemovals().run();
    }
}
