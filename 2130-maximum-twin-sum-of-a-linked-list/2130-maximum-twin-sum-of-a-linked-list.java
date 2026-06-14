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
    public int pairSum(ListNode head) {
        Map<Integer,Integer> mp=new HashMap<>();
        ListNode temp=head;
        int n=0;
        while(temp!=null){
            mp.put(n,temp.val);
            temp=temp.next;
            n++;
        }
        int max=Integer.MIN_VALUE;
        for(int j=0;j<n/2;j++){
            max=Math.max(max,(mp.get(j)+mp.get(n-1-j)));
        }
        return max;
    }
}