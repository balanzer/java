package com.mtvhere.java.tree;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeTravel {

    Node root;

    /* Given a binary tree. Print
     its nodes in level order
     using array for implementing queue  */
    void printLevelOrder() {
        final Queue<Node> queue = new LinkedList<>();
        queue.add(this.root);
        while (!queue.isEmpty()) {

            final Node tempNode = queue.poll();
            System.out.print(tempNode.data + " ");

            /*Enqueue left child */
            if (tempNode.left != null) {
                queue.add(tempNode.left);
            }

            /*Enqueue right child */
            if (tempNode.right != null) {
                queue.add(tempNode.right);
            }

            System.out.print("\n");
        }
    }

    static void printLevelOrder(final Node root) {
        // Base Case
        if (root == null) {
            return;
        }

        // Create an empty queue for level order tarversal
        final Queue<Node> q = new LinkedList<Node>();

        // Enqueue Root and initialize height
        q.add(root);


        while (true) {

            // nodeCount (queue size) indicates number of nodes
            // at current level.
            int nodeCount = q.size();
            if (nodeCount == 0) {
                break;
            }

            // Dequeue all nodes of current level and Enqueue all
            // nodes of next level
            while (nodeCount > 0) {
                final Node node = q.peek();
                System.out.print(node.data + " ");
                q.remove();
                if (node.left != null) {
                    q.add(node.left);
                }
                if (node.right != null) {
                    q.add(node.right);
                }
                nodeCount--;
            }
            System.out.println();
        }
    }

    public static void main(final String[] args) {
        /* creating a binary tree and entering
         the nodes */
        final BinaryTreeTravel tree_level = new BinaryTreeTravel();
        tree_level.root = new Node(1);
        tree_level.root.left = new Node(2);
        tree_level.root.right = new Node(3);
        tree_level.root.left.left = new Node(4);
        tree_level.root.left.right = new Node(5);

        // System.out.println("Level order traversal of binary tree is - ");
        //tree_level.printLevelOrder();
        printLevelOrder(tree_level.root);
    }

}
