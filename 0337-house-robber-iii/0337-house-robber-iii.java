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
    private Map<TreeNode, Integer> memo = new HashMap<>();
    public int rob(TreeNode root) {
        return helper(root);
    }
    public int helper(TreeNode root){
        if(root==null)return 0;
        if(memo.containsKey(root))return memo.get(root);
        int left=0;
        int right=0;
        if(root.left!=null){
            left=helper(root.left.left);
            left+=helper(root.left.right);
        }
        if(root.right!=null){
            right=helper(root.right.right);
            right+=helper(root.right.left);
        }
        int notRob=helper(root.left)+helper(root.right);
        int res=Math.max(root.val+right+left,notRob);
        memo.put(root,res);
        return res;
    }
}