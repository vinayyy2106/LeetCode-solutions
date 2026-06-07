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
    public TreeNode createBinaryTree(int[][] descriptions) {
        Map<Integer, TreeNode> nodes = new HashMap<>();
        Set<Integer> set=new HashSet<>();
        for(int[] d:descriptions){
            int parent = d[0];
            int child = d[1];
            int isLeft = d[2];
            nodes.putIfAbsent(parent, new TreeNode(parent));
            nodes.putIfAbsent(child, new TreeNode(child));
            if(isLeft==1){
                nodes.get(parent).left=nodes.get(child);
            }else{
                nodes.get(parent).right=nodes.get(child);
            }
            set.add(child);
        }
         for (int val:nodes.keySet()) {
            if(!set.contains(val))return nodes.get(val);
         }
         return null;
    }
}
class Pair{
    TreeNode node;
    TreeNode left;
    TreeNode right;
    public Pair(TreeNode node,TreeNode left,TreeNode right){
        this.node=node;
        this.left=left;
        this.right=right;
    }
}