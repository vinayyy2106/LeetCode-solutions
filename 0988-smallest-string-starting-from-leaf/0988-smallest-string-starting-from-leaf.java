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
    StringBuilder s1=new StringBuilder("");
    public String smallestFromLeaf(TreeNode root) {
        helper(root,"");
        return s1.toString();
    }
    public void helper(TreeNode root,String str){
        if(root==null)return;
        if(root.left==null && root.right==null){
            StringBuilder st = new StringBuilder((char)('a' + root.val) + str);
            if (s1.length() == 0 || s1.compareTo(st) > 0) {
                s1 = st;
            }
            return;
        }
        helper(root.left,(char)('a' + root.val)+str);
        helper(root.right,(char)('a' + root.val)+str);
    }
}