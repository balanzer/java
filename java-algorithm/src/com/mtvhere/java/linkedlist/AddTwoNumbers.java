package com.mtvhere.java.linkedlist;

public class AddTwoNumbers {

    public static void main(final String[] args) {
        final AddTwoNumbers nums = new AddTwoNumbers();

        ListNode l1 = new ListNode(1, null);
        l1.next = new ListNode(2, null);
        l1.next.next = new ListNode(15);


        ListNode l2 = new ListNode(3, null);
        l2.next = new ListNode(4, null);
        l2.next.next = new ListNode(6);


        ListNode output = nums.addTwoNumbers(l1, l2);
        while (output != null) {
            System.out.print(output.val + " -> ");
            output = output.next;
        }
    }

    public int getNumbers(ListNode l1) {
        int input = 0;

        while (l1 != null) {
            if (input == 0) {
                input = l1.val;
            } else {
                input = input * 10;
                input = input + l1.val;
            }
            l1 = l1.next;
        }
        System.out.println("Input number is " + input);
        return input;
    }


    public ListNode addTwoNumbers(final ListNode l1, final ListNode l2) {

        int num1 = this.getNumbers(l1);
        final int num2 = this.getNumbers(l2);

        num1 = num1 + num2;


        ListNode result = null;
        ListNode head = null;
        while (num1 > 0) {
            final int resNum = num1 % 10;
            num1 = num1 / 10;
            if (result == null) {
                result = new ListNode(resNum);
                head = result;
            } else {
                while (result.next != null) {
                    result = result.next;
                }
                result.next = new ListNode(resNum);
            }
            //System.out.println("Result : " + result);
        }
        System.out.println("Final Result : " + head);
        return head;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(final int val) {
            this.val = val;
        }

        ListNode(final int val, final ListNode next) {
            this.val = val;
            this.next = next;
        }

        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + this.val +
                    ", next=" + this.next +
                    '}';
        }
    }
}
