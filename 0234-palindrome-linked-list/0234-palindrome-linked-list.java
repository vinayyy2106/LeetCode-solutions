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
    public boolean isPalindrome(ListNode head) {
        ListNode slow=head;
        ListNode fast=head;
        while(fast!=null && fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }
        ListNode prev=null;
        while(slow!=null){
            ListNode nex=slow.next;
            slow.next=prev;
            prev=slow;
            slow=nex;
        }
        ListNode temp=head;
        ListNode temp1=prev;
        while(temp1!=null){
            if(temp.val!=temp1.val)return false;
            temp=temp.next;
            temp1=temp1.next;
        }
        return true;
    }
}