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
    public ListNode partition(ListNode head, int x) {
        ListNode head1=new ListNode(-1);
        ListNode head2=new ListNode(-1);
        ListNode temp1=head1;
        ListNode temp2=head2;
        ListNode temp=head;
        while(temp!=null){
            if(temp.val<x){
                head1.next=temp;
                head1=head1.next;
            }else{
                head2.next=temp;
                head2=head2.next;
            }
            temp=temp.next;
        }
        head2.next=null;
        head1.next=temp2.next;
        return temp1.next;
        
    }
}