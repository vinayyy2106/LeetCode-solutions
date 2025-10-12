class Solution {
    public int numIslands(char[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int[][] vis=new int[n][m];
        int count=0;
        int[] delRow={-1,0,1,0};
        int[] delCol={0,1,0,-1};
        Queue<int[]> q=new LinkedList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]=='1' && vis[i][j]!=1){
                    vis[i][j]=1;
                    q.offer(new int[]{i,j});
                    count++;
                    while(!q.isEmpty()){
                        int[] arr=q.poll();
                        int row=arr[0];
                        int col=arr[1];
                        for(int k=0;k<4;k++){
                            int nrow=delRow[k]+row;
                            int ncol=delCol[k]+col;
                            if(nrow>=0 && nrow<n && ncol<m && ncol>=0 && vis[nrow][ncol]!=1 && grid[nrow][ncol]=='1'){
                                vis[nrow][ncol]=1;
                                q.offer(new int[]{nrow,ncol});
                            }
                        }
                    }
                }
            }
        }
        return count;
    }
}