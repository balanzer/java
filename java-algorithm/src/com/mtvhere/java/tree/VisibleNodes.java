package com.mtvhere.java.tree;

public class VisibleNodes {
    Node root;
    static int count;

    public static void main(final String[] args) {
        final VisibleNodes tree = new VisibleNodes();

        tree.root = new Node(5);
        tree.root.left = new Node(3);
        tree.root.right = new Node(10);

        tree.root.left.left = new Node(20);
        tree.root.left.right = new Node(21);

        tree.root.right.left = new Node(1);


        count = 0;
        preOrder(tree.root, Integer.MIN_VALUE);

        System.out.println("Visible Nodes : " + count);
    }

    // Function to perform the preorder traversal
    // for the given tree
    static void preOrder(final Node node, int max) {

        // Base case
        if (node == null) {
            return;
        }

        // If the current node value is greater
        // or equal to the max value,
        // then update count variable
        // and also update max variable
        //System.out.println("Node data : " + node.data + ", max : " + max + ", count : " + count);
        if (node.data >= max) {
            count++;
            max = Math.max(node.data, max);
            System.out.println("Visible Node data : " + node.data + ", max : " + max + ", count : " + count);
        } else {
            System.out.println("Non Visible Node data : " + node.data);
        }


        // Traverse to the left
        preOrder(node.left, max);

        // Traverse to the right
        preOrder(node.right, max);
    }
}

class Node {
    int data;
    Node left, right;

    // Constructor of the class
    public Node(final int item) {
        this.data = item;
        this.left = this.right = null;
    }
}