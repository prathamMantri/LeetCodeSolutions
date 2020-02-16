package recursion;

import model.ListNode;

public class ReverseLinkedList {
    public static void main(String[] args) {

        ReverseLinkedList rev = new ReverseLinkedList();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        System.out.println(rev.reverseList(head));


    }

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode start = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return start;

    }

}
