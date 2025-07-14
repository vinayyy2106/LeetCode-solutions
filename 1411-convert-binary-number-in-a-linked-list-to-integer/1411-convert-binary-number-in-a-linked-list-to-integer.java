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
    public int getDecimalValue(ListNode head) {
        int len=0;
        ListNode temp=head;
        ListNode temp2=head;
        while(temp!=null){
            len++;
            temp=temp.next;
        }
        int val=0;
        len=len-1;
        while(len>=0){
            if(temp2.val!=0){
              val+=Math.pow(2,len);
            }
            temp2=temp2.next;
            len--;
        }
        return val;
    }
}