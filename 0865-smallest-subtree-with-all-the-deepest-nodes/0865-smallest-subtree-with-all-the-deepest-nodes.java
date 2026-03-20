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
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        Pair pair=helper(root);
        return pair.node;
    }
    public Pair helper(TreeNode root){
        if(root==null)return new Pair(null,0);
        Pair leftPair=helper(root.left);
        Pair rightPair=helper(root.right);

        if(leftPair.depth==rightPair.depth){
            return new Pair(root,leftPair.depth+1);
        }
        if(leftPair.depth>rightPair.depth){
            return new Pair(leftPair.node,leftPair.depth+1);
        }
        return new Pair(rightPair.node,rightPair.depth+1);
    }
}
class Pair{
    TreeNode node;
    int depth;
    public Pair(TreeNode node,int depth){
        this.node=node;
        this.depth=depth;
    }
}