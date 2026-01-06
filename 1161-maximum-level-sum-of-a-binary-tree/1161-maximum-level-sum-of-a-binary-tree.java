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
    public int maxLevelSum(TreeNode root) {
        Queue<TreeNode> q=new LinkedList<TreeNode>();
        int currLevel=0;
        int result=0;
        int sum=Integer.MIN_VALUE;
        q.offer(root);
        while(!q.isEmpty()){
            int size=q.size();
            int currSum=0;
            currLevel++;
            for(int i=0;i<size;i++){
                TreeNode node=q.poll();
                if(node.left!=null)q.offer(node.left);
                if(node.right!=null)q.offer(node.right);
                currSum+=node.val;
            }
            if(currSum>sum){
                sum=currSum;
                result=currLevel;
            }
        }
        return result;
    }
}