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
    public TreeNode bstFromPreorder(int[] preorder) {
        return helper(new int[1],preorder,Integer.MAX_VALUE,Integer.MIN_VALUE);
    }
    public TreeNode helper(int[] index,int[] preorder,int upper,int lower){
        if(index[0]==preorder.length)return null;
        if(preorder[index[0]]>upper || preorder[index[0]]<lower)return null;//cannot b placed
        TreeNode root=new TreeNode(preorder[index[0]]);
        index[0]++;
        root.left=helper(index,preorder,root.val,lower);
        root.right=helper(index,preorder,upper,root.val);
        return root;
    }
}