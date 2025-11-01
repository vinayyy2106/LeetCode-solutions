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
    public ListNode modifiedList(int[] nums, ListNode head) {
        Set<Integer> set=new HashSet<>();
        for(int num:nums)set.add(num);
        ListNode pre=new ListNode(-1);
        pre.next=head;
        ListNode prev=pre;
        ListNode curr=head;
        while(curr!=null){
            if(set.contains(curr.val)){

                prev.next=curr.next;
                curr=prev.next;
                continue;
            }
            prev=curr;
            curr=curr.next;
        }
        return pre.next;
    }
}