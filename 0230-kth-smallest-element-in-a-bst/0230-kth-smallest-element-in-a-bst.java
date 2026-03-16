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
    private int count=0;
    public int kthSmallest(TreeNode root, int k) {
        return smallest(root,k).val;
    }
    public TreeNode smallest(TreeNode root,int val){
        if(root==null){
            return null;
        }
        
        TreeNode left=smallest(root.left,val);
        
        
        count++;
        if(count==val){
            return root;
        }
        if(left!=null){
            return left;
        }
        return smallest(root.right,val);

    }
}