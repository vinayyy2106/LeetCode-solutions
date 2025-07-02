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
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> list=new ArrayList<>();
        if(root==null) return list;
        TreeMap<Integer,TreeMap<Integer,PriorityQueue<Integer>>> mp=new TreeMap<>();
        Queue<Tuple> q=new LinkedList<>();
        q.offer(new Tuple(root,0,0));
        while(!q.isEmpty()){
            Tuple tp=q.poll();
            TreeNode nd=tp.node;
            int row=tp.level;
            int col=tp.order;
            if(!mp.containsKey(row)){
                mp.put(row,new TreeMap<>());
            }
            if(!mp.get(row).containsKey(col)){
                mp.get(row).put(col,new PriorityQueue<>());
            }
            mp.get(row).get(col).offer(nd.val);
            if(nd.left!=null){
                q.offer(new Tuple(nd.left,row-1,col+1));
            }
            if(nd.right!=null){
                q.offer(new Tuple(nd.right,row+1,col+1));
            }
            
        }
        
        for(TreeMap<Integer,PriorityQueue<Integer>> a:mp.values()){
                list.add(new ArrayList<>());
                for(PriorityQueue<Integer> nodes:a.values()){
                    while(!nodes.isEmpty()){
                        list.get(list.size()-1).add(nodes.poll());
                    }
                    
                }
        }
        return list;
    }
}
class Tuple{
    TreeNode node;
    int level;
    int order;
    Tuple(TreeNode node,int level,int order){
        this.node=node;
        this.level=level;
        this.order=order;
    }
}