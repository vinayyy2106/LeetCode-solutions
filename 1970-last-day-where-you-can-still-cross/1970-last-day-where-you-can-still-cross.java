class Solution {
    int ROW=0;
    int COL=0;
    int[][] dir={{1,0},{-1,0},{0,1},{0,-1}};
    public int latestDayToCross(int row, int col, int[][] cells) {
        ROW=row;
        COL=col;
        int l=0;
        int r=cells.length-1;
        int lastDay=0;
        while(l<=r){
            int mid=l+(r-l)/2;
            if(canCross(cells,mid)){
                lastDay=mid;
                l=mid+1;
            }else{
                r=mid-1;
            }
        }
        return lastDay;
    }
    public boolean canCross(int[][] cells,int mid){
        int[][] grid=new int[ROW][COL];
        for(int i=0;i<mid;i++){
            int x=cells[i][0]-1;
            int y=cells[i][1]-1;
            grid[x][y]=1;
        }
        for(int col=0;col<COL;col++){
            if(grid[0][col]==0 && dfs(grid,0,col)){
                return true;
            }
        }
        return false;
    }
    public boolean dfs(int[][] grid,int i,int j){
        if(i<0 || j<0 || i>=ROW || j>=COL || grid[i][j]==1)return false;
        if(i==ROW-1)return true;
        grid[i][j]=1;
        for(int k=0;k<4;k++){
            int new_i=i+dir[k][0];
            int new_j=j+dir[k][1];
            if(dfs(grid,new_i,new_j)){
                return true;
            }
        }
        return false;
    }
}