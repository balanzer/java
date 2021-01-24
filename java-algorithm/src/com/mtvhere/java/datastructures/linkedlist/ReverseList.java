package com.mtvhere.java.datastructures.linkedlist;

public class ReverseList {
    public static void main(String[] args) {

        ReverseList solution = new ReverseList();
        ListNode input = new ListNode(1);
        input.next = new ListNode(2);
        input.next.next = new ListNode(3);
        input.next.next.next = new ListNode(4);
        input.next.next.next.next = new ListNode(5);

        ListNode output = solution.reverseList(input);

        while (output != null) {
            System.out.print(output.val + "->");
            output = output.next;
        }
        System.out.print("null");
        System.out.println();
    }

    public ListNode reverseList(ListNode head) {
        ListNode previous = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = previous;
            previous = head;

            head = next;
        }
        return previous;
    }


    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
