class Solution {
    int[][] dirs = { { 0, -1 }, { 0, 1 }, { -1, 0 }, { 1, 0 }};
    public boolean containsCycle(char[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        boolean[] vis=new boolean[m*n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(!vis[i*n +j] && dfs(vis,m,n,i,j,-1,-1,grid))return true;
            }
        }
        return false;
    }
    public boolean dfs(boolean[] vis,int m,int n,int r,int c,int pr,int pc,char[][] grid){
        vis[r*n+c]=true;
        for(int k=0;k<4;k++){
            int nrow=r+dirs[k][0];
            int ncol=c+dirs[k][1];
            if(nrow!=pr || ncol!=pc){
                if(nrow>=0 && nrow<m && ncol>=0 && ncol<n){
                    if(grid[nrow][ncol]==grid[r][c]){
                        if(vis[nrow * n + ncol] || dfs(vis,m,n,nrow,ncol,r,c,grid)){
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }
}