package com.mtvhere.java.linkedlist;

public class EmployeeList {

    public EmployeeNode getHead() {
        return this.head;
    }

    public EmployeeNode getTail() {
        return this.tail;
    }

    private EmployeeNode head;
    private EmployeeNode tail;
    private int size;

    public void addToFront(final Employee employee) {
        final EmployeeNode node = new EmployeeNode(employee);
        node.setNext(this.head);


        if (null != this.head && this.tail == null) {
            //tail should be point to head only for first item when head is not null
            this.tail = this.head;
        }
        if (null == this.head) {
            //if head is null then tail should point to current node
            this.tail = node;
        }

        this.head = node;
        if (null != node.getNext()) {
            node.getNext().setPrev(node);
        }
        this.size++;
    }

    public EmployeeNode removeFromFront() {
        final EmployeeNode node = this.head;
        this.head = this.head.getNext();
        this.size--;
        node.setNext(null);
        return node;
    }

    public int getSize() {
        return this.size;
    }

    public boolean isEmpty() {
        return this.head == null;
    }


    public void printList() {
        System.out.print("head -> ");
        EmployeeNode current = this.head;
        while (current != null) {
            System.out.print(current);
            System.out.print(" -> ");
            current = current.getNext();
        }


        System.out.println("end");
    }


    public void reversePrint() {
        System.out.print("tail -> ");
        EmployeeNode current = this.tail;
        while (current != null) {
            System.out.print(current);
            System.out.print(" -> ");
            current = current.getPrev();
        }
        System.out.println("head");
    }
}
