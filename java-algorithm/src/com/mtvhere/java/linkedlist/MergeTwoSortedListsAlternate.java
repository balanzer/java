package com.mtvhere.java.linkedlist;

public class MergeTwoSortedListsAlternate {
    public static void main(String[] args) {
        MergeTwoSortedListsAlternate solution = new MergeTwoSortedListsAlternate();

        ListNode l1 = new ListNode(3);
        l1.next = new ListNode(7);
        l1.next.next = new ListNode(11);
        l1.next.next.next = new ListNode(53);
        l1.next.next.next.next = new ListNode(99);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next = new ListNode(41);

        ListNode output = solution.mergeTwoLists(l1, l2);

        while (output != null) {
            System.out.print(output.val + "->");
            output = output.next;
        }

    }


    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        ListNode out = null;
        ListNode pointer = null;

        while ((l1 != null || l2 != null)) {
            if (l1 != null & l2 != null) {
                // System.out.println("l1 is " + l1.val + " l2 is " + l2.val);
                if (l1.val < l2.val) {
                    out = this.createNode(out, l1.val);
                    l1 = l1.next;
                } else {
                    out = this.createNode(out, l2.val);
                    l2 = l2.next;
                }
            } else if (l1 != null) {
                //  System.out.println("l1 is " + l1.val);
                out = this.createNode(out, l1.val);
                l1 = l1.next;
            } else if (l2 != null) {
                //  System.out.println("l2 is " + l2.val);
                out = this.createNode(out, l2.val);
                l2 = l2.next;
            }
            if (pointer == null) {
                pointer = out;
            }
        }

        //  System.out.println(out);
        return pointer;
    }

    private ListNode createNode(ListNode out, int val) {
        //System.out.println("creating node " + val);
        if (out == null) {
            out = new ListNode(val);
        } else {
            out.next = new ListNode(val);
            out = out.next;
        }
        return out;
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
