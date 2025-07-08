class Solution {
    public int findCircleNum(int[][] isConnected) {
        ArrayList<ArrayList<Integer>> adjList=new ArrayList<ArrayList<Integer>>();
        int l=isConnected.length;
        for(int i=0;i<l;i++){
            adjList.add(new ArrayList<>());
        }
        for(int i=0;i<l;i++){
            for(int j=0;j<l;j++){
                if(isConnected[i][j]==1 ){
                    adjList.get(i).add(j);
                    adjList.get(j).add(i);
                }
            }
        }
        int[] vis=new int[l];
        int count=0;
        for(int i=0;i<l;i++){
            if(vis[i]!=1){
                dfs(i,vis,adjList);
                count++;
            }
        }
        return count;
    }
    private void dfs(int vertice,int[] visited,ArrayList<ArrayList<Integer>> adjList){
        visited[vertice]=1;
        for(Integer val:adjList.get(vertice)){
            if(visited[val]!=1){
                dfs(val,visited,adjList);
            }
        }
    }
}