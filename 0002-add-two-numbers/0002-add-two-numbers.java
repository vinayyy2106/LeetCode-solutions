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
        ListNode temp=new ListNode(-1);
        ListNode res=temp;
        int carry=0;
        while(l1!=null &&l2!=null){
            int sum=l1.val+l2.val+carry;
            carry=sum/10;
            sum%=10;
            ListNode node=new ListNode(sum);
            res.next=node;
            res=res.next;
            l1=l1.next;
            l2=l2.next;
        }
        while(l1!=null){
            int digit=l1.val+carry;
            carry=digit/10;
            digit=digit%10;
            ListNode li=new ListNode(digit);
            res.next=li;
            res=res.next;
            l1=l1.next;
        }
        while(l2!=null){
            int digit=l2.val+carry;
            carry=digit/10;
            digit=digit%10;
            ListNode li=new ListNode(digit);
            res.next=li;
            res=res.next;
            l2=l2.next;
        }
        if(carry>0){
            ListNode last=new ListNode(carry);
            res.next=last;
        }
        return temp.next;
    }
}