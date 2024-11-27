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
import java.util.*;
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length==0) return null;
        if(lists.length==1) return lists[0];
        ListNode head=null,cur=null;
        int k=0;
        while(k<lists.length && head==null){
            cur=lists[k];
            head=lists[k];
            k++;
        }

        if(head==null) return null;

        ArrayList<ListNode> temp;

        for(int i=k;i<lists.length;i++){
            while (cur.next!=null) {
                cur=cur.next;
            }
            if(lists[i]!=null)
                cur.next=lists[i];
        }
    
        //storing and sorting nodes using treemap
        SortedMap<Integer,ArrayList<ListNode>> klists=new TreeMap<Integer,ArrayList<ListNode>>();
        cur=head;
        while(cur!=null){
            temp=klists.getOrDefault(cur.val, new ArrayList<ListNode>());
            temp.add(cur);
            klists.put(cur.val,temp);
            cur=cur.next;
        }
        head=null;
        cur=null;
        while(!klists.isEmpty()){
            temp=klists.pollFirstEntry().getValue();
            if(head==null){
                head=temp.get(0);
                temp.remove(0);
                cur=head;
            }
            for(ListNode i: temp){
                cur.next=i;
                cur=cur.next;
            }
            
        }
        cur.next=null;
        return head;
    }
}