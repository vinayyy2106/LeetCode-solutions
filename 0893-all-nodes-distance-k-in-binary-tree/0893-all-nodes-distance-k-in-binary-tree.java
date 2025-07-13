/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Map<TreeNode,TreeNode> map=new HashMap<>();
        getParents(root,map);
        Map<TreeNode,Boolean> map1=new HashMap<>();
        Queue<TreeNode> q=new LinkedList<>();
        q.offer(target);
        map1.put(target,true);
        int count=0;
        while(!q.isEmpty()){
            int size=q.size();
            if(count==k)break;
            count++;
            for(int i=0;i<size;i++){
                TreeNode node=q.poll();
                if(node.left!=null && map1.get(node.left)==null){
                    q.add(node.left);
                    map1.put(node.left,true);
                }
                if(node.right!=null && map1.get(node.right)==null){
                    q.add(node.right);
                    map1.put(node.right,true);
                }
                if(map.get(node)!=null && map1.get(map.get(node))==null){
                    q.add(map.get(node));
                    map1.put(map.get(node),true);
                }
            }

        }
        List<Integer> li=new ArrayList<>();
        while(!q.isEmpty()){
            TreeNode node=q.poll();
            li.add(node.val);
        }
        return li;
    }
    public void getParents(TreeNode root,Map<TreeNode,TreeNode> mp){
        Queue<TreeNode> q=new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            TreeNode node=q.poll();
            if(node.left!=null){
                q.offer(node.left);
                mp.put(node.left,node);//node,parent
            }
            if(node.right!=null){
                q.offer(node.right);
                mp.put(node.right,node);//node,parent
            }
        }
    }
}