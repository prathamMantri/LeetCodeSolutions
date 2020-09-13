package leetcode.medium;

import model.ListNode;

public class Solution82 {
    public ListNode deleteDuplicates(ListNode head) {

        // SOlution from @jinwu
        // https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/discuss/28364/Java-simple-and-clean-code-with-comment


        //use two pointers, slow - track the node before the dup nodes,
        // fast - to find the last node of dups.

        /*
        slow = dummy
        fast = head
        dummy.next  = fast
        start with the fast.... and slow is alredy pointing to fast.

        while fast does not reach end loop it.
            in the loop, until fast reaches next and fast's value is equal to fast's next's val.. keep going ahead
            //here we are going through the duplicates.
                make fast = fast'snext
                get out of loop if any of the above condition meets

            check if slow.next is fast (considering there is no duplicates) if not,
                makes, slow.next = current fast's next ..... here we just removed previous duplicates
                now, assign slow's next to fast to start the inside loop again.
            if no duplicates found
                make slow.next to fast and reposition
                fast to fast.next.

            return dummy.next;
           and you are done.
         */


        ListNode dummy = new ListNode(0), fast = head, slow = dummy;
        slow.next = fast;
        while (fast != null) {
            while (fast.next != null && fast.val == fast.next.val) {
                fast = fast.next;    //while loop to find the last node of the dups.
            }
            if (slow.next != fast) { //duplicates detected.
                slow.next = fast.next; //remove the dups.
                fast = slow.next;     //reposition the fast pointer.
            } else { //no dup, move down both pointer.
                slow = slow.next;
                fast = fast.next;
            }
        }
        return dummy.next;
    }
}
