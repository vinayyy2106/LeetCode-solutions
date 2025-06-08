/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode slow=head;
        ListNode fast=head;
        ListNode temp=head;
        ListNode temp1=head;
        int len=0;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast){
                do{
                    slow=slow.next;
                    len++;
                }while(slow!=fast);
                break;
            }
            
        }
        if(len==0){
                return null;
            }
            while(len>0){
                temp=temp.next;
                len--;
            }
            while(temp!=temp1){
                temp=temp.next;
                temp1=temp1.next;
            }
            return temp;

    }
}