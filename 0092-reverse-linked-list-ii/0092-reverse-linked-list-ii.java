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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode temp=head;
        ListNode dummy=new ListNode(-1);
        dummy.next=temp;
        ListNode prev=dummy;
        for(int i=1;i<left;i++){
            prev=prev.next;//left-1th node
        }
        ListNode pres=prev.next;
        ListNode dhead=null;
        ListNode dtail=null;
        for(int i=0;i<right-left+1;i++){
            ListNode fut=pres.next;
            if(dhead==null){
                dhead=pres;
                dtail=pres;
            }else{
                pres.next=dhead;
                dhead=pres;
            }
            pres=fut;
        }
        prev.next=dhead;
        dtail.next=pres;
        return dummy.next;
    }

}