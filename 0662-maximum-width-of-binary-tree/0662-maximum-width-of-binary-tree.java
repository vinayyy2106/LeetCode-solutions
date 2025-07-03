/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        int ans=0;
        Queue<Pair> q=new LinkedList<>();
        q.offer(new Pair(root,0));
        while(!q.isEmpty()){
            int size=q.size();
            int min=q.peek().num;
            int first=0;
            int last=0;
            for(int i=0;i<size;i++){
                Pair val=q.poll();
                int curr=val.num-min;
                if(i==0)first=val.num;
                if(i==size-1)last=val.num;
                if(val.node.left!=null){
                    q.offer(new Pair(val.node.left,2*curr+1));
                }
                if(val.node.right!=null){
                    q.offer(new Pair(val.node.right,2*curr+2));
                }
            }
            ans=Math.max(ans,last-first+1);
        }
        return ans;
    }
}
class Pair{
    TreeNode node;
    int num;
    Pair(TreeNode node,int num){
        this.node=node;
        this.num=num;
    }
}