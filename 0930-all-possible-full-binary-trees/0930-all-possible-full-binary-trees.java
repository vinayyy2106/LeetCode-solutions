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
    public List<TreeNode> allPossibleFBT(int n) {
        Map<Integer,List<TreeNode>> dp=new HashMap<>();
        return solve(n,dp);
    }
    public List<TreeNode> solve(int n,Map<Integer,List<TreeNode>> mp){
        if(n%2==0)return new ArrayList<>();
        if(n==1){
            TreeNode nd=new TreeNode(0);
            return new ArrayList<>(Arrays.asList(nd));
        }
        if(mp.get(n)!=null)return mp.get(n);
        List<TreeNode> res=new ArrayList<>();
        for(int i=1;i<n;i+=2){
            List<TreeNode> leftArr=solve(i,mp);
            List<TreeNode> rightArr=solve(n-i-1,mp);
            for(TreeNode left:leftArr){
                for(TreeNode right:rightArr){
                    TreeNode root=new TreeNode(0);
                    root.left=left;
                    root.right=right;
                    res.add(root);
                }
            }
        }
        mp.put(n,res);
        return res;
    }
}