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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> li=new ArrayList<>();
        helper(root,li,"");
        return li;
    }
    public void helper(TreeNode root,List<String> li,String str){
        if(root.left==null && root.right==null){
            li.add(str+root.val);
            return;
        }
        if(root.left!=null)helper(root.left,li,str+root.val+"->");
        if(root.right!=null)helper(root.right,li,str+root.val+"->");
    }
}