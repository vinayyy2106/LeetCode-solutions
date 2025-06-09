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
        //better approach is using hashmap to store copied nodes first nd then linking here I'm solving optimal approach
        Node temp=head;
        while(temp!=null){
            Node dummy=new Node(temp.val);
            dummy.next=temp.next;
            temp.next=dummy;
            temp=temp.next.next;
        }
        temp=head;
        while(temp!=null){
            Node copyNode=temp.next;
            if(temp.random!=null){
                copyNode.random=temp.random.next;
            }else{
                copyNode.random=null;
            }
            
            temp=temp.next.next;
        }
        temp=head;
        Node newhead=new Node(-1);
        Node res=newhead;
        while(temp!=null){
            res.next=temp.next;
            temp.next=temp.next.next;
            res=res.next;
            temp=temp.next;
        }
        return newhead.next;
    }
}