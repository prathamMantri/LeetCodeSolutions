package recursion;

import model.ListNode;

public class SwapListNodes {

    public static void main(String[] args) {

        SwapListNodes swap = new SwapListNodes();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        System.out.println(swap.swapPairs(head));


    }

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode temp = head;
        head = temp.next;
        temp.next = head.next;
        head.next = temp;
        temp.next = swapPairs(head.next.next);

        return head;
    }

}
