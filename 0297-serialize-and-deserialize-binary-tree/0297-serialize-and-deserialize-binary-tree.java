/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root==null)return "";
        StringBuilder str=new StringBuilder("");
        Queue<TreeNode> q=new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            TreeNode node=q.poll();
            if(node==null){
                str.append("#,");
                continue;
            }
            str.append(node.val+",");
            q.offer(node.left);
            q.offer(node.right);

        }
        return str.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data=="")return null;
        String[] list=data.split(",");
        Queue<TreeNode> q=new LinkedList<>();
        TreeNode root=new TreeNode(Integer.parseInt(list[0]));
        q.offer(root);
        for(int i=1;i<list.length;i++){
            TreeNode node=q.poll();
            if(!list[i].equals("#")){
                TreeNode nd=new TreeNode(Integer.parseInt(list[i]));
                node.left=nd;
                q.offer(nd);
            }
            
            if(!list[++i].equals("#") && i<list.length){
                TreeNode nd=new TreeNode(Integer.parseInt(list[i]));
                node.right=nd;
                q.offer(nd);
            }
            
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));