package geeksForGeeks;

import java.util.Scanner;

/**
 * Nth node from end of linked list
 * Given a linked list of length L. The task is to find the Nth node from the end of the linked list.  It is needed to complete a method that takes two argument, head of linked list and an integer N. There are multiple test cases. For each test case, this method will be called individually.
 * <p>
 * Input:
 * First line of input contains number of testcase T. For each testcase, first line of input contains number of nodes in the linked list and N. Next line contains nodes of linked list.
 * <p>
 * Output:
 * For each testcase, output the data of node which is at Nth distance from end.
 * <p>
 * User Task:
 * The task is to complete the function getNthFromLast() which two arguments reference to head and N for which Nth from end is to be returned.
 * <p>
 * Constraints:
 * 1 <= T <= 200
 * 1 <= L <= 103
 * 1 <= N <= 103
 * <p>
 * Example:
 * Input:
 * 2
 * 9 2
 * 1 2 3 4 5 6 7 8 9
 * 4 5
 * 10 5 100 5 1
 * <p>
 * Output:
 * 8
 * -1
 * <p>
 * Explanation:
 * Testcase 1: In the first example, there are 9 nodes in linked list and we need to find 2nd node from end.  2nd node from end os 8.
 * Testcase 2: In the second example, there are 4 nodes in linked list and we need to find 5th from end.  Since 'n' is more than number of nodes in linked list, output is -1.
 ****/

class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}


public class LinkedList_Element_From_Last {
    Node head;

    /* Function to print linked list */
    void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }


    /* Inserts a new Node at front of the list. */
    public void addToTheLast(Node node) {
        if (head == null) {
            head = node;
        } else {
            Node temp = head;
            while (temp.next != null)
                temp = temp.next;
            temp.next = node;
        }
    }

    /* Drier program to test above functions */
    public static void main(String args[]) {


        /* Constructed Linked List is 1->2->3->4->5->6->
           7->8->8->9->null */
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            LinkedList_Element_From_Last llist = new LinkedList_Element_From_Last();
            //int n=Integer.parseInt(br.readLine());
            int a1 = sc.nextInt();
            Node head = new Node(a1);
            llist.addToTheLast(head);
            for (int i = 1; i < n; i++) {
                int a = sc.nextInt();
                llist.addToTheLast(new Node(a));
            }

            //System.out.println(llist.head.data);
            GfG g = new GfG();
            //System.out.println(k);
            System.out.println(g.getNthFromLast(llist.head, k));

            t--;
        }
    }


   public static class GfG {
        int getNthFromLast(Node head, int n) {
            if (head == null) {
                return -1;
            }

            Node runner1 = head;
            Node runner2 = head;
            int count = 0;


            for (int i = 0; i < n; i++) {
                if(runner1==null){
                    return -1;
                }
                runner1 = runner1.next;
            }

            while (runner1 != null){
                runner2 = runner2.next;
                runner1 = runner1.next;
            }
            return runner2.data;

        }
    }
}
