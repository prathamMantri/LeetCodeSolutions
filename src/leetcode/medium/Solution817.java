package leetcode.medium;

import model.ListNode;

import java.util.HashSet;
import java.util.Set;

public class Solution817 {
    public int numComponents(ListNode head, int[] G) {

        int count = 0;

        if (G.length == 1) {
            return 1;
        }

        Set<Integer> set = new HashSet<>();
        for (int i : G) {
            set.add(i);
        }
        while (head != null) {
            if (set.contains(head.val) && (head.next == null || !set.contains(head.next.val)))
                count++;
            head = head.next;
        }

        return count;
    }
}
