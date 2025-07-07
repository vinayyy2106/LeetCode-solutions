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
    public boolean findTarget(TreeNode root, int k) {
        HashSet<Integer> set=new HashSet<>();
        return helper(set,k,root);
    }
    public boolean helper(HashSet<Integer> set,int n,TreeNode t){
        if(t==null)return false;
        if(set.contains(n-t.val)){
            return true;
        }else{
            set.add(t.val);
        }
        return helper(set,n,t.left)||helper(set,n,t.right);
    }
}