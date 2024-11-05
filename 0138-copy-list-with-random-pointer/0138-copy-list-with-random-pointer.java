/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if(head==null)
            return null;

        // Node new_head=new Node(head.val);
        HashMap <Node,Node>hs=new HashMap<>();
        Node cur=head;
        
        while(cur!=null){           
            Node newNode =new Node(cur.val);
            hs.put(cur, newNode);
            cur=cur.next;
        }
        for(Node k:hs.keySet()) {
           Node newCur=hs.get(k);
           newCur.next=hs.get(k.next);
           newCur.random=hs.get(k.random); 
        }
        Node new_head= hs.get(head);
        return new_head;
    }
}