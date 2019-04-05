package leetCode.easy;

import model.ListNode;

public class Solution21{

    /*
    Merge two sorted linked lists and return it as a new list.
    The new list should be made by splicing together the nodes of the first two lists.

    Example:

    Input: 1->2->4, 1->3->4
    Output: 1->1->2->3->4->4
    */

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        //Recursive Approach

        /*if(l1==null){
            return l2;
        }
        if(l2==null){
            return l1;
        }

        if(l1.data<l2.data){
            l1.next =  mergeTwoLists(l1.next,l2);
            return l1;
        }else{
            l2.next= mergeTwoLists(l1, l2.next);
            return l2;
        }*/

        ListNode curr = l1 ;

        while(l1 !=null && l2!=null){

            if(l1 == null){
                curr.next = l2;
                break;
            }
            if(l2== null){
                curr.next = l1;
                break;
            }

            if(l1.data<=l2.data){
                curr.next = l1;
                l1=l1.next;
            }else{
                curr.next = l2;
                l2=l2.next;
            }

            curr = curr.next;
        }
        return curr;
    }
}
