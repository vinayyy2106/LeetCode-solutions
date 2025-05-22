class Solution {
    public int minPathSum(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int[][] dp=new int[m][n];
        for (int[] row : dp) Arrays.fill(row, -1);
        return noOfPaths(m-1,n-1,dp,grid);
    }
    public int noOfPaths(int i,int j,int[][] dp,int[][] grid){
        if(i==0 && j==0){
            return grid[i][j];
        }
        if(i<0 || j<0){
            return (int)1e9;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        int up=grid[i][j]+noOfPaths(i-1,j,dp,grid);
        int down=grid[i][j]+noOfPaths(i,j-1,dp,grid);
        dp[i][j]=Math.min(up,down);
        return dp[i][j];
    }
}