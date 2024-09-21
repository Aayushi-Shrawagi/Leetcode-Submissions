/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        if(head==null||head.next==null) return null;
        ListNode slow=head,fast=head;
        //if there is only one node:
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            //cycle found
            if(slow==fast){
                break;
            }
        }
        //if no cycle fast reaches end
        if(fast==null||fast.next==null) return null;
        // if head is start point of the cycle
        if(fast==head) return head;
        //Reset slow and increase slow and fast at same space
        slow=head;
        while(slow!=fast){
            slow=slow.next;
            fast=fast.next;
        }
        return slow;
    }
}