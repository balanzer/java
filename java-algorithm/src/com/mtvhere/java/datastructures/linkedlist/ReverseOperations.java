package com.mtvhere.java.datastructures.linkedlist;

import java.util.Stack;

public class ReverseOperations {

    class Node {
        int data;
        Node next;

        Node(final int x) {
            this.data = x;
            this.next = null;
        }
    }

    // Add any helper functions you may need here


    Node reverse(Node head) {

        Node entryNode = null;
        Node entryHead = null;
        final Stack<Integer> stack = new Stack<>();

        do {
            if (head.data % 2 == 0 || head.next == null) {
                stack.push(head.data);
                // System.out.println(head.data);
            } else {

                //System.out.println("For item " + head.data);

                if (entryNode == null && stack.size() == 0) {
                    entryNode = new Node(head.data);
                    entryHead = entryNode;
                } else {
                    //  System.out.println("Total Values in Stack " + stack);


                    while (stack.size() > 0) {
                        final Integer lastItem = stack.pop();
                        // System.out.println("Insert item " + lastItem);

                        if (entryNode == null) {
                            entryNode = new Node(lastItem);
                            entryHead = entryNode;
                        } else {
                            entryNode.next = new Node(lastItem);
                            entryNode = entryNode.next;
                        }


                    }

                    entryNode.next = new Node(head.data);
                    entryNode = entryNode.next;
                }


            }

            head = head.next;
        } while (head != null);

        // System.out.println("Total Values in Stack " + stack);
        while (stack.size() > 0) {
            final Integer lastItem = stack.pop();
            // System.out.println("Insert item " + lastItem);
            entryNode.next = new Node(lastItem);
            entryNode = entryNode.next;
        }
        return entryHead;
    }


    // These are the tests we use to determine if the solution is correct.
    // You can add your own at the bottom, but they are otherwise not editable!
    int test_case_number = 1;

    void printLinkedList(Node head) {
        System.out.print("[");
        while (head != null) {
            System.out.print(head.data);
            head = head.next;
            if (head != null) {
                System.out.print(" ");
            }
        }
        System.out.print("]");
    }

    void check(Node expectedHead, Node outputHead) {
        boolean result = true;
        final Node tempExpectedHead = expectedHead;
        final Node tempOutputHead = outputHead;
        while (expectedHead != null && outputHead != null) {
            result &= (expectedHead.data == outputHead.data);
            expectedHead = expectedHead.next;
            outputHead = outputHead.next;
        }
        if (!(expectedHead == null && outputHead == null)) {
            result = false;
        }

        final char rightTick = '\u2713';
        final char wrongTick = '\u2717';
        if (result) {
            System.out.println(rightTick + " Test #" + this.test_case_number);
        } else {
            System.out.print(wrongTick + " Test #" + this.test_case_number + ": Expected ");
            this.printLinkedList(tempExpectedHead);
            System.out.print(" Your output: ");
            this.printLinkedList(tempOutputHead);
            System.out.println();
        }
        this.test_case_number++;
    }

    Node createLinkedList(final int[] arr) {
        Node head = null;
        Node tempHead = head;
        for (final int v : arr) {
            if (head == null) {
                head = new Node(v);
                tempHead = head;
            } else {
                head.next = new Node(v);
                head = head.next;
            }
        }
        return tempHead;
    }

    public void run() {

        final int[] arr_1 = {1, 2, 8, 9, 12, 16};
        final int[] expected1 = {1, 8, 2, 9, 16, 12};
        final Node head_1 = this.createLinkedList(arr_1);
        final Node expected_1 = this.createLinkedList(expected1);
        final Node output_1 = this.reverse(head_1);
        this.check(expected_1, output_1);

        final int[] arr_2 = {2, 18, 24, 3, 5, 7, 9, 6, 12};
        final int[] expected2 = {24, 18, 2, 3, 5, 7, 9, 12, 6};
        final Node head_2 = this.createLinkedList(arr_2);
        final Node expected_2 = this.createLinkedList(expected2);
        final Node output_2 = this.reverse(head_2);
        this.check(expected_2, output_2);

        // Add your own test cases here

    }

    public static void main(final String[] args) {
        new ReverseOperations().run();
    }
}
