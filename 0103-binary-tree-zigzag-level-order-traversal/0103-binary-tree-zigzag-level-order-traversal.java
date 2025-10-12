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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> lists=new ArrayList<>();
        if (root == null) return lists; 
        Queue<TreeNode> q=new LinkedList<>();
        q.offer(root);
        int l=0;
        while(!q.isEmpty()){
            List<Integer> li=new ArrayList<>();
            int size=q.size();
            for(int i=0;i<size;i++){
                TreeNode nd=q.poll();
                if(l%2==0){
                    li.add(nd.val);
                }else{
                    li.add(0,nd.val);
                }
                if(nd.left!=null)q.offer(nd.left);
                if(nd.right!=null)q.offer(nd.right);
            }
            l++;
            lists.add(li);
        }
        return lists;
    }
}