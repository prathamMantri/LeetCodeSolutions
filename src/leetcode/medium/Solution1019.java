package leetcode.medium;

import model.ListNode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Solution1019 {
    public static void main(String[] args) {
        ListNode head = new ListNode(2);
        head.next = new ListNode(1);
        head.next.next = new ListNode(5);
        Solution1019 sol = new Solution1019();
        sol.nextLargerNodes(head);
    }

    public int[] nextLargerNodes(ListNode head) {
        if (head == null) {
            int[] res = new int[0];
            return res;
        }

        Stack<Integer> st = new Stack<>();
        ListNode curr = head;
        Map<Integer, Integer> map = new HashMap<>();
        st.push(curr.data);
        curr = curr.next;

        while (curr != null) {
            int val = curr.data;
            if (val < st.peek()) {
                st.push(val);
            } else {
                while (!st.isEmpty()) {
                    map.put(st.pop(), val);
                }
                st.push(val);
            }
            curr = curr.next;
        }

        while (!st.isEmpty()) {
            map.put(st.pop(), 0);
        }
        int[] res = new int[map.size()];

        int i = 0;

        while (head != null) {

            res[i] = map.get(head.data);
            head = head.next;
            i++;

        }

        return res;

    }

}
