class Solution {
    public int[][] directions={{1,1},{1,-1},{-1,-1},{-1,1}};
    public int lenOfVDiagonal(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int res=0;
        int[][][][] dp;
        dp = new int[m][n][4][2]; // initialize memo table
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int d = 0; d < 4; d++) {
                    for (int c = 0; c < 2; c++) {
                        dp[i][j][d][c] = -1;
                    }
                }
            }
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1){
                    for(int d=0;d<4;d++){
                        boolean canChangeDirec=true;
                        res=Math.max(res,1+solve(i,j,d,canChangeDirec,2,grid,dp));
                    }
                }
            }
        }
        return res;
    }
    public int solve(int i,int j,int d,boolean check,int nextExpValue,int[][] grid,int[][][][] dp){
        int i1=i+directions[d][0];
        int j1=j+directions[d][1];
        if(i1<0 || j1<0 || i1>=grid.length || j1>=grid[0].length || grid[i1][j1]!=nextExpValue){
            return 0;
        }
        int c = check ? 1 : 0;
        if(dp[i1][j1][d][c]!=-1)return dp[i1][j1][d][c];
        int length=0;
        int keepMoving=1+solve(i1,j1,d,check,nextExpValue==2?0:2,grid,dp);
        length=Math.max(length,keepMoving);
        if(check){
            int maxValue=1+solve(i1,j1,(d+1)%4,false,nextExpValue==2?0:2,grid,dp);
            length=Math.max(length,maxValue);
        }
        return dp[i1][j1][d][c]=length;
    }
}