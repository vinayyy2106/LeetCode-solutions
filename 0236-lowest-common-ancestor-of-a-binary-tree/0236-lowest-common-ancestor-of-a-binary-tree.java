/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 //catch here was if we find p on left and could not find q on right so it means q is below and p is the common ancestor now so no need of searching beelow
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q){
        if(root==null){
            return null;
        }
        if (root==p || root==q){
            return root;
        }
        TreeNode left=lowestCommonAncestor(root.left,p,q);
        TreeNode right=lowestCommonAncestor(root.right,p,q);
        if(left==null && right!=null){
            return right;
        }
        if(left!=null && right==null){
            return left;
        }
        if(left!=null && right!=null){
            return root;
        }
        return null;
    }
}