class Solution {
    public int findMaximumXOR(int[] nums) {
        Trie v=new Trie();
        int max=0;
        for(int num:nums){
            v.insert(num);
        }
        for(int num:nums){
            max=Math.max(max,v.getMax(num));
        }
        return max;
    }
}
class Node{
    Node links[]=new Node[2];
    public boolean containsKey(int bit){
        return links[bit]!=null;
    }
    public void put(int bit,Node node){
        links[bit]=node;
    }
    public Node get(int bit){
        return links[bit];
    }
}
class Trie{
    Node root;
    public Trie(){
        root=new Node();
    }
    public void insert(int ele){
        Node node=root;
        for(int i=31;i>=0;i--){
            int bit=(ele >> i) & 1;
            if(!node.containsKey(bit)){
                node.put(bit,new Node());
            }
            node=node.get(bit);
        }
    }
    public int getMax(int num){
        Node node=root;
        int maxNo=0;
        for(int i=31;i>=0;i--){
            int bit=(num>>i) & 1;
            if(node.containsKey(1-bit)){
                maxNo |= (1 << i);
                node = node.get(1 - bit);
            }else{
                node=node.get(bit);
            }
        }
        return maxNo;
    }
}