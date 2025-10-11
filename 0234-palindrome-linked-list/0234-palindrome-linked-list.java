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
        if(head.next==null){
            return true;
        }
        ListNode mid=middleNode(head);
        ListNode secondHead=reverseList(mid);
        ListNode reReversal=secondHead;
        while(head!=null && secondHead!=null){
            if(head.val!=secondHead.val){
                // break;
                return false;
            }
            head=head.next;
            secondHead=secondHead.next;
        }
        // reverseList(reReversal);
        // if(secondHead==null){
        //     return true;
        // }
        return true;
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
    static ListNode reverseList(ListNode head) {
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
                nex=pres.next;
            }
            
        }
        return prev;
    }
}