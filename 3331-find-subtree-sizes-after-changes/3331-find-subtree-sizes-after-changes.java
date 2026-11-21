class Solution {
    int[] resultSize; // to store subTree size
    int[] last;// to store last time where char was seen
    List<List<Integer>> li;
    int n;
    public int[] findSubtreeSizes(int[] parent, String s) {
        n=parent.length;
        resultSize=new int[n];
        last=new int[26];//26 alpahabets
        li=new ArrayList<>();
        for(int i=0;i<n;i++){
             resultSize[i]=1;
             li.add(new ArrayList<>());
        }
        Arrays.fill(last,-1);
        for(int i=0;i<n;i++){
            int u=parent[i];
            int v=i;
            if(u!=-1)li.get(u).add(v);
        }
        dfs(parent,0,s);
        return resultSize; 
    }
    public void dfs(int[] parent,int currNode,String s){
        int ch = s.charAt(currNode)-'a';
        int nearestNeigh = last[ch];
        last[ch]=currNode;
        for(int child:li.get(currNode))dfs(parent,child,s);
        last[ch]=nearestNeigh;
        if(currNode!=0){
            int newParent=parent[currNode];
            if(nearestNeigh!=-1){
                newParent=nearestNeigh;
            }
            parent[currNode]=newParent;
            resultSize[newParent]+=resultSize[currNode];
        }
    }
}