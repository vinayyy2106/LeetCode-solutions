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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head==null){
            return head;
        }
        ListNode temp=head;
        ListNode temp2=head;
        int i=0;
        
        while(temp!=null){
            i++;
            temp=temp.next;
            }
        if(n==i){
            return head.next;
        }
        int count=1;
        int len=i-n;
        while(len>1){
            temp2=temp2.next;
            len--;
        }
        if(temp2.next!=null){
            temp2.next=temp2.next.next;
        }
        return head;
    }
}