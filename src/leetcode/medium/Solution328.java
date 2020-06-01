package leetcode.medium;

import model.ListNode;

public class Solution328 {
    public static void main(String[] args) {
        int[] arr_1 = {1, 2, 8, 9, 12, 16};
        Solution328 ro = new Solution328();
        ListNode head_1 = ro.createLinkedList(arr_1);
        ro.printLinkedList(head_1);

        ListNode output_1 = ro.oddEvenList(head_1);

        ro.printLinkedList(head_1);
    }

    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode oddCurr = head;
        ListNode evenCurr = head.next;
        ListNode evenHead = evenCurr;

        while (oddCurr.next != null) {
            oddCurr.next = oddCurr.next.next;
            if (oddCurr.next != null) {
                oddCurr = oddCurr.next;
            }
        }
        while (evenCurr.next != null) {
            evenCurr.next = evenCurr.next.next;
            if (evenCurr.next != null) {
                evenCurr = evenCurr.next;
            }
        }
        oddCurr.next = evenHead;

        return head;
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
            System.out.print(head.data);
            head = head.next;
            if (head != null)
                System.out.print(" ");
        }
        System.out.print("]");
    }
}
