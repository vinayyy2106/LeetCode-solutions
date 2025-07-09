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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode newList=new ListNode(-1);
        ListNode temp=newList;
        int carry=0;
        int sum=0;
        int digit=0;
        while(l1!=null && l2!=null){
            sum=l1.val+l2.val+carry;
            carry=sum/10;
            sum=sum%10;
            temp.next=new ListNode(sum);
            temp=temp.next;
            l1=l1.next;
            l2=l2.next;
        }
        
        while(l1!=null){
            digit=l1.val+carry;
            carry=digit/10;
            digit=digit%10;
            temp.next=new ListNode(digit);
            temp=temp.next;
            l1=l1.next;
            // l2=l2.next;
        }
        while(l2!=null){
            digit=l2.val+carry;
            carry=digit/10;
            digit=digit%10;
            temp.next=new ListNode(digit);
            temp=temp.next;
            l2=l2.next;
        }
        if(carry>0){
            temp.next=new ListNode(carry);
        }
        return newList.next;
        
    }
}