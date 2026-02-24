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
    public int sumRootToLeaf(TreeNode root) {
        
        return solve(root,0);
    }
    public int solve(TreeNode node,int curr){
        if(node==null)return 0;
        curr=curr*2 + node.val;
        if(node.left==node.right)return curr;
        return solve(node.left,curr)+solve(node.right,curr);
    }
}