package com.mtvhere.java.tree;

import java.io.IOException;

public class VisibleNodes2 {
    class Node {
        int data;
        Node left;
        Node right;

        Node() {
            this.data = 0;
            this.left = null;
            this.right = null;
        }

        Node(final int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    // Add any helper functions you may need here

    int visible(final Node node, int max) {

        if (node == null) {
            // return count;
            return 0;
        }
        int num = 0;
        if (node.data >= max) {
            max = node.data;
            num = 1;
        }

        return num + this.visible(node.left, max) + this.visible(node.right, max);

    }

    int visibleNodes(final Node root) {
        // Write your code here
        return this.visible(root, Integer.MIN_VALUE);

    }


    // These are the tests we use to determine if the solution is correct.
    // You can add your own at the bottom, but they are otherwise not editable!
    int test_case_number = 1;

    void check(final int expected, final int output) {
        final boolean result = (expected == output);
        final char rightTick = '\u2713';
        final char wrongTick = '\u2717';
        if (result) {
            System.out.println(rightTick + " Test #" + this.test_case_number);
        } else {
            System.out.print(wrongTick + " Test #" + this.test_case_number + ": Expected ");
            VisibleNodes2.printInteger(expected);
            System.out.print(" Your output: ");
            VisibleNodes2.printInteger(output);
            System.out.println();
        }
        this.test_case_number++;
    }

    static void printInteger(final int n) {
        System.out.print("[" + n + "]");
    }

    public void run() throws IOException {

        final Node root_1 = new Node(8);
        root_1.left = new Node(3);
        root_1.right = new Node(10);
        root_1.left.left = new Node(1);
        root_1.left.right = new Node(6);
        root_1.right.right = new Node(14);
        root_1.left.right.left = new Node(4);
        root_1.left.right.right = new Node(7);
        root_1.right.right.left = new Node(13);
        final int expected_1 = 4;
        final int output_1 = this.visibleNodes(root_1);
        this.check(expected_1, output_1);

        final Node root_2 = new Node(10);
        root_2.left = new Node(8);
        root_2.right = new Node(15);
        root_2.left.left = new Node(4);
        root_2.left.left.right = new Node(5);
        root_2.left.left.right.right = new Node(6);
        root_2.right.left = new Node(14);
        root_2.right.right = new Node(16);

        final int expected_2 = 5;
        final int output_2 = this.visibleNodes(root_2);
        this.check(expected_2, output_2);

        // Add your own test cases here

    }

    public static void main(final String[] args) throws IOException {
        new VisibleNodes2().run();
    }
}
