package monthlyChallange;

import model.ListNode;

public class MiddleOfLinkedList {
    public static void main(String[] args) {
        MiddleOfLinkedList sol = new MiddleOfLinkedList();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        System.out.println(sol.middleNode(head).val);
    }

    public ListNode middleNode(ListNode head) {

        ListNode temp = head;
        ListNode middleNode = head;
        int count = 0;

        if (head == null || head.next == null) {
            return head;
        }

        while (temp.next != null) {
            temp = temp.next;
            count++;
        }

        int middle = count % 2 != 0 ? (count / 2) + 1 : count / 2;

        while (middle != 0) {
            middleNode = middleNode.next;
            middle--;
        }
        return middleNode;
    }

}
