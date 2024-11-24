/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1==null){
            return list2;
        }
        if(list2==null){
            return list1;
        }
        ListNode cur1=null;
        ListNode cur2=list2;
        while(cur2!=null){
            if(cur1==null){
                if(list1.val>cur2.val){
                    ListNode temp=list1;
                    list1=cur2;
                    ListNode temp2=cur2.next;
                    cur2.next=temp;
                    cur1=list1;
                    cur2=temp2;
                }
                else{
                    cur1=list1;
                }
            }
            else{
                if(cur1.next.val>cur2.val){
                    ListNode temp=cur1.next;
                    cur1.next=cur2;
                    ListNode temp2=cur2.next;
                    cur2.next=temp;
                    cur1=cur1.next;
                    cur2=temp2;
                }
                else{
                    cur1=cur1.next;
                }
            }
            if(cur1.next==null) break;
        }
        if(cur2!=null) {
            cur1.next=cur2;
        }
        return list1;
    }
}