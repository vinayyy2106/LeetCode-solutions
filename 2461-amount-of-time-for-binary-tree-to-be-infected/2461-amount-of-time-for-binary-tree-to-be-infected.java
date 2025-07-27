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
    public int amountOfTime(TreeNode root, int start) {
        Map<Integer,List<Integer>> mp=new HashMap<>();
        int min=0;
        formMap(root,-1,mp);
        Queue<Integer> q=new LinkedList<>();
        q.offer(start);
        Set<Integer> vis = new HashSet<>();
        vis.add(start);
        while(!q.isEmpty()){
            int n=q.size();
            while(n-- > 0){
                int curr=q.poll();
                for (int neighbor : mp.getOrDefault(curr, new ArrayList<>())) {
                    if (!vis.contains(neighbor)) {
                        vis.add(neighbor);
                        q.offer(neighbor);
                    }
                }
            }
            if (!q.isEmpty()) min++;
        }
        return min;
    }
    public void formMap(TreeNode root,int parent,Map<Integer,List<Integer>> mp){
        if (root == null) return;
        mp.putIfAbsent(root.val, new ArrayList<>());
        if (parent != -1) {
            mp.get(root.val).add(parent);
            mp.get(parent).add(root.val);
        }
        if(root.left!=null){
            formMap(root.left, root.val, mp);
        }
        if(root.right!=null){
            formMap(root.right, root.val, mp);
        } 
    }
}