class Solution {
    public boolean isBipartite(int[][] graph) {
        int m=graph.length;
        int[] color=new int[m];
        Arrays.fill(color,-1);
        for(int i=0;i<m;i++){
            if(color[i]==-1){
                if(!dfs(i,graph,color,0)){
                    return false;
                }
            }
        }
        return true;
    }
    public boolean dfs(int node,int[][] graph,int[] color,int c){
        color[node]=c;
        for(int n:graph[node]){
            if(color[n]==-1){
                if(!dfs(n,graph,color,1-c)){
                    return false;
                }
            }else if(color[n]==c)return false;
        }
        return true;
    }
}