package com.mtvhere.java.linkedlist;

public class MergeTwoSortedLists {
    public static void main(String[] args) {
        MergeTwoSortedLists solution = new MergeTwoSortedLists();

        ListNode l1 = new ListNode(3);
        // l1.next = new ListNode(2);
        // l1.next.next = new ListNode(4);

        ListNode l2 = new ListNode(1);
        //l2.next = new ListNode(3);
        l2.next = new ListNode(4);

        ListNode output = solution.mergeTwoLists(l1, l2);

        while (output != null) {
            System.out.print(output.val + "->");
            output = output.next;
        }

    }


    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        } else if (l1.val < l2.val) {
            l1.next = this.mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = this.mergeTwoLists(l1, l2.next);
            return l2;
        }

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
