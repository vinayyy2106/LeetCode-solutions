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
    public void reorderList(ListNode head) {
        ListNode firHead=head;
        ListNode midNode=middleNode(head);
        ListNode secHead=reverseList(midNode);
        while(firHead!=null && secHead!=null){
            ListNode temp=firHead.next;
            firHead.next=secHead;
            firHead=temp;
            temp=secHead.next;
            secHead.next=firHead;
            secHead=temp;
        }
        if(firHead!=null){
            firHead.next=null;
        }
    }
    static ListNode middleNode(ListNode head) {
        ListNode slow=head;
        ListNode fast=head;
        while(fast!=null && fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }
        return slow;
    }
    public ListNode reverseList(ListNode head) {
        if(head==null){
            return head;
        }
        ListNode prev=null;
        ListNode pres=head;
        ListNode nex=pres.next;
        while(pres!=null){
            pres.next=prev;
            prev=pres;
            pres=nex;
            if(nex!=null){
                nex=nex.next;
            }
            
        }
        return prev;
    }
}