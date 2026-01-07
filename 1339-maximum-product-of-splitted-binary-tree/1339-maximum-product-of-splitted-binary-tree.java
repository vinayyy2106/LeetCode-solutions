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
    long maxP=0;
    long totSum=0;
    long M = 1000000007;
    public int totalSum(TreeNode root){
        if(root==null)return 0;
        return root.val+totalSum(root.left)+totalSum(root.right);
    }
    public int maxProduct(TreeNode root) {
        if(root==null)return 0;
        totSum=totalSum(root);
        findMaxProduct(root);
        return (int)(maxP % M);
    }
    public int findMaxProduct(TreeNode root){
        if(root==null)return 0;
        int subTreeSum=root.val+findMaxProduct(root.left)+findMaxProduct(root.right);
        maxP=Math.max(maxP,(totSum-subTreeSum)*(subTreeSum));
        return subTreeSum;
    }
}