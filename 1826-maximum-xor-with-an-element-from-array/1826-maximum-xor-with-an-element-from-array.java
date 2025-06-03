class Solution {
    public int[] maximizeXor(int[] nums, int[][] queries) {
        Arrays.sort(nums);
        List<List<Integer>> list=new ArrayList<>();
        int n=queries.length;
        for(int i=0;i<n;i++){
            List<Integer> a=new ArrayList<>();
            a.add(i);
            a.add(queries[i][0]);
            a.add(queries[i][1]);
            list.add(a);
        }
        Collections.sort(list,(a, b) -> Integer.compare(a.get(a.size() - 1), b.get(b.size() - 1)));
        int m=list.size();
        int k=nums.length;
        int ind=0;
        Trie tr=new Trie();
        int[] res=new int[n];
        for(int i=0;i<m;i++){
            int index=list.get(i).get(0);
            int valueForChecking=list.get(i).get(1);
            int checkTill=list.get(i).get(2);
            while(ind<k && nums[ind]<=checkTill){
                tr.insert(nums[ind]);
                ind++;
            }
            if(ind==0)res[index]=-1;
            else res[index]=tr.getMax(valueForChecking);
        }
        return res;
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