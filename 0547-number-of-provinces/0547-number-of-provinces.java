class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n=isConnected.length;
        List<List<Integer>> listOfLists=new ArrayList<>();
        for(int i=0;i<n;i++){
            listOfLists.add(new ArrayList<>());
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(isConnected[i][j]==1 && i<j){
                    listOfLists.get(i).add(j);
                    listOfLists.get(j).add(i);
                }
            }
        }
        boolean[] vis=new boolean[n];
        int count=0;
        for(int i=0;i<n;i++){
            if(!vis[i]){
                dfs(i,listOfLists,vis);
                count++;
            }
        }
        return count;

    }
    public void dfs(int i,List<List<Integer>> listOfLists,boolean[] vis){
        vis[i]=true;
        for(Integer val:listOfLists.get(i)){
            if(!vis[val]){
                dfs(val,listOfLists,vis);
            }
        }
    }
}