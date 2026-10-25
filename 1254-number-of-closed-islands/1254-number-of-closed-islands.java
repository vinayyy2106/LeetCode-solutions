class Solution {
    int m,n;
    int[] delRow={-1,0,1,0};
    int[] delCol={0,1,0,-1};
    int[][] vis;
    public int closedIsland(int[][] grid) {
        m=grid.length;
        n=grid[0].length;
        vis=new int[m][n];
        int count=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(vis[i][j]==0 && grid[i][j]==0){
                    if(dfs(grid,i,j))count++;  
                }
            }
        }
        return count;
    }
    public boolean dfs(int[][] grid,int i,int j){
        if(i<0 || j<0 || i>=m || j>=n)return false;
        if(grid[i][j]==1 || vis[i][j]==1)return true;
        vis[i][j]=1;
        boolean isClosed=true;
        for(int k=0;k<4;k++){
            int m=i+delRow[k];
            int n=j+delCol[k];
            if(!dfs(grid,m,n))isClosed=false;// to traverse all the cells even in case of boundary return is false
        }
        return isClosed;
    }
}