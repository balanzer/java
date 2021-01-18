package com.mtvhere.java.tree;

import java.io.IOException;
import java.util.*;

public class NodesinaSubtree {

    // Tree Node
    class Node {
        public int val;
        public List<Node> children;

        public Node() {
            this.val = 0;
            this.children = new ArrayList<>();
        }

        public Node(final int _val) {
            this.val = _val;
            this.children = new ArrayList<Node>();
        }

        public Node(final int _val, final ArrayList<Node> _children) {
            this.val = _val;
            this.children = _children;
        }
    }

    class Query {
        int u;
        char c;

        Query(final int u, final char c) {
            this.u = u;
            this.c = c;
        }
    }

    // Add any helper functions you may need here

    void nodesToCheck(final List<Node> nodes, final Queue<Integer> posQueue, final int val) {

        if (null == nodes || nodes.isEmpty()) {
            return;
        }

        for (final Node node : nodes) {
            if (node.val >= val) {
                posQueue.add(node.val);
            }
            this.nodesToCheck(node.children, posQueue, val);

        }

    }

    int[] countOfNodes(final Node root, final ArrayList<Query> queries, final String s) {
        // Write your code here
        final int[] output = new int[queries.size()];
        int key = 0;


        for (final Query q : queries) {
            System.out.println("Checking queries q.c " + q.c + ", from root val " + q.u + "  with String " + s);
            final Queue<Integer> posQueue = new LinkedList<>();
            final Node node = root;

            if (node.val >= q.u) {
                posQueue.add(node.val);
            }
            this.nodesToCheck(node.children, posQueue, q.u);

            System.out.println("position to check in string " + posQueue);
            int totalCount = 0;
            while (posQueue.size() > 0) {
                Integer index = posQueue.poll();
                index = index - 1;//adjust to string pos

                if (q.c == s.charAt(index)) {
                    totalCount++;
                }
            }

            output[key++] = totalCount;
        }

        return output;
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
            NodesinaSubtree.printIntegerArray(expected);
            System.out.print(" Your output: ");
            NodesinaSubtree.printIntegerArray(output);
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

    public void run() throws IOException {
        final Scanner sc = new Scanner(System.in);

        //Testcase 1
        final int n_1 = 3;
        final int q_1 = 1;
        final String s_1 = "aba";
        final Node root_1 = new Node(1);
        root_1.children.add(new Node(2));
        root_1.children.add(new Node(3));
        final ArrayList<Query> queries_1 = new ArrayList<>();
        queries_1.add(new Query(1, 'a'));
        final int[] output_1 = this.countOfNodes(root_1, queries_1, s_1);
        final int[] expected_1 = {2};
        this.check(expected_1, output_1);

        // Testcase 2
        final int n_2 = 7;
        final int q_2 = 3;
        final String s_2 = "abaacab";
        final Node root_2 = new Node(1);
        root_2.children.add(new Node(2));
        root_2.children.add(new Node(3));
        root_2.children.add(new Node(7));
        root_2.children.get(0).children.add(new Node(4));
        root_2.children.get(0).children.add(new Node(5));
        root_2.children.get(1).children.add(new Node(6));
        final ArrayList<Query> queries_2 = new ArrayList<>();
        queries_2.add(new Query(1, 'a'));
        queries_2.add(new Query(2, 'b'));
        queries_2.add(new Query(3, 'a'));
        final int[] output_2 = this.countOfNodes(root_2, queries_2, s_2);
        final int[] expected_2 = {4, 1, 2};
        this.check(expected_2, output_2);

        // Add your own test cases here

    }

    public static void main(final String[] args) throws IOException {
        new NodesinaSubtree().run();
    }
}
