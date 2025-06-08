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
    public ListNode reverseKGroup(ListNode head, int k) {
       if(head==null || k<=1){
            return head;
        }
        ListNode h=head;
        ListNode t=head;
        int len=0;
        while(h!=null){
            h=h.next;
            len++;
        }
        h=head;
        ListNode dummy=new ListNode(-1); 
        ListNode prev=dummy; 
        ListNode pres=dummy;
        ListNode nex=dummy;
        prev.next=head; 
        while(len>=k){
            pres =prev.next;
            nex=pres.next;
            for(int i=1;i<k;i++){
                pres.next=nex.next;
                nex.next=prev.next;
                prev.next=nex;
                nex=pres.next;
            }
            prev=pres;
            len-=k;
        }
        return dummy.next;
    }
    
}