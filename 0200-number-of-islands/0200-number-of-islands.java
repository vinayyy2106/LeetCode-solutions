class Solution {
    int n;
    int m;
    int[][] vis;
    int[] delRow={-1,0,1,0};
    int[] delCol={0,1,0,-1};
    public int numIslands(char[][] grid) {
        n=grid.length;
        m=grid[0].length;
        vis=new int[n][m];
        int count=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]=='1' && vis[i][j]==0){
                    count++;
                    dfs(grid,i,j);
                }
            }
        }
        return count;
    }
    public void dfs(char[][] grid,int i,int j){
        vis[i][j]=1;
        for(int k=0;k<4;k++){
            int newRow=i+delRow[k];
            int newCol=j+delCol[k];
            if(newRow>=0 && newRow<n && newCol>=0 && newCol<m && vis[newRow][newCol]==0 && grid[newRow][newCol]=='1'){
                dfs(grid,newRow,newCol);
            }
        }
    }
}