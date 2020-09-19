package interview_questions_facebook;

import model.ListNode;

public class ReverseOperations {
    public static void main(String[] args) {
        int[] arr_1 = {1, 2, 8, 9, 12, 16};
        int[] expected1 = {1, 8, 2, 9, 16, 12};
        ReverseOperations ro = new ReverseOperations();
        ListNode head_1 = ro.createLinkedList(arr_1);
        ListNode expected_1 = ro.createLinkedList(expected1);
        ro.printLinkedList(head_1);

        ListNode output_1 = ro.reverse(head_1);

        ro.printLinkedList(head_1);
    }

    /***
     *
     *
     *
     * You are given a singly-linked list that contains N integers. A subpart of the list is a contiguous set of even elements, bordered either by the end of the list or an odd element. For example, if the list is [1, 2, 8, 9, 12, 16], the subparts of the list are [2, 8] and [12, 16].
     * Then, for each subpart, the order of the elements is reversed. In the example, this would result in the new list, [1, 8, 2, 9, 16, 12].
     * The goal of this question is: given a resulting list, determine the original order of the elements.
     * Implementation detail:
     * You must use the following definition for elements in the linked list:
     * class Node {
     *     int data;
     *     Node next;
     * }
     * Signature
     * Node reverse(Node head)
     * Constraints
     * 1 <= N <= 1000, where N is the size of the list
     * 1 <= Li <= 10^9, where Li is the ith element of the list
     * Example
     * Input:
     * N = 6
     * list = [1, 2, 8, 9, 12, 16]
     * Output:
     * [1, 8, 2, 9, 16, 12]
     *
     *
     */


    ListNode reverseSubList(ListNode head, ListNode prev) {

        if (head == null) {
            return null;
        }

        ListNode next;
        ListNode curr = head;
        while (curr.next != null && curr.val % 2 == 0) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        if (curr != null) {
            curr = head.next;
            curr = reverseSubList(curr, null);
            return prev;
        } else {
            head.next = reverseSubList(head.next, head);
            return head;
        }
    }

    ListNode reverse(ListNode head) {

        if (head == null || head.next == null) {
            return null;
        }

        return reverseSubList(head, null);


    }

    ListNode createLinkedList(int[] arr) {
        ListNode head = null;
        ListNode tempHead = head;
        for (int v : arr) {
            if (head == null) {
                head = new ListNode(v);
                tempHead = head;
            } else {
                head.next = new ListNode(v);
                head = head.next;
            }
        }
        return tempHead;
    }

    void printLinkedList(ListNode head) {
        System.out.print("[");
        while (head != null) {
            System.out.print(head.val);
            head = head.next;
            if (head != null)
                System.out.print(" ");
        }
        System.out.print("]");
    }


}
